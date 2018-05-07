public class FunLoops{  
    private static boolean perfSquare(double a) //checks if num is a perfect square
    {
        boolean perfSquare = false;
        double root = Math.sqrt(a);
        if (Math.pow((int)root, 2) == Math.pow(root, 2))
        {
            perfSquare = !perfSquare;
        }
        return perfSquare;
    }

    private static boolean sum(int a) //finds sum of numbers up to num
    {
        boolean trueSum=false;
        int totalSum=0;
        int sum=1;
        while (totalSum <= a) //making sure sum doesnt go over
        {
            if (totalSum == a)
            {
                trueSum = !trueSum;
                break;
            }
            else 
            {
                totalSum += sum;//adding total to increasing sum
                sum++;//consecutively increasing
            }
        }
        return trueSum;
    }

    public static void magicSquares(int numSquares) //prints numSquares amount of Magic squares quares
    {
        int num=1;
        int ctr=0;
        while(ctr!=numSquares)
        {
            if(FunLoops.perfSquare(num)==true)//checks if num is perfect square
            {
                if(FunLoops.sum(num)==true)//checks if its a perfect sum
                {
                    System.out.println(num);
                    ctr++;//counts magic squares
                }
            }
            num++;//future magic square
        }
    }

    public static int reverse(int n){
        int reversedNum = 0;
        while (n != 0) {
            reversedNum = reversedNum * 10 + n % 10;//multiply by 10 as a placeholder, mod by 10 to get the last number
            n = n / 10;   
        }
        return reversedNum;
    }

    public static int lcm(int x,int y){
        int num = Math.max(x,y);
        while(num <= x * y){
            if(num % Math.min(x,y) == 0){
                return num;
            }
            num += Math.max(x,y);
        }
        return x*y;
    }
}