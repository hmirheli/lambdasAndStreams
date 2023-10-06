package org.example.preferLambdasToAnonymousClasses;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class CompareTwoStrings {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("banana");
        words.add("orange");
        words.add("grape");

        /*
        anonymous class instance as a function object_obsolete
        * */
//        Collections.sort(words, new Comparator<String>() {
//            public int compare(String s1, String s2) {
//                return Integer.compare(s1.length(), s2.length());
//            }
//        });

        /*
         * Lambda Expression as function object(replaces anonymous)
         * */

//        Collections.sort(words,
//                (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        /*
         * a comparator construction method can be used in place of a lambda which is more succinct
         * */
//        Collections.sort(words, comparingInt(String::length));

        /*
         * even shorter due to sort method added to the List Interface
         * Using Method References is preferred to Lambdas*/
        words.sort(comparingInt(String::length));

        for (String word : words) {
            System.out.println(word);
        }
    }
}
