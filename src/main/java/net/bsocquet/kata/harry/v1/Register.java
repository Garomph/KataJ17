package net.bsocquet.kata.harry.v1;

import net.bsocquet.kata.harry.v1.Utils.BundleUtils;
import net.bsocquet.kata.harry.v1.entity.Book;
import net.bsocquet.kata.harry.v1.entity.BookType;
import net.bsocquet.kata.harry.v1.entity.Bundle;

import java.util.HashMap;
import java.util.List;

public class Register {

    public Double getTotalPrice(List<Book> books) {
        if (books == null || books.isEmpty()) {
            return Double.valueOf("0");
        }
        var numberOfBookPerType = initNumberOfBookPerType();
        var bundleOfBooks = BundleUtils.getInitialBundleMap();

        books.forEach(book -> numberOfBookPerType.put(book.bookType(), numberOfBookPerType.get(book.bookType()) + 1));

        BundleUtils.calculateBundleOfBooks(bundleOfBooks, numberOfBookPerType);
        BundleUtils.optimizeBundle(bundleOfBooks);

        return calculatePrice(bundleOfBooks);

    }

    private Double calculatePrice(HashMap<Bundle, Integer> bundleOfBooks) {
        return bundleOfBooks.entrySet()
                .stream()
                .map(a -> a.getKey().getPrice() * a.getValue())
                .reduce(Double::sum).orElse(Double.valueOf("0"));
    }


    private HashMap<BookType, Integer> initNumberOfBookPerType() {
        HashMap<BookType, Integer> numberOfBookPerType = new HashMap<>();
        numberOfBookPerType.put(BookType.FIRST, 0);
        numberOfBookPerType.put(BookType.SECOND, 0);
        numberOfBookPerType.put(BookType.THIRD, 0);
        numberOfBookPerType.put(BookType.FOURTH, 0);
        numberOfBookPerType.put(BookType.FIFTH, 0);
        return numberOfBookPerType;
    }

}
