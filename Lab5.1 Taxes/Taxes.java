import apcslib.*;
import chn.util.*;
public class Taxes
{
    public static void main(String[]args)
    {
        double FEDERAL_TAX = 0.15;
        double FICA_TAX = 0.0765;
        double STATE_TAX = 0.04;     

        ConsoleIO temp = new ConsoleIO();
        System.out.println("Hours worked: ");
        double hours = temp.readDouble();
        System.out.println("Hourly rate: ");
        double hourlyRate = temp.readDouble();
        //Gross Pay
        double grossPay = hours * hourlyRate;
        System.out.printf("Gross pay" + Format.right("",10) + "$%,.2f",grossPay);
        //Federal Tax
        double fedTax = grossPay * FEDERAL_TAX;
        System.out.printf("\n\nFederal tax (15%%)" + Format.right("", 3) + "$%,.2f",fedTax);
        //FICA Tax
        double ficaTax = grossPay * FICA_TAX;
        System.out.printf("\nFICA (7.65%%)" + Format.right("", 8) + "$%,.2f",ficaTax);
        //State Tax
        double stateTax = grossPay * STATE_TAX;
        System.out.printf("\nState tax (4%%)" + Format.right("", 6) + "$%,.2f",stateTax);
        //Net Pay
        double netPay = grossPay - fedTax - ficaTax - stateTax;
        System.out.printf("\n\nNet pay" + Format.right("", 12) + "$%,.2f",netPay);
    }
}
