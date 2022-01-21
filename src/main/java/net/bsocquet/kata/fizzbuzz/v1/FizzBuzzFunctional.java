package net.bsocquet.kata.fizzbuzz.v1;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class FizzBuzzFunctional {

    private final BiFunction<Boolean, String, String> TRANSFORMATION = (a, b) -> a ? b : null;
    private final BiPredicate<Integer, Integer> MULTIPLE_OF = (a, b) -> a % b == 0;
    private final BiPredicate<Integer, Integer> CONTAINS = (a,b) -> String.valueOf(a).contains(String.valueOf(b));
    private final BiPredicate<Integer, Integer> CONTAINS_OR_MULTIPLE_OF = CONTAINS.or(MULTIPLE_OF);

    public String fizzbuzz(Integer number) {
        return Optional.of(StringUtils.join(
                        TRANSFORMATION.apply(CONTAINS_OR_MULTIPLE_OF.test(number, 3), "fizz"),
                        TRANSFORMATION.apply(CONTAINS_OR_MULTIPLE_OF.test(number, 5), "buzz")))
                .filter(StringUtils::isNotBlank) // StringUtils.join does not return null of both element are null
                .orElse(String.valueOf(number));
    }
}
