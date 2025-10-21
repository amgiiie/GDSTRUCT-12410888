import java.util.Scanner;

public class Main {
    private static int nextPlayerID = 1;
    public static void main(String[] args) {
        int turnNumber = 0;
        int amountOfGames = 1;

        ArrayQueue playerQueue = new ArrayQueue(10);



        do {
            turnNumber++;
            System.out.println("[[]-------------------------------------[]]");
            System.out.println("+++            TURN NUMBER " + turnNumber + "            +++");


            matchmaking(playerQueue);
            playerQueue.printQueue();

            if (playerQueue.size() >= 5) {
                System.out.println("+++-------------------------------------+++");
                System.out.println("+++            GAME NUMBER " + amountOfGames + "            +++");
                enterGame(playerQueue);
                amountOfGames++;
                playerQueue.printQueue();
            }

            pressEnterToContinue();

        } while (amountOfGames <= 10);

        System.out.println("!!!10 GAMES QUEUED UP, GAME OVER!!!");



    }


    public static void pressEnterToContinue() {
        Scanner s = new Scanner(System.in);
        System.out.println("Press ENTER to continue...");

        s.nextLine();
    }

    public static int randomNumberGenerator(){
        int min = 1;
        int max = 7;
        return (int)(Math.random() * (max - min + 1)) + min;
    }

    // matchmaking player
    public static void matchmaking(ArrayQueue playerQueue) {
        int tempNum = randomNumberGenerator();

//        System.out.println(tempNum); // check tempnum
        System.out.println("+++-------------------------------------+++");
        for (int i = 0; i < tempNum; i++) {
            playerQueue.enqueue(new Player(nextPlayerID++));
        }
        System.out.println("Matchmaking...    " + playerQueue.size() + " players..." );
        System.out.println("+++-------------------------------------+++");

        System.out.println("Player Queue:");


    }

    // queuing player in match
    public static void enterGame(ArrayQueue playerQueue) {
        int matchSize = 5;

        System.out.println("+++-------------------------------------+++");
        System.out.println("  !!!Queuing 5 Players... GAME STARTING!!!");
        System.out.println("+++-------------------------------------+++");

        System.out.println("De-queuing players...");
        for (int i = 0; i < matchSize; i++){
           playerQueue.dequeue();

        }

        System.out.println("+++-------------------------------------+++");
        System.out.println("Players left: ");
        if (playerQueue.size() == 0){
            System.out.println("      !!!Player queue is empty!!!");
        }

    }

    }


