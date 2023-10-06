package org.example.preferSideEffectFreeFunctionsInStreams;

import lombok.Getter;

@Getter
public class Artist {
    private final String name;

    public Artist(String name) {
        this.name = name;
    }
}
