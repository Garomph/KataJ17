package net.bsocquet.kata.harry.v1.utils

import net.bsocquet.kata.harry.v1.Utils.BundleUtils
import net.bsocquet.kata.harry.v1.entity.BookType
import net.bsocquet.kata.harry.v1.entity.Bundle
import spock.lang.Specification

import static net.bsocquet.kata.harry.v1.entity.BookType.FIRST
import static net.bsocquet.kata.harry.v1.entity.BookType.THIRD
import static net.bsocquet.kata.harry.v1.entity.Bundle.DUO
import static net.bsocquet.kata.harry.v1.entity.Bundle.TRIO
import static net.bsocquet.kata.harry.v1.entity.Bundle.UNIT

class BundleUtilsTest extends Specification {

    def "empty set of book should not fill any bundle"() {
        given:
        HashMap<Bundle, Integer> bundleTypes = new HashMap<>()
        bundleTypes.put(UNIT, 0)
        bundleTypes.put(DUO, 0)
        bundleTypes.put(TRIO, 0)
        when:
        BundleUtils.calculateBundleOfBooks(bundleTypes, new HashMap<BookType, Integer>())
        then:
        bundleTypes.get(UNIT) == 0
        bundleTypes.get(DUO) == 0
        bundleTypes.get(TRIO) == 0
    }

    def "Two type of book should only create two type of bundle"() {
        given:
        HashMap<Bundle, Integer> bundleTypes = new HashMap<>()
        bundleTypes.put(UNIT, 0)
        bundleTypes.put(DUO, 0)
        bundleTypes.put(TRIO, 0)
        HashMap<BookType, Integer> bookTypes = new HashMap<>()
        bookTypes.put(FIRST, 3)
        bookTypes.put(THIRD, 4)
        when:
        BundleUtils.calculateBundleOfBooks(bundleTypes, bookTypes);
        then:
        bundleTypes.get(UNIT) == 1
        bundleTypes.get(DUO) == 3
        bundleTypes.get(TRIO) == 0
    }
}
