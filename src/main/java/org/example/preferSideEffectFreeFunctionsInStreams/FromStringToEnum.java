package org.example.preferSideEffectFreeFunctionsInStreams;

import org.example.preferLambdasToAnonymousClasses.Operation;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

//using a toMap Collector to make a map from string to enum
public class FromStringToEnum {
    private static final Map<String, Operation> stringToEnum =
            Stream.of(Operation.values()).collect(
                    toMap(Object::toString, e -> e));

    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

    public static void main(String[] args) {
        System.out.println(fromString("-"));
    }
}
