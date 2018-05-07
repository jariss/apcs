import java.text.*;
import chn.util.*;
import apcslib.*;
public class Quadratic
{
    public static void main(String[]args)
    {
        NumberFormat formatter = NumberFormat.getInstance();
        formatter.setMinimumFractionDigits(4);
        formatter.setMaximumFractionDigits(4);
        ConsoleIO temp = new ConsoleIO();
        System.out.println("Enter the value for 'a': ");
        double valueA = temp.readDouble();
        System.out.println("Enter the value for 'b': ");
        double valueB = temp.readDouble();
        System.out.println("Enter the value for 'c': ");
        double valueC = temp.readDouble();
        
        double root1, root2, valueD;
        
        valueD = valueB * valueB - (4 * valueA * valueC);

        if(valueD > 0){
            root1 = (-valueB + Math.sqrt(valueD)) / (2 * valueA);
            root2 = (-valueB - Math.sqrt(valueD)) / (2 * valueA);
            System.out.println("The roots are " + formatter.format(root1) + " and " + formatter.format(root2));
        }
        else if(valueD == 0){
            root1 = (-valueB + Math.sqrt(valueD)) / (2 * valueA);
            System.out.println("The root is " + formatter.format(root1));
        }
        else{
            System.out.println("There are no real roots");
        }
    }
}