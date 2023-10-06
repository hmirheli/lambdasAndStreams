package org.example.useStreams;

/*
 * java's Lack of support for primitive streams
 */
public class PrimitiveCharStreams {
    public static void main(String[] args) {

        /*
         * java's Lack of support for primitive streams
         */
//        "Hello World!".chars().forEach(System.out::println);

        /*you could fix it by using a cast to force the invocation of the correct overloading */
        "Hello World!".chars().forEach(x -> System.out.println((char) x));
    }
}
