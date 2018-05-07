import java.util.*;
public class PermutationsGenerator
{
    //array
    //permutate
    //print
    //clean
    public static void randomArrayAndPermutate(){
        List<Integer> originalArray = new ArrayList<Integer>();
        for(int i = 1; i <= 10; i++){
            originalArray.add(i);
        }
        List<Integer> permutatedArray = new ArrayList<Integer>();
        int randomPos = 0;
        for(int i = 1; i <= 10; i++){
            randomPos = (int)(Math.random() * originalArray.size() + 0);
            permutatedArray.add(originalArray.remove(randomPos));
        }
        int sum = permutatedArray.get(0)+permutatedArray.get(permutatedArray.size()-1);
        System.out.println(permutatedArray + "      Sum of first and last: " + sum);
    }
}
