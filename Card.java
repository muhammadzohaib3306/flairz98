public class Card {
    public final static int SPADES=0; //code for the 4 suits
    public final static int HEARTS=1;
    public final static int DIAMONDS=2;
    public final static int CLUBS=3;
    public final static int JOKER=4;    //plus joker

    public final static int ACE=1;
    public final static int JACK=11;
    public final static int QUEEN=12;
    public final static int KING=13;

    private final int suit;
    private final int value;

    public Card(){
        suit=JOKER;
        value=1;
    }

    public Card(int theValue, int theSuit) {
        if (theSuit != SPADES && theSuit != HEARTS && theSuit != DIAMONDS && theSuit != CLUBS && theSuit != JOKER)
            throw new IllegalArgumentException("Illegal playing card suit");
        if (theSuit != JOKER && (theValue < 1 || theValue > 13))
            throw new IllegalArgumentException("Illegal playing card value");
        value = theValue;
        suit = theSuit;
    }
    //returns suit of cards
    public int getSuit(){
        return suit;

    }

    //returns value of card
    public int getValue(){
        return value;

    }

    //return suit as String
    public String getSuitAsString(){
        switch(suit) {
            case SPADES:
                return "Spades";
            case HEARTS:
                return "Hearts";
            case DIAMONDS:
                return "Diamonds";
            case CLUBS:
                return "Clubs";
            default:
                return "Joker";

        }
    }

    //returns value as string
    public String getValueAsString(){
        if(suit==JOKER)
            return ""+value;
        else{
            switch(value){
                case 1:
                    return "Ace";
                case 2:
                    return "2";
                case 3:
                    return "3";
                case 4:
                    return "4";
                case 5:
                    return "5";
                case 6:
                    return "6";
                case 7:
                    return "7";
                case 8:
                    return "8";
                case 9:
                    return "9";
                case 10:
                    return "10";
                case 11:
                    return "Jack";
                case 12:
                    return "Queen";
                default:
                    return "King";

            }
        }
    }

    //returns card object as String
    public String toString(){
        if(suit==JOKER){
            if(value==1)
                return "Joker";
            else return "joker #"+value;
        }
        else return getValueAsString()+" 0f " + getSuitAsString();
    }

}
