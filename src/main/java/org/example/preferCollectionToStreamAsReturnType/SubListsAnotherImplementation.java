package org.example.preferCollectionToStreamAsReturnType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubListsAnotherImplementation {
    public static <E> Stream<List<E>> of(List<E> list) {
        return IntStream.range(0, list.size())
                .mapToObj(start ->
                        IntStream.rangeClosed(start + (int) Math.signum(start), list.size())
                                .mapToObj(end -> list.subList(start, end)))
                .flatMap(x -> x);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        Stream<List<String>> stream = of(list);
        stream.forEach(System.out::println);
    }
}
