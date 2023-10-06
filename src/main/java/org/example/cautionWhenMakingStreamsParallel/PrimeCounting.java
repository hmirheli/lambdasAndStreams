package org.example.cautionWhenMakingStreamsParallel;

import java.math.BigInteger;
import java.util.stream.LongStream;

//prime-counting stream pipeline
public class PrimeCounting {
    static long pi(long n) {
        return LongStream.rangeClosed(2, n)
                .parallel()
                .mapToObj(BigInteger::valueOf)
                .filter(i -> i.isProbablePrime(50))
                .count();
    }

    public static void main(String[] args) {
        System.out.println(pi(1000000));
    }
}
