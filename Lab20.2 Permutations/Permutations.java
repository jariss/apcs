
public class Permutations
{
    public static void main(String[]args){
        for(int i = 1; i <= 10; i++){
            if(i<10)
                System.out.print("List  " + i + ": ");
            else
                System.out.print("List " + i + ": ");

            PermutationsGenerator.randomArrayAndPermutate();    
        }
    }
}