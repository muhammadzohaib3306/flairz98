import java.util.Scanner;

public class HighLow {

    public static void main(String[] args) {
        System.out.println("------------Welcome-----------");
        System.out.println("This program is about the card game High Low");
        System.out.println("Guess a card lower or higher than the current card and if the guess is correct a point is added to the score");
        System.out.println("Other wise Game over. Good luck");
        System.out.println();
        System.out.println();

        int highestScore = 0;
        boolean playAgain;

        Scanner scan = new Scanner(System.in);
        do{
            int scoreThisGame;
            scoreThisGame = play();
            if(scoreThisGame > highestScore) highestScore = scoreThisGame;
            System.out.print("Play again?(Enter 'true' if you want to or 'false' if you dont want to...)");
            playAgain = scan.nextBoolean();
        }while(playAgain);

        System.out.println();
        System.out.println("Your Highest Score in all the games was: " + highestScore);
    }

    private static int play() {
        Deck deck = new Deck();
        Card currCard;
        Card nextCard;
        int correctGuesses;
        String guess;
        deck.shuffle();
        correctGuesses = 0;
        System.out.println("Function 1: Drawing two random cards and comparing their value...");
        System.out.println();
        currCard=deck.dealCard();
        System.out.println("card 1 = "+currCard);
        Card currCard2 = deck.dealCard();
        System.out.println("card 2 = "+currCard2);
        if(currCard.getValue()>currCard2.getValue())
        {
            System.out.println("Card 1 has the higher value...");
        }
        else
        {
            System.out.println("Card 2 has the higher value...");
        }
        deck.shuffle();
        System.out.println();
        System.out.println();
        System.out.println("Function 2: shuffling all the cards and displaying all of them ");
        for(int i=1;i<=52;i++)
        {
            currCard=deck.dealCard();
            System.out.println("card "+i+" = "+currCard);
        }
        deck.shuffle();
        currCard = deck.dealCard();
        System.out.println();
        System.out.println();
        System.out.println("Function 3: Now the High Low game...");
        System.out.println("The first card is the " + currCard);

        while(true) {
            System.out.println("Will the next card be higher (H) or lower(L)?Enter your guess...");
            Scanner scan = new Scanner(System.in);
            do {
                guess = scan.next();
                if (!guess.equals("H") && !guess.equals("L"))
                    System.out.println("Please respond with 'H' or 'L' ");
            }while(!guess.equals("H") && !guess.equals("L"));

                nextCard = deck.dealCard();
                System.out.println("The next card is " + nextCard);

                if(nextCard.getValue() == currCard.getValue()) {
                    System.out.println("The value is same as the previous card.");
                    System.out.println("You lose on ties...Sorry! ");
                    break;
                }
                else if(nextCard.getValue() > currCard.getValue()){
                    if(guess.equals("H")){
                        System.out.println("Your Prediction was correct.");
                        correctGuesses++;
                    }
                    else
                    {
                        System.out.println("Your prediction was incorrect.");
                        break;
                    }
            }
                else {
                    if (guess.equals("L")) {
                        System.out.println("Your Prediction was correct");
                        correctGuesses++;
                    }
                    else {
                        System.out.println("Your prediction was incorrect.");
                        break;
                    }
                }

                currCard = nextCard;
            System.out.println();
            System.out.println("The card is " + currCard);
        }
        System.out.println();
        System.out.println("Game over. Your Made " + correctGuesses + " Correct Guesses");
        System.out.println();
        return correctGuesses;

    }
}
