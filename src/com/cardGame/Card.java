package com.cardGame;


public class Card implements Comparable<Card>{
    private Suite cardSuite;
    private byte cardValue;

    public Card(int cardSuite, int cardValue){

        switch (cardSuite){
            case 1:
                this.cardSuite = Suite.CIRCLE;
                break;
            case 2:
                this.cardSuite = Suite.TRIANGLE;
                break;
            case 3:
                this.cardSuite = Suite.CROSS;
                break;
            case 4:
                this.cardSuite = Suite.SQUARE;
                break;
            case 5:
                this.cardSuite = Suite.STAR;
                break;
            case 6:
                this.cardSuite = Suite.WHOT;
                break;


        }
        this.setCardValue (cardValue);

    }

    public Suite getCardSuite() {
        return cardSuite;
    }




    public short getCardValue() {
        return cardValue;
    }

    public void setCardValue(int cardValue) {
        this.cardValue = (byte) cardValue;

        }


    public void displayCard() {
        System.out.println(getCardSuite() + " " + getCardValue());

    }


    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure <tt>sgn(x.compareTo(y)) ==
     * -sgn(y.compareTo(x))</tt> for all <tt>x</tt> and <tt>y</tt>.  (This
     * implies that <tt>x.compareTo(y)</tt> must throw an exception iff
     * <tt>y.compareTo(x)</tt> throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * <tt>(x.compareTo(y)&gt;0 &amp;&amp; y.compareTo(z)&gt;0)</tt> implies
     * <tt>x.compareTo(z)&gt;0</tt>.
     *
     * <p>Finally, the implementor must ensure that <tt>x.compareTo(y)==0</tt>
     * implies that <tt>sgn(x.compareTo(z)) == sgn(y.compareTo(z))</tt>, for
     * all <tt>z</tt>.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * <tt>(x.compareTo(y)==0) == (x.equals(y))</tt>.  Generally speaking, any
     * class that implements the <tt>Comparable</tt> interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * <tt>sgn(</tt><i>expression</i><tt>)</tt> designates the mathematical
     * <i>signum</i> function, which is defined to return one of <tt>-1</tt>,
     * <tt>0</tt>, or <tt>1</tt> according to whether the value of
     * <i>expression</i> is negative, zero or positive.
     *
     * @param  card the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Card card) {
        if (this.getCardValue() == card.getCardValue() || this.getCardSuite()== card.getCardSuite())  return 0;

        else if (this.getCardValue() > card.getCardValue()) return 1;

        else return -1;
    }


}




