package org.example.preferSideEffectFreeFunctionsInStreams;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

//pipeline to get a top-ten list of words from a frequency table from most frequent to  the least frequent
public class TopTenFrequencyTableOfWords {
    public static void main(String[] args) {
        File file = new File("src/main/java/org/example/useStreams/anagram");
        Map<String, Long> freq = new HashMap<>();

        try (Stream<String> words = new Scanner(file).tokens()) {
            freq = words
                    .collect(groupingBy(String::toLowerCase, counting()));
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        }
        List<String> topTen = freq.keySet().stream()
                .sorted(comparing(freq::get).reversed())
                .limit(10)
                .toList();

        System.out.println(topTen);

    }
}
