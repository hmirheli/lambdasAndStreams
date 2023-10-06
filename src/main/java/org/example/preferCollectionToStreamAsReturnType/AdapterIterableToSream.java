package org.example.preferCollectionToStreamAsReturnType;

import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class AdapterIterableToSream {
    //Adapter From Iterable<E> To Stream<E>
    public static <E> Stream<E> streamOf(Iterable<E> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

    public static void main(String[] args) {
        Iterable<String> iterable = List.of("Apple", "Mango", "Orange");
        Stream<String> stream = streamOf(iterable);
        stream.forEach(System.out::println);
    }
}
