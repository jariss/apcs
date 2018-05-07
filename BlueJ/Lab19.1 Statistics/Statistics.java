import chn.util.*;
import apcslib.*;
public class Statistics
{
    private FileInput infile;
    private static int[] list = new int[1000];
    private static int logLength = 0;
    public Statistics(String name1){
        infile = new FileInput(name1);
    }

    public void readFileAndArray(){
        while(infile.hasMoreLines()){//runs until no more tokens are found
            int x = infile.readInt();//read each integer
            list[logLength] = x;//stores each integer into array list
            logLength++;//position of each integer
        }
    }

    public static double helperAverage(){
        long sum = 0;
        double average = 0;
        for(int i = 0; i < logLength; i++){
            sum += list[i];
        }
        average = ((double)sum )/ logLength;
        return average;
    }

    public void calcAverage(){
        System.out.println("The average is " + Format.left(Statistics.helperAverage(), 0, 2));
    }

    public void calcStandDeviation(){
        double average = Statistics.helperAverage();
        double elementTotal = 0, tot = 0, total = 0, totalDiv = 0;
        for(int i = 0; i < logLength; i++){//runs till end of lenth of elements
            elementTotal = Math.pow(list[i] - average, 2);//calculate sum of square differences
            tot += elementTotal;//sums the square of differences of each element
        }
        totalDiv = tot/(logLength-1);//divides sum by length of logLength-1
        total = Math.sqrt(totalDiv);//takes the square root of totalDiv

        System.out.println("The standard deviation is " + Format.left(total, 0 ,2));
    }

    public void calcModes(){
        int freq[] = new int[101];
        int max = 0;
        for(int i = 0; i < logLength; i++){//runs until end of array
            for(int j = 0; j < freq.length; j++){//goes from 0-100 numbers
                if(list[i] == j)//checks to see if the element at position i in the array is equal to j which is the range of numbers
                    freq[j]++;//increases the occurence of the element at position j
                if(freq[j]>= max)//see if occurence is more than the previous maximum occurence
                    max = freq[j];//sets the max to the the new max(freq[j])             
            }
        }
        for(int i = 0; i < freq.length; i++){//runs through 0-100
            if(freq[i] == max)//checks if there i more then one mode
                System.out.println("The mode is " + i + " and occurs " + max + " times");
        }       
    }
}