package net.bsocquet.kata.harry.v1.Utils;

import net.bsocquet.kata.harry.v1.entity.BookType;
import net.bsocquet.kata.harry.v1.entity.Bundle;

import java.util.HashMap;
import java.util.Map;

import static net.bsocquet.kata.harry.v1.entity.Bundle.*;
import static net.bsocquet.kata.harry.v1.entity.Bundle.QUINTIO;

public class BundleUtils {

    public static  HashMap<Bundle, Integer> getInitialBundleMap() {
        HashMap<Bundle, Integer> numberOfBookPerType = new HashMap<>();
        numberOfBookPerType.put(UNIT, 0);
        numberOfBookPerType.put(DUO, 0);
        numberOfBookPerType.put(TRIO, 0);
        numberOfBookPerType.put(QUADRIO, 0);
        numberOfBookPerType.put(QUINTIO, 0);
        return numberOfBookPerType;
    }

    public static void calculateBundleOfBooks(HashMap<Bundle, Integer> bundleOfBooks, HashMap<BookType, Integer> numberOfBookPerType) {
        int numberOfBookInBundle = 0;

        for(Map.Entry<BookType, Integer> entry : numberOfBookPerType.entrySet()){
            if(entry.getValue() > 0) {
                numberOfBookInBundle++;
                entry.setValue(entry.getValue() -1 );
            }
        }
        if (numberOfBookInBundle == 0) {
            return;
        }
        bundleOfBooks.put(fromNumberOfBook(numberOfBookInBundle), bundleOfBooks.get(fromNumberOfBook(numberOfBookInBundle)) + 1);
        calculateBundleOfBooks(bundleOfBooks, numberOfBookPerType);
    }

    public static void optimizeBundle(HashMap<Bundle, Integer> bundleOfBooks) {
        if(bundleOfBooks.get(TRIO) == 0 || bundleOfBooks.get(QUINTIO) == 0) {
            return;
        }
        bundleOfBooks.put(TRIO, bundleOfBooks.get(TRIO) - 1);
        bundleOfBooks.put(QUINTIO, bundleOfBooks.get(QUINTIO) - 1);
        bundleOfBooks.put(QUADRIO, bundleOfBooks.get(QUADRIO) + 2);
        optimizeBundle(bundleOfBooks);
    }
}
