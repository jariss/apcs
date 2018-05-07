import chn.util.*;

public class LoanTable
{
    public static void main(String[]args){
        ConsoleIO input = new ConsoleIO();
        System.out.println("Enter the amount of the loan: ");
        double principle = input.readDouble();
        System.out.println("Enter the length of the loan in years: ");
        int time = input.readInt();
        System.out.println("Enter a low interest rate in %: ");
        double lowRate = input.readDouble();
        System.out.println("Enter a high interest rate in %: ");
        double highRate = input.readDouble();

        double k;
        int n;
        double c; 
        double a;

        while(lowRate <= highRate){
            k = (lowRate / 100) / 12.0;
            n = (time * 12);
            c = Math.pow((1+k), n);
            a = (principle * k * c) / (c-1);
            System.out.printf("%1$.2f %2$15.2f %n", lowRate, a);
            lowRate += 0.25;
        }
    }
}