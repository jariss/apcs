import apcslib.*;
import chn.util.*;
public class CarRental
{
    public static void main(String[]args){
        String make, model;
        ConsoleIO temp = new ConsoleIO();
        
        System.out.println("Enter make of your car: ");
        make = temp.readLine();

        System.out.println("Enter the model of your car: ");
        model = temp.readLine();

        String carLetters;
        int carNumber;
        
        System.out.println("Enter license plate (3 letters - 3 digits) --> ");
        carLetters = temp.readToken();
        carNumber = temp.readInt();

        char c1 = carLetters.charAt(0);
        char c2 = carLetters.charAt(1);
        char c3 = carLetters.charAt(2);

        int charTotal = (int)(c1 + c2 + c3);
        int licenseTotal = (int)(charTotal + carNumber);
        int remainder = licenseTotal % 26;
        int offset = (int)(remainder);
        char letter = (char) (offset + 'A');	 
        
        System.out.println("Make = " + make);
        System.out.println("Model = " + model);
        System.out.println(carLetters +" " + carNumber + " = " + letter + licenseTotal);
    }
}