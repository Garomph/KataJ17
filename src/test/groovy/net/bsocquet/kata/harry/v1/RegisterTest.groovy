package net.bsocquet.kata.harry.v1


import net.bsocquet.kata.harry.v1.entity.Book
import spock.lang.Specification

import static java.util.Arrays.asList
import static java.util.Collections.emptyList
import static java.util.Collections.singletonList
import static net.bsocquet.kata.harry.v1.entity.BookType.*

class RegisterTest extends Specification {

    Register register = new Register()
    static final int BOOK_PRICE = 8
    static final double espilon = 0.000001d

    def 'If there is no book, the price should be 0'() {
        when:
        Double totalPrice = register.getTotalPrice(emptyList())
        then:
        totalPrice == 0
    }

    def 'If we pass a null Parametere, the price should be 0'() {
        when:
        Double totalPrice = register.getTotalPrice(null)
        then:
        totalPrice == 0
    }

    def 'A book should cost 8$'() {
        given:
        List<Book> books = singletonList(book)
        when:
        Double totalPrice = register.getTotalPrice(books)
        then:
        totalPrice == BOOK_PRICE.toDouble()
        where:
        book             | _
        new Book(FIRST)  | _
        new Book(SECOND) | _
        new Book(THIRD)  | _
        new Book(FOURTH) | _
        new Book(FIFTH)  | _
    }

    def 'Multiple copy of a book should cost 8$ * the number of book'() {
        given:
        List<Book> books = asList(new Book(FIRST), new Book(FIRST))
        when:
        Double totalPrice = register.getTotalPrice(books)
        then:
        totalPrice == BOOK_PRICE * books.size()
    }

    def 'Buying differents books should give a discount'() {
        when:
        Double totalPrice = register.getTotalPrice(books)
        then:
        Math.abs(totalPrice - BOOK_PRICE * books.size() * discount) < espilon
        where:
        books                                                                                         || discount
        asList(new Book(FIRST), new Book(SECOND))                                                     || 0.95f
        asList(new Book(FIRST), new Book(SECOND), new Book(THIRD))                                    || 0.90f
        asList(new Book(FIRST), new Book(SECOND), new Book(THIRD), new Book(FOURTH))                  || 0.80f
        asList(new Book(FIRST), new Book(SECOND), new Book(THIRD), new Book(FOURTH), new Book(FIFTH)) || 0.75f
    }

    def 'Discount should be applied only to a set of book and not the overall price'() {
        given:
        List<Book> books = asList(new Book(FIRST), new Book(SECOND), new Book(FIRST))
        when:
        Double totalPrice = register.getTotalPrice(books)
        then:
        Math.abs(totalPrice - (BOOK_PRICE * 2 * 0.95 + BOOK_PRICE)) < espilon
    }

    def 'The best discount should be applied'() {
        given:
        List<Book> books = asList(
                new Book(FIRST), new Book(FIRST),
                new Book(SECOND), new Book(SECOND),
                new Book(THIRD), new Book(THIRD),
                new Book(FOURTH),
                new Book(FIFTH))
        when:
        Double totalPrice = register.getTotalPrice(books)
        then:
        Math.abs(totalPrice - Double.valueOf("51.2")) < espilon
    }
}
