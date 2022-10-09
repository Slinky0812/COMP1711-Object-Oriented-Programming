package comp1721.cwk2;
import comp1721.cwk2.Card.Rank;
import comp1721.cwk2.Card.Suit;
import java.util.*;

/**
 * Class to represent a deck of playing cards
 * Inherits from CardCollection
 *
 * @author Abdulla Moledina
 * */
// Implement Deck class here
public class Deck extends CardCollection {

    /**
    * Creates a deck object with all the cards in it
    */
    public Deck() {

        //Inherits the variables and methods from CardCollection
        super();

        //Loops through each suit
        for (Suit suit : Suit.values()) {
            //Loops through each rank
            for (Rank rank : Rank.values()) {
                //Creates the card object and adds it to the collection
                add(new Card(rank, suit));
            }
        }

    }

    /**
     * Removes the first card in the deck object
     *
     * @return the first card in the deck
     */
    public Card deal() {
        //checks if the deck is empty
        if (cards.isEmpty()) {
            throw new CardException("Deck is empty");
        }
        //removes the first card from the deck and returns it
        return cards.remove(0);
    }

    /**
     * Shuffles the deck object
     * */
    public void shuffle() {
        Collections.shuffle(cards);
    }

}
