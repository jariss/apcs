import java.util.Scanner;
public class TaxTester
{
    public static void main(String[]args){
        Scanner temp = new Scanner(System.in);
        System.out.println("Filing Status: ");
        String status = temp.nextLine();
        System.out.println("Taxable income: ");
        double income = temp.nextDouble();
        // extracting the first character from the String
        char relationship = status.charAt(0);
        TaxPayer tax = new TaxPayer(income, status);
        // testing if the character is an upper or lowercase 's'
        if (relationship == 'S' || relationship == 's')
            System.out.printf("Filable Tax = $%.2f%n", tax.calculateTax());
        else if(relationship == 'M' || relationship == 'm')
            System.out.printf("Filable Tax = $%.2f%n", tax.calculateTax());
        else
            System.out.printf("Error %n");
    }
}
