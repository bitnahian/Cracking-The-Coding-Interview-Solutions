package OOD;

import java.util.Vector;

public class Hand <T extends Card> {
    protected Vector<T> cards = new Vector<>();

    public int score() {
        int score = 0;
        for (T card : cards) {
            score += card.value();
        }

        return score;
    }

    public void addCard(T card) {
        cards.add(card);
    }
}
