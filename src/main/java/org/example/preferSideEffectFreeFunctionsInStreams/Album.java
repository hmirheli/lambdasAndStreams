package org.example.preferSideEffectFreeFunctionsInStreams;

import lombok.Getter;

@Getter
public class Album {
    private final String title;
    private final Artist artist;
    private final int sales;

    public Album(String title, Artist artist, int sales) {
        this.title = title;
        this.artist = artist;
        this.sales = sales;
    }

    @Override
    public String toString() {
        return title;
    }
}
