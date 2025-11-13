public class Main {
    public static void main(String[] args) {
        Tree bst = new Tree();
        bst.insert(25);
        bst.insert(20);
        bst.insert(15);
        bst.insert(27);
        bst.insert(30);
        bst.insert(29);
        bst.insert(26);
        bst.insert(22);
        bst.insert(32);

        int value = 100;
        System.out.println("Node with value " + value + " - " + bst.get(value));

        System.out.println("++---------------------------++");
        System.out.println("Traverse Ascending:");

        bst.inOrderTraverse();

        System.out.println("++---------MIN - MAX---------++");
        bst.getMin();
        bst.getMax();
        System.out.println("++---------------------------++");
        System.out.println("Traverse Descending:");

        bst.traverseInOrderDescending();
    }
}