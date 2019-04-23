package OOD;

public class BlackJackCard extends Card {

    public BlackJackCard(int c, Suit S) { super(c,S); }

    @Override
    public int value() {
        return 0;
    }

    public int minValue() {
        if (isAce()) return 1;
        else return value();
    }

    public int maxValue() {
        if (isAce()) return 11;
        else return value();
    }

    public boolean isAce() {
        return faceValue == 1;
    }

    public boolean isFaceCard() {
        return faceValue >=11 && faceValue <=13;
    }
}
