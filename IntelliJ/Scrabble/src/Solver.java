import java.util.Scanner;

public class Solver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 7 letters: ");
        String hand = in.nextLine();
        Dictionary dict = new Dictionary();
        System.out.println(dict.findWords(hand));
    }
}
