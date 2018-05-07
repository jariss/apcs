import apcslib.*;
public class FunTest
{
    public static void main(String[]args)
    {
        System.out.printf("212\u00B0F = %.2f%s%n", (Fun.fToC(212)),"\u00B0F");
        System.out.printf("70\u00B0C =  %.2f%s%n", Fun.cToF(70), "\u00B0C");
        System.out.printf("Radius 1.0 = %.2f%n",Fun.volume(1.0));
        System.out.printf("Triangle with sides 6.75 and 12.31 = %.2f%n", Fun.hypotenuse(6.75, 12.31));
    }
}