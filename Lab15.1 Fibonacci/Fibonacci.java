
public class Fibonacci
{
    public static int fib(int num){
        if(num == 0)
            return 0;
        else if(num == 1)
            return 1;
        else
            return fib(num-1) + fib(num-2);
    }

    public static int nonRecFib(int num){
        int a = 1;
        int b = 0;
        int currentSum = 0;
        for(int i = 0; i < num; i++){
            b = a;
            a = currentSum;
            currentSum = a + b;
        }
        return currentSum;
    }

    public static int mult(int a, int b){
        if(a == 0 || b == 0)
            return 0;
        else 
            return a + mult(a, b-1);
    }

    public static void main(String[]args){
        System.out.println(fib(0) + "\n" + fib(3) + "\n" + fib(11) + "\n" + nonRecFib(1) + "\n" + nonRecFib(5)+ "\n" +
            nonRecFib(14) + "\n" + mult(0,4) + "\n" + mult(3,1) + "\n" +
            mult(7,8) + "\n" + mult(5,0));
    }
}
