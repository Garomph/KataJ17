package net.bsocquet.kata.fizzbuzz.v1


import spock.lang.Specification

class FizzBuzzFunctionalTest extends Specification {

    def 'Should return the string value of the Integer if not a multiple of 3 or 5'() {
        given:
        FizzBuzzFunctional fizzbuzz = new FizzBuzzFunctional()

        when:
        String result = fizzbuzz.fizzbuzz(input)

        then:
        result == output

        where:
        input || output
        1     || "1"
        2     || "2"
        19    || "19"
        47    || "47"
    }

    def 'Should return "fizz" when multiple of 3'() {
        given:
        FizzBuzzFunctional fizzbuzz = new FizzBuzzFunctional()

        when:
        String result = fizzbuzz.fizzbuzz(input)

        then:
        result.contains(output)

        where:
        input || output
        3     || "fizz"
        9     || "fizz"
        45    || "fizz"
        75    || "fizz"
    }


    def 'Should return "fizz" when the number contains 3'() {
        given:
        FizzBuzzFunctional fizzbuzz = new FizzBuzzFunctional()

        when:
        String result = fizzbuzz.fizzbuzz(input)

        then:
        result.contains(output)

        where:
        input || output
        3     || "fizz"
        31    || "fizz"
        35    || "fizz"
        73    || "fizz"
    }

    def 'Should return "buzz" when multiple of 5'() {
        given:
        FizzBuzzFunctional fizzbuzz = new FizzBuzzFunctional()

        when:
        String result = fizzbuzz.fizzbuzz(input)

        then:
        result.contains(output)

        where:
        input || output
        5     || "buzz"
        20    || "buzz"
        40    || "buzz"
        70    || "buzz"
    }


    def 'Should return "fizz" when the number contains 5'() {
        given:
        FizzBuzzFunctional fizzbuzz = new FizzBuzzFunctional()

        when:
        String result = fizzbuzz.fizzbuzz(input)

        then:
        result.contains(output)

        where:
        input || output
        5     || "buzz"
        51    || "buzz"
        35    || "buzz"
        57    || "buzz"
    }


    def 'Should return "fizzbuzz" when multiple of 3 and 5'() {
        given:
        FizzBuzzFunctional fizzbuzz = new FizzBuzzFunctional()

        when:
        String result = fizzbuzz.fizzbuzz(input)

        then:
        result == output

        where:
        input || output
        15    || "fizzbuzz"
        30    || "fizzbuzz"
        45    || "fizzbuzz"
        60    || "fizzbuzz"
    }

}
