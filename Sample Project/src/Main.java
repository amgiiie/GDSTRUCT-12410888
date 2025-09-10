//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
       System.out.print("Enter your name: "); // if want beside string the next character print() lang
       Scanner reader = new Scanner(System.in);
       String name = reader.next();
       System.out.println("Hello " + name + "!");
   }
}