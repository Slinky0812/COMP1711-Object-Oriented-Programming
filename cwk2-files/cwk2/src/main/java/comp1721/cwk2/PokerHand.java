package comp1721.cwk2;
import java.lang.*;
import comp1721.cwk2.Card.Rank;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A class to represent a player's hand in a game of poker
 * Inherits from CardCollection
 *
 * @author Abdulla Moledina
 * */

// Implement PokerHand class here
public class PokerHand extends CardCollection {

    public static int FULL_SIZE = 5;

    /**
     * Default constructor for pokerHand
     * Creates an empty hand
     * */
    public PokerHand() {
        //Inherits the variables and methods from CardCollection
        super();
    }

    /**
     * Constructor with a full hand
     *
     * @param hand String which contains abbreviations of the cards in the hand
     * */
    public PokerHand(String hand) {

        //Inherits the variables and methods from CardCollection
        super();

        //Creates an array of strings that stores the cards given
        String[] cards = hand.split(" ");
        //Checks if the length of the array is greater than the full size
        if (cards.length > FULL_SIZE) {
            throw new CardException("Hand is full");
        }

        //Loops through the cards array, creates a Card object and adds it to the list
        for (String card : cards) {
            Card playingCard = new Card(card);

            if (contains(playingCard)) {
                throw new CardException("Duplicate cards");
            } else {
                add(playingCard);
            }
        }

    }

    /**
     * Checks if the hand is full or if the card is already in the hand.
     * If not, it is added to the cards list
     *
     * @oaram card Card to be added
     * */
    public void add(Card card) {
        if (cards.size() == FULL_SIZE) {
            throw new CardException("Hand is full");
        } else if (cards.contains(card)) {
            throw new CardException("Duplicate cards");
        }
        cards.add(card);
    }

    /**
     * Creates a string with abbreviations of the cards separated by spaces
     *
     * @return String
     * */
    @Override
    public String toString() {
        //Creates a StringBuilder object
        StringBuilder hand = new StringBuilder();

        //Loops through the hand and writes it with spaces into the string
        for (int i = 0; i < cards.size(); i++) {
            //Checks for the first character because it doesn't have any spaces
            if (i == 0) {
                hand.append(String.format("%s", cards.get(i)));
            } else {
                hand.append(String.format(" %s", cards.get(i)));
            }
        }

        //Returns the created string
        return hand.toString();
    }

    /**
     * Discards the entire hand
     * */
    @Override
    public void discard () {
        //Checks if there are cards in the hand
        if (isEmpty()) {
            throw new CardException("Hand is empty");
        }
        cards.clear();
    }

    /**
     * Empties the hand and returns it to the deck
     *
     * @param deck Deck for the cards to be discarded into
     * */
    public void discardTo(Deck deck) {
        //Checks if there are cards in the hand
        if (isEmpty()) {
            throw new CardException("Hand is empty");
        }

        //Adds the cards from the list into deck
        for (Card card : cards) {
            deck.add(card);
        }

        //Remove cards from hand
        cards.clear();
    }

    /**
     * Checks if a hand has a pair
     *
     * @return true
     * */
    public boolean isPair() {

        //Count variable to check if a pair has been found
        int count = 1;

        //Checks if the hand is full
        if (cards.size() != FULL_SIZE) {
            return false;
        }

        //Increments through the cards til the 4th card, as the second for loop will go to the last card
        for (int i = 0; i < cards.size() - 1; i++) {
            //Creates the first card object from the cards list
            Card card1 = cards.get(i);
            //Gets the rank of the first card
            Rank rank1 = card1.getRank();
            //Increments through the cards after the first card
            for (int j = i+1; j < cards.size(); j++) {
                //Creates the second card object from the cards list
                Card card2 = cards.get(j);
                //Gets the rank of the second card
                Rank rank2 = card2.getRank();
                //If the ranks are the same, increment count by 1
                if (rank1.equals(rank2)) {
                    count += 1;
                }
            }
        }

        //We are only looking for one pair, so count should only have been incremented once. If so, then return true
        if (count == 2) {
            return true;
        } else {
            //There are no pairs or there are two pairs in the hand
            return false;
        }

    }

    /**
     * Checks if a hand has two pairs
     *
     * @return true
     * */
    public boolean isTwoPairs() {

        //Count variable to check if two pairs has been found
        int count = 1;

        //Checks if the hand is full
        if (cards.size() != FULL_SIZE) {
            return false;
        }

        //Increments through the cards till the 4th card, as the second for loop will go to the last card
        for (int i = 0; i < cards.size() - 1; i++) {
            //Creates the first card object from the cards list
            Card card1 = cards.get(i);
            //Gets the rank of the first card
            Rank rank1 = card1.getRank();
            //Increments through the cards after the first card
            for (int j = i+1; j < cards.size(); j++) {
                //Creates the second card object from the cards list
                Card card2 = cards.get(j);
                //Gets the rank of the second card
                Rank rank2 = card2.getRank();
                //If the ranks are the same, increment count by 1
                if (rank1.equals(rank2)) {
                    count += 1;
                }
            }
        }

        //We are only looking for two pairs, so count should have been incremented twice. If so, then return true
        if (count == 3) {
            return true;
        } else {
            //There are no pairs or only one pair in the hand
            return false;
        }

    }

    /**
     * Checks if a hand has a three of a kind
     *
     * @return true
     * */
    public boolean isThreeOfAKind() {

        //Count variable to check if a three of a kind has been found
        int count = 1;

        //Checks if the hand is full
        if (cards.size() != FULL_SIZE) {
            return false;
        }

        //Increments through the cards
        for (int i = 0; i < cards.size(); i++) {
            //Creates the first card object from the cards list
            Card card1 = cards.get(i);
            //Gets the rank of the first card
            Rank rank1 = card1.getRank();
            //Increments through the cards after the first card
            for (int j = i+1; j < cards.size(); j++) {
                //Creates the second card object from the cards list
                Card card2 = cards.get(j);
                //Gets the rank of the second card
                Rank rank2 = card2.getRank();
                //Increment through the cards after the second card
                for (int k = j + 1; k < cards.size(); k++) {
                    //Creates the third card object from the cards list
                    Card card3 = cards.get(k);
                    //Gets the rank of the third card
                    Rank rank3 = card3.getRank();
                    //If the ranks are all the same
                    if ((rank1.equals(rank2)) && (rank1.equals(rank3))) {

                        //We don't want the last two cards to be a pair, so we have to check the ranks of the remaining two cards
                        //Loops through the cards list from the beginning
                        for (int l = 0; l < cards.size(); l++) {
                            //Create the fourth card object
                            Card card4 = cards.get(l);
                            //Increments through the cards after the first card in the list
                            for (int m = l + 1; m < cards.size(); m++) {
                                //Creates the fifth card object
                                Card card5 = cards.get(m);
                                //Checks if the fourth card object is not the same as the first three card objects (card1, card2, card3), and same with the fifth card
                                if (!(card4.equals(card1) || card4.equals(card2) || card4.equals(card3) || card5.equals(card1) || card5.equals(card2) || card5.equals(card3))) {
                                    //Get the ranks of the fourth and fifth cards
                                    Rank rank4 = card4.getRank();
                                    Rank rank5 = card5.getRank();
                                    //if the ranks are not the same, then increment count by 1
                                    if (!(rank4.equals(rank5))) {
                                        count += 1;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }

        //Count should have only been incremented once. If so, return true
        if (count == 2) {
            return true;
        } else {
            //No three of a kind
            return false;
        }

    }

    /**
     * Checks if a hand has a four of a kind
     *
     * @return true
     * */
    public boolean isFourOfAKind() {

        //Count variable to check if a four of a kind has been found
        int count = 0;

        //Checks if the hand is full
        if (cards.size() != FULL_SIZE) {
            return false;
        }

        //Increments through the cards
        for (int i = 0; i < cards.size(); i++) {
            //Creates the first card object from the cards list
            Card card1 = cards.get(i);
            //Gets the rank of the first card
            Rank rank1 = card1.getRank();
            //Increments through the cards after the first card
            for (int j = i+1; j < cards.size(); j++) {
                //Creates the second card object from the cards list
                Card card2 = cards.get(j);
                //Gets the rank of the second card
                Rank rank2 = card2.getRank();
                //Increment through the cards after the second card
                for (int k = j + 1; k < cards.size(); k++) {
                    //Creates the third card object from the cards list
                    Card card3 = cards.get(k);
                    //Gets the rank of the third card
                    Rank rank3 = card3.getRank();
                    //Increment through the cards objects after the third card
                    for (int l = k+1; l < cards.size(); l++) {
                        //Create the fourth card object from the cards list
                        Card card4 = cards.get(l);
                        //Gets the rank of the fourth card
                        Rank rank4 = card4.getRank();
                        //If the ranks are all the same, increment count by 1
                        if ((rank1 == rank2) && (rank1 == rank3) && (rank1 == rank4)) {
                            count = 1;
                        }
                    }
                }
            }
        }

        //If count has been incremented, return true
        if (count != 0) {
            return true;
        } else {
            //No four of a kind
            return false;
        }

    }

    /**
     * Checks if a hand has a full house
     *
     * @return true
     * */
    public boolean isFullHouse() {

        //Count variable to check if a full house has been found
        int count = 1;

        //Checks if the hand is full
        if (cards.size() != FULL_SIZE) {
            return false;
        }

        //Increments through the cards
        for (int i = 0; i < cards.size(); i++) {
            //Creates the first card object from the cards list
            Card card1 = cards.get(i);
            //Gets the rank of the first card
            Rank rank1 = card1.getRank();
            //Increments through the cards after the first card
            for (int j = i+1; j < cards.size(); j++) {
                //Creates the second card object from the cards list
                Card card2 = cards.get(j);
                //Gets the rank of the second card
                Rank rank2 = card2.getRank();
                //Increment through the cards after the second card
                for (int k = j + 1; k < cards.size(); k++) {
                    //Creates the third card object from the cards list
                    Card card3 = cards.get(k);
                    //Gets the rank of the third card
                    Rank rank3 = card3.getRank();
                    //If the ranks are all the same
                    if ((rank1.equals(rank2)) && (rank1.equals(rank3))) {

                        //We want the last two cards to be a pair, so we have to check the ranks of the remaining two cards
                        //Loops through the cards list from the beginning
                        for (int l = 0; l < cards.size(); l++) {
                            //Create the fourth card object
                            Card card4 = cards.get(l);
                            //Increments through the cards after the first card in the list
                            for (int m = l + 1; m < cards.size(); m++) {
                                //Creates the fifth card object
                                Card card5 = cards.get(m);
                                //Checks if the fourth card object is not the same as the first three card objects (card1, card2, card3), and same with the fifth card
                                if (!(card4.equals(card1) || card4.equals(card2) || card4.equals(card3) || card5.equals(card1) || card5.equals(card2) || card5.equals(card3))) {
                                    //Get the ranks of the fourth and fifth cards
                                    Rank rank4 = card4.getRank();
                                    Rank rank5 = card5.getRank();
                                    //if the ranks are the same, then increment count by 1
                                    if ((rank4.equals(rank5))) {
                                        count += 1;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }

        //Count should have only been incremented once. If so, return true
        if (count == 2) {
            return true;
        } else {
            //No three of a kind
            return false;
        }
    }

    /**
     * Checks if a hand has a flush
     *
     * @return true
     * */
    public boolean isFlush() {

        //Checks if the hand is full
        if (cards.size() != FULL_SIZE) {
            return false;
        }

        //Create card objects for each card in the list
        Card card1 = cards.get(0);
        Card card2 = cards.get(1);
        Card card3 = cards.get(2);
        Card card4 = cards.get(3);
        Card card5 = cards.get(4);

        //Checks if each card has the same suit. If so, return true
        if ((card1.getSuit() == card2.getSuit()) && (card1.getSuit() == card3.getSuit()) && (card1.getSuit() == card4.getSuit()) && (card1.getSuit() == card5.getSuit())) {
            return true;
        } else {
            //The cards don't have the same suit
            return false;
        }
    }

    /**
     * Checks if a hand has a straight
     *
     * @return true
     * */
    public boolean isStraight() {

        //Checks if the hand is full
        if (cards.size() != FULL_SIZE) {
            return false;
        }

        //Array of the value of the ranks
        List<Integer> ranks = new ArrayList<Integer>();

        //Creates the first card object and gets the value of its rank
        Card card1 = cards.get(0);
        ranks.add(card1.getRank().ordinal());

        //Creates the second card object and gets the value of its rank
        Card card2 = cards.get(1);
        ranks.add(card2.getRank().ordinal());

        //Creates the third card object and gets the value of its rank
        Card card3 = cards.get(2);
        ranks.add(card3.getRank().ordinal());

        //Creates the fourth card object and gets the value of its rank
        Card card4 = cards.get(3);
        ranks.add(card4.getRank().ordinal());

        //Creates the fifth card object and gets the value of its rank
        Card card5 = cards.get(4);
        ranks.add(card5.getRank().ordinal());

        //There may be an ace anywhere in the list, and the value of that ace will change if one of the cards is equal to 10, as then it could be possible to hve a straight with 10, J, Q, K, A
        if (card1.getRank() == Rank.TEN || card2.getRank() == Rank.TEN || card3.getRank() == Rank.TEN || card4.getRank() == Rank.TEN || card5.getRank() == Rank.TEN) {
            //Find where the ace is and change its value
            if (card1.getRank() == Rank.ACE) {
                ranks.remove(0);
                ranks.add(13);
            } else if (card2.getRank() == Rank.ACE) {
                ranks.remove(1);
                ranks.add(13);
            } else if (card3.getRank() == Rank.ACE) {
                ranks.remove(2);
                ranks.add(13);
            } else if (card4.getRank() == Rank.ACE) {
                ranks.remove(3);
                ranks.add(13);
            } else if (card5.getRank() == Rank.ACE) {
                ranks.remove(4);
                ranks.add(13);
            }
        }

        //Create a new list of ranks that are sorted
        List<Integer> sortedRanks = ranks.stream().sorted().collect(Collectors.toList());

        //Calculate the difference between each consecutive rank
        int difference1 = sortedRanks.get(4) - sortedRanks.get(3);
        int difference2 = sortedRanks.get(3) - sortedRanks.get(2);
        int difference3 = sortedRanks.get(2) - sortedRanks.get(1);
        int difference4 = sortedRanks.get(1) - sortedRanks.get(0);

        //If the differences are all equal to 1, then the hand is a straight
        if ((difference1 == 1) && (difference2 == 1) && (difference3 == 1) && (difference4 == 1)) {
            return true;
        } else {
            //The hand isn't a straight
            return false;
        }
    }
}