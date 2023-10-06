package org.example.preferSideEffectFreeFunctionsInStreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

//Not a Streams Code,it's an iterative code pretending to be a streams code

public class FrequencyTableOfWords {
    public static void main(String[] args) {
        File file = new File("src/main/java/org/example/useStreams/anagram");
        Map<String, Long> freq = new HashMap<>();

        try (Stream<String> words = new Scanner(file).tokens()) {
            words.forEach(word -> {
                freq.merge(word.toLowerCase(), 1L, Long::sum);
            });
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        //print the word frequencies
        for (Map.Entry<String, Long> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
