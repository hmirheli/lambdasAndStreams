package org.example;

import org.example.preferLambdasToAnonymousClasses.Operation;
import org.example.preferLambdasToAnonymousClasses.OperationWithLambdas;

public class Main {
    public static void main(String[] args) {
        double x=10.0;
        double y=2.0;

        for (OperationWithLambdas operation:OperationWithLambdas .values()){
            System.out.printf("%.1f %s %.1f = %.1f%n",x,operation,y,operation.apply(x,y));
        }
    }
}