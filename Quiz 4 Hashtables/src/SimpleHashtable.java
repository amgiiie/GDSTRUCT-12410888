public class SimpleHashtable {
    private SavedPlayer[] hashtable;
    public SavedPlayer deletedPlayer = new SavedPlayer( "deleted", null);

    public SimpleHashtable() {
        hashtable = new SavedPlayer[10];
    }

    public int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    public int findKey(String key) {
        int hashedKey = hashKey(key);

        // already correct hashedKey
        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) {
            return hashedKey;
        }

        // perform linear probing
        int stoppingIndex = hashedKey;

        if (hashedKey == hashtable.length - 1) { // end of array
            hashedKey = 0;
        }
        else {
            hashedKey++;
        }

        while (hashedKey != stoppingIndex &&
                isOccupied(hashedKey) &&
                !hashtable[hashedKey].getKey().equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if (isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)) { // saved player found
            return  hashedKey;
        }

        return -1;
    }

    public boolean isOccupied(int hashedKey) {
        return hashtable[hashedKey] != null;
    }

    public void put(String key, Player value) {
        int hashedKey = hashKey(key);

        // perform linear probing
        int probeIndex = hashedKey;

        if (isOccupied(probeIndex) && hashtable[probeIndex] != deletedPlayer) {
            int stoppingIndex = probeIndex;

            probeIndex = (probeIndex + 1) % hashtable.length;

            while (probeIndex != stoppingIndex && hashtable[probeIndex] != null && hashtable[probeIndex] != deletedPlayer) {
                probeIndex = (probeIndex + 1) % hashtable.length;
            }
        }
        if (!isOccupied(probeIndex) || hashtable[probeIndex] == deletedPlayer) {
            if (hashtable[probeIndex] == deletedPlayer) {
                System.out.println("+++-------------------------------------+++");
                System.out.println("Added new element: " + key);
                System.out.println("+++-------------------------------------+++");
            }
            hashtable[probeIndex] = new SavedPlayer(key, value);
        }
        else {
            System.out.println("+++-------------------------------------+++");
            System.out.println("Cannot put player " + key + ". Hashtable is full.");
            System.out.println("+++-------------------------------------+++");
        }

    }

    public void remove(String key) {
        int hashedKey = hashKey(key);
        int checkedCount = 0;

        while (checkedCount < hashtable.length ) {
            if (hashtable[hashedKey] == null) {
                System.out.println("+++-------------------------------------+++");
                System.out.println("!!!Chosen element is nowhere to be found!!!");
                System.out.println("+++-------------------------------------+++");
                return;
            }
            if (hashtable[hashedKey] != deletedPlayer && hashtable[hashedKey].getKey().equals(key)) {
                hashtable[hashedKey] = deletedPlayer;
                System.out.println("+++-------------------------------------+++");
                System.out.println("Removed player for key: " + key );
                System.out.println("+++-------------------------------------+++");
                return;
            }
            hashedKey = (hashedKey + 1) % hashtable.length;
            checkedCount++;
        }
        System.out.println("+++-------------------------------------+++");
        System.out.println("!!!Chosen element is nowhere to be found!!!");
        System.out.println("+++-------------------------------------+++");
    }

    public Player get(String key) {
        int hashedKey = findKey(key);

        if (hashedKey == -1) {
            return null;
        }

        return hashtable[hashedKey].getValue();
    }

    public void printHashtable() {
        System.out.println("\nResults: ");
        for (int i = 0; i < hashtable.length; i++) {
            Player player = null;

            if (hashtable[i] != null)
                player = hashtable[i].getValue();

            System.out.println("Element " + i + " = " + player);
        }
        System.out.println("\n");
    }


}