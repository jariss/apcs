
public class Fun
{
    public static double fToC(double fahrenheit){
        double c1 = (5.0/9.0)*(fahrenheit-32);
        return c1;
    }

    public static double cToF(double celsius){
        double f1 = (9.0/5.0*celsius)+32;
        return f1;
    }

    public static double volume(double radius){
        double v = (4.0/3.0)*Math.PI*(Math.pow(radius, 3));
        return v;
    }

    public static double hypotenuse(double a, double b){
        double c = Math.sqrt(Math.pow(a, 2)+ Math.pow(b, 2));
        return c;
    }
}
