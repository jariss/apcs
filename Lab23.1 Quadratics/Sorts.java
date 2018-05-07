import java.util.*;

/**
 *  Description of the Class
 *
 * @author     Your Name Here
 * @created    Month Day, Year
 */
public class Sorts
{
    private long steps;

    /**
     *  Description of Constructor
     *
     * @param  list  Description of Parameter
     */
    Sorts()
    {
        steps = 0;
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void bubbleSort(int[] list)
    {
        // Replace these lines with your code
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println();
        steps++;
        for(int i = 0; i < list.length; i++){
            steps+=3;
            for(int k = 0; k < list.length-1-i; k++){
                steps+=3;
                if(list[k] > list[k+1]){
                    steps+=3;
                    int temp = list[k];
                    list[k] = list[k+1];
                    list[k+1] = temp;
                }
            }
        }
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void selectionSort(int[] list)
    {
        // Replace these lines with your code
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println();
        steps++;
        for(int i = 0; i < list.length-1; i++){
            steps+=4;
            int minIndex = i;
            for(int j = i+1; j < list.length; j++){
                steps+=3;
                if(list[j] < list[minIndex]){
                    steps++;
                    minIndex = j;
                }
            }
            steps+=3;
            int temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void insertionSort(int[] list)
    {
        // Replace these lines with your code
        steps++;
        for(int i = 1; i < list.length; i++){
            steps+=4;
            int position = i;
            int key = list[i];
            while(position-1 >= 0 && list[position-1] > key){
                steps+=3;
                list[position] = list[position-1];
                position--;
            }
            steps++;
            list[position] = key;
        }
    }

    /**
     *  Recursive mergesort of an array of integers
     *
     * @param  a      reference to an array of integers to be sorted
     * @param  first  starting index of range of values to be sorted
     * @param  last   ending index of range of values to be sorted
     */
    public void mergeSort(int[] list, int first, int last)
    {
        // Replace these lines with your code
        steps+=3;
        int mid = (first + last)/2;
        if(first == last){
            ;
        }
        else if(last-first == 1){
            steps++;
            if(list[first] > list[last]){
                steps+=3;
                int temp = list[first];
                list[first] = list[last];
                list[last] = temp;
            }            
        }
        else{
            steps++;
            //left
            mergeSort(list, first, mid);
            steps++;
            //right
            mergeSort(list, mid+1, last);
            steps++;
            //helper method
            merge(list, first, mid, last);
        }
    }

    /**
     *  Takes in entire vector, but will merge the following sections
     *  together:  Left sublist from a[first]..a[mid], right sublist from
     *  a[mid+1]..a[last].  Precondition:  each sublist is already in
     *  ascending order
     *
     * @param  a      reference to an array of integers to be sorted
     * @param  first  starting index of range of values to be sorted
     * @param  mid    midpoint index of range of values to be sorted
     * @param  last   last index of range of values to be sorted
     */
    private void merge(int[] list, int first, int mid, int last)
    {
        steps+=4;
        int l = first;//left Ctr
        int r = mid+1;// right Ctr
        int p = first;// position for temp 
        int[] temp = new int[list.length];// temp array
        while(l <= mid && r <= last){
            steps+=2;
            if(list[l] < list[r]){
                steps+=3;
                temp[p] = list[l];
                l++;
                p++;
            }else{
                steps+=3;
                temp[p] = list[r];
                r++;
                p++;
            }            
        }
        while(r <= last){
            steps+=4;
            temp[p] = list[r];
            r++;
            p++;            
        }
        while(l <= mid){
            steps+=4;
            temp[p] = list[l];
            l++;
            p++;
        }
        steps++;
        for(int i = first; i <= last; i++){
            steps+=3;
            list[i] = temp[i];
        }
    }

    /**
     *  Recursive quicksort of an array of integers
     *
     * @param  a      reference to an array of integers to be sorted
     * @param  first  starting index of range of values to be sorted
     * @param  last   ending index of range of values to be sorted
     */
    public void quickSort(int[] list, int first, int last)
    {
        steps+=3;
        int g = first, h = last;
        int midIndex = (first + last) / 2;
        int dividingValue = list[midIndex];
        do
        {
            steps++;
            while (list[g] < dividingValue){
                steps+=2;
                g++;
            }
            while (list[h] > dividingValue){
                steps+=2;
                h--;
            }
            steps++;
            if (g <= h)
            {
                steps+=5;
                //swap(list[g], list[h]);
                int temp = list[g];
                list[g] = list[h];
                list[h] = temp;
                g++;
                h--;
            }
        }
        while (g < h);
        steps++;
        if (h > first){
            steps++;
            quickSort (list,first,h);
        }
        steps++;
        if (g < last){
            steps++;
            quickSort (list,g,last);
        }
    }

    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount()
    {
        return steps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(int stepCount)
    {
        steps = stepCount;
    }
}