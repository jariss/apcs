import apcslib.*;
import chn.util.*;
public class Store
{
    private Item[] myStore;
    public Store(String fileName) { 
        myStore=new Item[50];
        loadFile(fileName);
    }    

    private void loadFile(String FileName){
        FileInput in = new FileInput(FileName);
        for(int i = 0; i < 50; i++){
            myStore[i] = new Item(in.readInt(), in.readInt());
        }                   
    }

    public void displayStore(){
        System.out.println(Format.right("Id",13) + Format.right("Inv",5 ));
        int ctr = 1;
        for(int i = 0; i < myStore.length; i++){
            if(i%10 == 0)
                System.out.println();
            System.out.println(ctr + "\t"+myStore[i]);
            ctr++;
        }
    }//displays the data

    public void doSort()
    {
        quickSort(myStore, 0, myStore.length - 1);    // code as shown
    }// public method that calls 'quickSort' of 'myStore'

    private void quickSort(Item[] list, int first, int last){
        {
            int g = first, h = last;

            int midIndex = (first + last) / 2;
            Item dividingValue = list[midIndex];
            do
            {
                while (list[g].compareTo(dividingValue) > 0)
                    g++;
                while (list[h].compareTo(dividingValue) < 0)
                    h--;
                if (g <= h)
                {
                    //swap(list[g], list[h]);
                    Item temp = list[g];
                    list[g] = list[h];
                    list[h] = temp;
                    g++;
                    h--;
                }
            }
            while (g < h);

            if (h > first)
                quickSort (list,first,h);
            if (g < last)
                quickSort (list,g,last);
        }
    }// private method

    public void testSearch()
    {
        int idToFind;
        int invReturn;
        int index;
        ConsoleIO console = new ConsoleIO();

        System.out.println("Testing search algorithm\n");
        System.out.print("Enter Id value to search for (-1 to quit) ---> ");
        idToFind = console.readInt();
        while (idToFind >= 0)
        {
            // calling iterative version of binary search  
            index = bsearch(new Item(idToFind, 0));
            System.out.print("Iterative binary search: Id # " + idToFind);
            if (index == -1)
                System.out.println("     No such part in stock");
            else
                System.out.println("     Inventory = " + myStore[index].getInv());

            // calling recursive version of binary search
            index = bsearch (new Item(idToFind, 0), 0, myStore.length-1);
            System.out.print("Recursive binary search: Id # " + idToFind);
            if (index == -1)
                System.out.println("     No such part in stock");
            else
                System.out.println("     Inventory = " + myStore[index].getInv());  

            System.out.print("\nEnter Id value to search for (-1 to quit) ---> ");
            idToFind = console.readInt();
        }
    }

    /**
     *  Searches the myStore array of Item Objects for the specified
     *  item object using a iterative binary search algorithm
     *
     * @param  idToSearch  Item object containing Id value being search for
     * @return             index of Item if found, -1 if not found
     */
    int bsearch(Item idToSearch)
    {
        int lo = 0, hi = myStore.length-1;
        int mid;
        while(lo <= hi){
            mid = (lo+hi)/2;
            if(idToSearch.compareTo(myStore[mid]) == -1){
                lo = mid+1;                
            }else if(idToSearch.compareTo(myStore[mid]) == 1){
                hi = mid-1;                
            }else if(idToSearch.equals(myStore[mid]) == true){
                return mid;
            }
        }
        return -1;
    }

    /**
     *  Searches the specified array of Item Objects for the specified
     *  item object using a recursive binary search algorithm
     *
     * @param  idToSearch  Item object containing Id value being search for
     * @param  first       Starting index of search range
     * @param  last        Ending index of search range
     * @return             index of Item if found, -1 if not found
     */ 
    int bsearch (Item idToSearch, int first, int last)
    {
        int mid;
        mid = (first+last)/2;
        if(last<first){
            return -1;
        }else if(idToSearch.compareTo(myStore[mid]) == -1){
            first = mid+1;
            mid = (first+last)/2;
            return bsearch(idToSearch, first, last);               
        }else if(idToSearch.compareTo(myStore[mid]) == 1){
            last = mid-1;
            mid = (first+last)/2;
            return bsearch(idToSearch, first, last);                
        }else if(idToSearch.equals(myStore[mid]) == true){
            return mid;
        }       
        return -1;
    }
}
