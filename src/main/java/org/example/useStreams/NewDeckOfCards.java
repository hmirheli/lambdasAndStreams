package org.example.useStreams;

//initializing a new deck of cards using Cartesian Product of the two sets
//with a nested foreach Loop

import java.util.ArrayList;
import java.util.List;


public class NewDeckOfCards {
    private static List<Card> newDeck() {
        List<Card> result = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values())
            for (Card.Rank rank : Card.Rank.values()) {
                result.add(new Card(suit, rank));
            }
        return result;
    }

    public static void main(String[] args) {
        List<Card> deck = newDeck();
        for (Card card : deck) {
            System.out.println(card);
        }
    }
}
