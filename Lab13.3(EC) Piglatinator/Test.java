import chn.util.*;
public class Test
{
    public static void main(String[]args){
        System.out.println("This program will translate english into Piglatin.");
        ConsoleIO input = new ConsoleIO();
        System.out.println("Enter a word: ");
        String read = input.readLine();
        
        System.out.println(Piglatinator.pigLatinWord(read));
    }
}
