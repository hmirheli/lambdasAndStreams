package org.example.preferCollectionToStreamAsReturnType;

import java.util.stream.Stream;

public class AdapterStreamToIterable {
    //Adapter From Stream<E> To Iterable<E>
    public static <E> Iterable<E> iterableOf(Stream<E> stream) {
        return stream::iterator;
    }

    public static void main(String[] args) {
        for (ProcessHandle ph : iterableOf(ProcessHandle.allProcesses())) {
            System.out.println("Process ID: " + ph.pid());
            System.out.println("Command: " + ph.info().command().orElse("N/A"));
        }
    }
}
