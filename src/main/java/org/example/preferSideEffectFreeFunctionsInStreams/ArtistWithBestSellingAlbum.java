package org.example.preferSideEffectFreeFunctionsInStreams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.function.BinaryOperator.maxBy;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

//use Of toMap
//Collector to generate a map from key to chosen element for key
//whe have a stream of record albums
public class ArtistWithBestSellingAlbum {

    public static void main(String[] args) {
        Artist artist1 = new Artist("Artist 1");
        Artist artist2 = new Artist("Artist 2");
        Artist artist3 = new Artist("Artist 3");

        Album album1 = new Album("album1", artist1, 1000);
        Album album2 = new Album("album2", artist2, 2000);
        Album album3 = new Album("album3", artist3, 3000);
        Album album4 = new Album("album4", artist2, 4000);
        Album album5 = new Album("album5", artist3, 5000);

        List<Album> albums = Arrays.asList(album1, album2, album3, album4, album5);

        Map<Artist, Album> topHits = albums.stream().collect(
                toMap(Album::getArtist, a -> a, maxBy(comparing(Album::getSales))));

        Map<Artist, List<Album>> artistAlbum = albums.stream()
                .collect(groupingBy(Album::getArtist));

        Map<Integer, List<Album>> albumsBySales = albums.stream()
                .collect(groupingBy(Album::getSales));

        for (Map.Entry<Artist, Album> entry : topHits.entrySet()) {
            System.out.println(entry.getKey().getName() + ": " + entry.getValue().getTitle());
        }

        System.out.println("\nArtists by Album list:");

        for (Map.Entry<Artist, List<Album>> entry : artistAlbum.entrySet()) {
            Artist artist = entry.getKey();
            List<Album> albumList = entry.getValue();
            System.out.println(artist.getName() + ": " + albumList.stream()
                    .map(Album::getTitle)
                    .collect(Collectors.joining(", ")));
        }

        System.out.println("\nList Of Albums With The Same Sale: ");
        System.out.println(albumsBySales.toString());
    }
}
