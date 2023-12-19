package com.example.streams.practice;

import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 *  Get the total number of letters in all the names with more than 5 letters
 */
public class LetterCount {

    public static void main(String[] args) {
        System.out.println("Testing if [william, jones, aaron, seppe, frank, gilliam] returns 14");
        assertEquals(getTotalNumberOfLettersOfNamesLongerThanFive("william", "jones", "aaron", "seppe", "frank", "gilliam"), 14);

        System.out.println("Testing if [aaron] returns 0");
        assertEquals(getTotalNumberOfLettersOfNamesLongerThanFive("aaron"), 0);

    }

    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        return Stream.of(names)
            .filter(n -> n.length() > 5)
            .mapToInt(w -> w.length())
            .sum();
    }


}
