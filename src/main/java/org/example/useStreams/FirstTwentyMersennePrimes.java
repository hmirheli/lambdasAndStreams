package org.example.useStreams;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

// 2 pow(p) -1 is a mersenne prime
//the program print s each mersenne prime with its exponent->using bitLength()

public class FirstTwentyMersennePrimes {
    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(1))
                .limit(20)
                .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
//                .forEach(System.out::println);
    }
}
