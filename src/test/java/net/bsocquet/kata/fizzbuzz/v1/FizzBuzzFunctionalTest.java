package net.bsocquet.kata.fizzbuzz.v1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzFunctionalTest {

    private final FizzBuzzFunctional fizzBuzz = new FizzBuzzFunctional();

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 19, 47})
    @DisplayName("When given a simple integer, then return the string value of that integer")
    void simpleInteger(int number) {
        String result = fizzBuzz.fizzbuzz(number);
        String expectedValue = String.valueOf(number);

        assertThat(result).isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 9, 45, 75})
    @DisplayName("When given a multiple of three, then return should contains fizz")
    void multipleOfThree(int number) {
        String result = fizzBuzz.fizzbuzz(number);
        String expectedValue = "fizz";

        assertThat(result).contains(expectedValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 31, 35, 73})
    @DisplayName("When given a number containing three, then return should contains fizz")
    void containsThree(int number) {
        String result = fizzBuzz.fizzbuzz(number);
        String expectedValue = "fizz";

        assertThat(result).contains(expectedValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 20, 40, 70})
    @DisplayName("When given a multiple of five, then return should be buzz")
    void multipleOfFive(int number) {
        String result = fizzBuzz.fizzbuzz(number);
        String expectedValue = "buzz";

        assertThat(result).contains(expectedValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 51, 35, 57})
    @DisplayName("When given a number containing five, then return should contains buzz")
    void containsFive(int number) {
        String result = fizzBuzz.fizzbuzz(number);
        String expectedValue = "buzz";

        assertThat(result).contains(expectedValue);
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 30, 45, 60})
    @DisplayName("When given a multiple of three and five, then return should be fizzbuzz")
    void multipleOfThreeAndFive(int number) {
        String result = fizzBuzz.fizzbuzz(number);
        String expectedValue = "fizzbuzz";

        assertThat(result).isEqualTo(expectedValue);
    }

}