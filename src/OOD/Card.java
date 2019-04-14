package OOD;

public abstract class Card {
    private boolean available = true;

    /* number or face that's on card - a number 2 thourhg 10, or 11 for Jack, 12 for Queen,
    13 for King or 1 for Ace */

    protected int faceValue;
    protected Suit suit;

    public Card(int c, Suit S) {
        faceValue = c;
        suit = S;
    }

    public abstract int value();

    public Suit suit() { return suit; }

    /* Checks if the card is available to be given out to someone */
    public boolean isAvailable() { return available; }
    public void markUnavailable() { this.available = false; }
    public void markAvailable() { this.available = true; }
}
