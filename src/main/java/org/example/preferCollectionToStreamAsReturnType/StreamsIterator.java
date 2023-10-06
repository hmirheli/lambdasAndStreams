package org.example.preferCollectionToStreamAsReturnType;

public class StreamsIterator {
    public static void main(String[] args) {
        //Hideous way to iterate over a stream as a return type
        for (ProcessHandle ph : (Iterable<ProcessHandle>) ProcessHandle.allProcesses()::iterator) {
            System.out.println("Process ID: " + ph.pid());
            System.out.println("Command: " + ph.info().command().orElse("N/A"));
        }
    }
}
