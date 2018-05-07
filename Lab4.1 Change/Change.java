import apcslib.*;
import chn.util.*;
public class Change
{
    public static void main(String[]args)
    {
        ConsoleIO reader = new ConsoleIO();
        System.out.println("Amount of purchase = ");
        Double purchased = reader.readDouble();
       
        System.out.println("Cash tendered = ");
        Double tendered = reader.readDouble();
        double purchaseAmount = purchased;
        double cashPaid = tendered;

        double cashBack = cashPaid - purchaseAmount;
        cashBack = cashBack - (int)cashBack + 0.00001;
        int Change = (int)(cashBack * 100);
        System.out.println("Amount of coins needed: \n"); 
        System.out.println(Format.right("", 3) + Change + " cents = \n");

        int Quarters = 0;
        int Dimes = 0;
        int Nickels = 0;
        int Pennies = 0;
        while (Change > 0){ 
            if (Change >= 25){
                Change -= 25;
                Quarters++;
            }
            else if (Change >= 10){
                Change -= 10;
                Dimes++;
            }
            else if (Change >= 5){
                Change -=5;
                Nickels++;
            }
            else if (Change >= 1){
                Change -= 1;
                Pennies++;
            }
        }
        System.out.println(Format.right("" , 5) + "Number of Quarters: " + Quarters);
        System.out.println(Format.right("" , 5) + "Number of Dimes: " + Dimes);
        System.out.println(Format.right("" , 5) + "Number of Nickels: " +  Nickels);
        System.out.println(Format.right("" , 5) + "Number of Pennies: " + Pennies);
    }
}

