package org.example.useStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Stream-based Cartesian Product
public class NewDeckOfCardsStreamBased {
    private static List<Card> newDeck() {
        return Stream.of(Card.Suit.values())
                .flatMap(suit -> Stream.of(Card.Rank.values())
                        .map(rank -> new Card(suit, rank)))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Card> deck = newDeck();
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}
