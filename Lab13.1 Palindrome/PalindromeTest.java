import chn.util.*;
public class PalindromeTest{
    public static void main(String[]args){
        System.out.println("Welcome to the Palindrome Program!");
        ConsoleIO input = new ConsoleIO();
        System.out.println("Enter your passage or 'q' to quit: ");
        String phrase = input.readLine();
        Palindrome p = new Palindrome(); 
        while(!phrase.equals("q") && !phrase.equals("Q"))
        {
            if(p.isPal(phrase))
                System.out.println("Yes, the string you entered is a palindrome.");

            else
                System.out.println("No, the string you entered is NOT a palindrome.");
            System.out.println("Enter your passage or 'q' to quit: ");
             phrase = input.readLine();
        }
    }
}

