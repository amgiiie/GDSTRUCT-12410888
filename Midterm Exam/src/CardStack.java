import java.util.LinkedList;
import java.util.ListIterator;

public class CardStack {
    private LinkedList<Card> stack;

    public CardStack() {
        stack = new LinkedList<Card>();
    }

    public void push(Card card){
        stack.push(card);
    }

    public Card pop() {
        if(isEmpty()){
            return null;
        }
        return stack.pop();
    }

    public Card peek() {
        return stack.peek();
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public void printStack() {
        ListIterator<Card> listIterator = stack.listIterator();

        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
    public int size() {
        return stack.size();
    }

}
