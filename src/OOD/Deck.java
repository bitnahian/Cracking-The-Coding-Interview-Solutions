package OOD;

import java.util.Collections;
import java.util.Vector;

public class Deck <T extends Card>{
    private Vector<T> cards; // all cards, dealt or not
    private int dealtIndex = 0; // Marks first undealt card

    public void setDeckOfCards(Vector<T> deckOfCards) {
        this.cards = deckOfCards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int remainingCards() {
        return cards.size() - dealtIndex;
    }

    public T[] dealHand() {
        throw new UnsupportedOperationException();
    }
    public T dealCard() {
        T card = this.cards.get(dealtIndex);
        dealtIndex++;
        return card;
    }
}
