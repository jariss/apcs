import apcslib.*;
import chn.util.*;
public class Compact
{
    private FileInput infile;
    private int[] list = new int[100];
    private int logLength = 0;
    public Compact(String name1){
        infile = new FileInput(name1);
    }

    public void readFileAndArray(){
        while(infile.hasMoreTokens()){//runs until no more tokens are found
            int x = infile.readInt();//read each integer
            list[logLength] = x;//stores each integer into array list
            logLength++;//position of each integer
        }
    }

    public void printArray(){
        System.out.print("Before: ");
        for(int i = 0; i < logLength; i++){//runs until logical length
            if(i != logLength-1)//runs until second to last number
                System.out.print(list[i] + ", ");//prints the integer at position i with ,
            else
                System.out.println(list[i]);//prints last number in list
        }
    }

    public void compact(){
        System.out.print("After: ");
        int newLogLength = 0;//new logical length for total numbers after loop
        for(int i = 0; i < logLength; i++){//runs until end of logical length
            if(list[i] == 0){//checks to see if the element at position i is 0
                logLength--;//if true, logical length of list decreases
                for(int b = i; b < logLength; b++){// starts at position i, and runs until end of logical length
                    list[b] = list[b+1];//sets position b to the next elements position
                }
                i--;//goes back to previous position to check the element being left shifted for 0
            }
            else
                newLogLength++;//increase newLogLength if element at pos i is not equal to 0
        }
        for(int i = 0; i < newLogLength; i++)
            if(i < newLogLength-1)
                System.out.print(list[i] + ", ");//prints all elements until last
            else
                System.out.print(list[i]);//prints last element
    }
}