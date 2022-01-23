package net.bsocquet.kata.harry.v1.entity;

import java.util.Arrays;

public enum Bundle {
    UNIT(1, Double.valueOf("8")),
    DUO(2, Double.valueOf("15.2")),
    TRIO(3, Double.valueOf("21.6")),
    QUADRIO(4, Double.valueOf("25.6")),
    QUINTIO(5, Double.valueOf("30"));

    private final Integer numberOfBook;
    private final Double price;

    Bundle(Integer numberOfBook, Double price) {
        this.numberOfBook = numberOfBook;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public static Bundle fromNumberOfBook(Integer numberOfBook) {
        return Arrays.stream(Bundle.values())
                .filter(bundle -> bundle.numberOfBook.equals(numberOfBook))
                .findFirst()
                .orElse(null);
    }
}
