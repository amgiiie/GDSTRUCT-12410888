import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Player> playerList = new ArrayList<Player>();
        playerList.add(new Player(1,"Saitama", 999));
        playerList.add(new Player(2,"Goku", 500));
        playerList.add(new Player(3,"Deku", 100));

        //initial contents of the list
        System.out.println("\n||+++___Initial Contents of List___+++||");
        for (Player player : playerList) {
            System.out.println(player);
        }
        size(playerList);
        System.out.println("\n+++-------------------------------------+++");

        System.out.println("\n||+++___After adding a player at index 2___+++||");
        // add a new player at index 2
        playerList.add(2,new Player( 4, "Sakamoto", 10));

        for (Player player : playerList) {
            System.out.println(player);
        }
        size(playerList);
        System.out.println("\n+++-------------------------------------+++");
        //remove a player at index 1
        System.out.println("\n||+++___After removing a player at index 0___+++||");
        removeFirstElement(playerList);
        size(playerList);


        System.out.println("\n+++-------------------------------------+++");
        //check if player object is in list

        System.out.println("\nList has Saitama?");
        contains(playerList, 1, "Saitama", 999);


        System.out.println("\nWhat is Goku's index?");
        index(playerList, 2, "Goku", 500);

    }

    // create a function that removes the first element.
    public static void removeFirstElement(List<Player> playerList) {
        System.out.println("\nRemoved player:" + playerList.get(0));
        System.out.println("");
        playerList.remove(0);
        System.out.println("        ***Current List***");
        for (Player player : playerList) {
            System.out.println(player);
        }
    }
    //create a size() function that determines how many elements are present in your Linked List
    public static void size(List<Player> playerList){
        int sizeOfList = playerList.size();
        System.out.println("|| Current Linked List Size: " + sizeOfList + "        ||");
    }

    //create a contains() and indexOf()  function similar to our ArrayList.
    public static void contains(List<Player> playerList, int _id, String _name, int _level) {
        boolean contains = playerList.contains(new Player( _id, _name, _level));
        System.out.println(contains) ;
    }
    public static void index(List<Player> playerList, int _id, String _name, int _level) {
        int index = playerList.indexOf(new Player( _id, _name, _level));
        if (index >= 0) {
            System.out.println(index);
        }
        if (index < 0) { // for if chosen player has been removed
            System.out.println("!!!Chosen Player has been removed from the list!!!");
        }
    }

}
