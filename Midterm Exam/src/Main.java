import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CardStack playerDeck = new CardStack();
        playerDeck.push(new Card(1, "Abracardabra"));
        playerDeck.push(new Card(2, "Barahas"));
        playerDeck.push(new Card(3, "Cardodalisay"));
        playerDeck.push(new Card(4, "Dexter"));
        playerDeck.push(new Card(5, "Edeckofcards"));
        playerDeck.push(new Card(6, "LordFarcard"));
        playerDeck.push(new Card(7, "Cardigan Bay"));
        playerDeck.push(new Card(8, "Dealt With"));
        playerDeck.push(new Card(9, "Ace-Ventura"));
        playerDeck.push(new Card(10, "Card-iac Arrest"));
        playerDeck.push(new Card(11, "Shuffling Off"));
        playerDeck.push(new Card(12, "The Draw"));
        playerDeck.push(new Card(13, "Stacked Deck"));
        playerDeck.push(new Card(14, "Cardamom Scent"));
        playerDeck.push(new Card(15, "Four-bidden"));
        playerDeck.push(new Card(16, "The Red Handed"));
        playerDeck.push(new Card(17, "Full House"));
        playerDeck.push(new Card(18, "Royaal Flush"));
        playerDeck.push(new Card(19, "The Straight Shooter"));
        playerDeck.push(new Card(20, "Cardboard Box"));
        playerDeck.push(new Card(21, "The Wild Card"));
        playerDeck.push(new Card(22, "King Me"));
        playerDeck.push(new Card(23, "Pinochle"));
        playerDeck.push(new Card(24, "The Cut"));
        playerDeck.push(new Card(25, "Carding-dale"));
        playerDeck.push(new Card(26, "Re-Deal"));
        playerDeck.push(new Card(27, "The Flipper"));
        playerDeck.push(new Card(28, "The Tucket"));
        playerDeck.push(new Card(29, "The Card-inal Sin"));
        playerDeck.push(new Card(30, "On the Table"));

        CardStack playerHand = new CardStack();
        CardStack discardedPile = new CardStack();

        int turnNumber = 1;
        final int DRAW_ACTION = 0;
        final int DISCARD_ACTION = 1;
        final int GET_DISCARD_ACTION = 2;

        while (!playerDeck.isEmpty()) {
            System.out.println("+++-------------------------------------+++");
            System.out.println("+++            TURN NUMBER " + turnNumber + "            +++");
            int choice =  (int)(Math.random() * 3); // random number from 0 to 2
//            System.out.println(choice); // to check random choice number is correct

            if (playerHand.isEmpty()){
                choice = DRAW_ACTION;
            }

            //if discarded hand is empty, reroll choice
            if (discardedPile.isEmpty() && choice == GET_DISCARD_ACTION){
                choice =  (int)(Math.random() * 2);
            }

            switch (choice) {
                case DRAW_ACTION:
                    System.out.println("+++-------------------------------------+++");
                    System.out.println("Drawing Cards...\n");
                    drawCards(playerDeck, playerHand);
                    break;
                case DISCARD_ACTION:
                    System.out.println("+++-------------------------------------+++");
                    System.out.println("Discarding Cards...\n");
                    discardedCards(playerHand, discardedPile);
                    break;
                case GET_DISCARD_ACTION:
                    System.out.println("+++-------------------------------------+++");
                    System.out.println("Getting discarded cards...\n");
                    getDiscardedCards(discardedPile, playerHand);
                    break;

            }


            System.out.println("\n+++-----------CURRENT STATUS------------+++");

            System.out.println("Cards player is holding: \n");
            playerHand.printStack();
            System.out.println("\nNumber of cards remaining in deck: " + playerDeck.size());
            System.out.println("Number of cards in discarded pile: " + discardedPile.size());
            System.out.println("\n+++-------------------------------------+++");
            // player needs to press enter to continue

            turnNumber++;
            pressEnterToContinue();
        }

        System.out.println("!!!GAME OVER!!! PLayer Deck is Empty!");


    }

    public static int randomNumberGenerator(){
        int min = 1;
        int max = 5;
        return (int)(Math.random() * (max - min + 1)) + min;
    }
    public static void pressEnterToContinue() {
        Scanner s = new Scanner(System.in);
        System.out.println("Press ENTER to continue...");

        s.nextLine();
    }

    // draw x cards (x can be random number from 1 to 5
    public static void drawCards(CardStack playerDeck, CardStack playerHand) {
        int tempRandomNum = randomNumberGenerator();

        while (tempRandomNum > playerDeck.size()){ // if randomgeneratednumber is greater than the deck size it gets another random number
            tempRandomNum = randomNumberGenerator();
        }

        for (int i = 0; i < tempRandomNum; i++) {

            if (!playerDeck.isEmpty()) {
                Card poppedCard = playerDeck.pop();
                playerHand.push(poppedCard);

                System.out.println("Drew a card: " +poppedCard.toString());
            }
            else {
              System.out.println("Card deck is empty. Can't draw more cards");
              break;
            }

        }
//        playerHand.printStack(); // to check player hand

    }
   // discard x cards (random value from 1 to 5)
    public static void discardedCards(CardStack playerHand, CardStack discardedPile) {
        int tempRandomNum = randomNumberGenerator();

        while (tempRandomNum > playerHand.size()){ // if randomgeneratednumber is greater than the deck size it gets another random number
            tempRandomNum = randomNumberGenerator();
        }

        for (int i = 0; i < tempRandomNum; i++) {
            if (!playerHand.isEmpty()) {
                Card poppedCard = playerHand.pop();
                discardedPile.push(poppedCard);

                System.out.println("Discarded card:  " + poppedCard.toString());
            }
            else {
                System.out.println("Card deck is empty. Can't discard any more cards");
                break;
            }
        }
//        discardedPile.printStack(); //to check discarded pile
    }

    // get x cards from the discarded pile
    public static void getDiscardedCards(CardStack discardedPile, CardStack playerHand){
        int tempRandomNum = randomNumberGenerator();

        while (tempRandomNum > discardedPile.size()){ // if randomgeneratednumber is greater than the deck size it gets another random number
            tempRandomNum = randomNumberGenerator();
        }
        for (int i = 0; i < tempRandomNum; i++) {
            if (!discardedPile.isEmpty()) {
                Card poppedCard = discardedPile.pop();
                playerHand.push(poppedCard);

                System.out.println("Retrieved Discarded card:" + poppedCard.toString());
            }
            else {
                System.out.println("Card deck is empty. Can't retrieve any more cards");
                break;
            }
        }
    }

}
