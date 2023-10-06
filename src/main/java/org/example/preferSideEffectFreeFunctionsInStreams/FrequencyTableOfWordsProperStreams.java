package org.example.preferSideEffectFreeFunctionsInStreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class FrequencyTableOfWordsProperStreams {
    public static void main(String[] args) {
        File file = new File("src/main/java/org/example/useStreams/anagram");
        Map<String, Long> freq = new HashMap<>();

        try (Stream<String> words = new Scanner(file).tokens()) {
            freq = words
                    .collect(groupingBy(String::toLowerCase, counting()));
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        }

        for (Map.Entry<String, Long> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
