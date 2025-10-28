public class Main {
    public static void main(String[] args) {
        Player pikachu = new Player(25, "Pikachu", 25);
        Player celebi = new Player(251, "Celebi", 251);
        Player hitmonchan = new Player(107, "Hitmonchan", 107);
        Player mankey = new Player(56, "Mankey", 56);
        Player starmie = new Player(121, "Starmie", 121);
        Player togepi = new Player(56, "Togepi", 56);

        SimpleHashtable hashtable = new SimpleHashtable();
        hashtable.put(pikachu.getUserName(), pikachu);
        hashtable.put(celebi.getUserName(), celebi);
        hashtable.put(hitmonchan.getUserName(),hitmonchan);
        hashtable.put(mankey.getUserName(), mankey);
        hashtable.put(starmie.getUserName(), starmie);
        hashtable.put(togepi.getUserName(), togepi);

        hashtable.printHashtable();

        System.out.println("\nElement at key " + togepi.getUserName() + " = " + hashtable.get(togepi.getUserName()));

        hashtable.remove(pikachu.getUserName());
        hashtable.printHashtable();

        hashtable.remove(starmie.getUserName());
        hashtable.printHashtable();

        hashtable.put(starmie.getUserName(), starmie); // to check if element is added in right key
        hashtable.printHashtable();


    }
}