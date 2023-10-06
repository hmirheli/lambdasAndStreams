package org.example.preferMethodReferencesToLambdas;

import java.util.HashMap;
import java.util.Map;

public class MapMergeExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("key", 10);

         /*Merge "key" into the map, incrementing the value by 1 if it already exists,
         or inserting the key with the value 1 if it doesn't exist.*/

//        map.merge("key",1,(count,incr)->count+incr);

        /*Prefer Method Reference To Lambda*/
        map.merge("key", 1, Integer::sum);
        System.out.println(map);
    }
}
