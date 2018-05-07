
public class Main
{
    public static void main (String[] args)	
    {
        // test of methods from LA27.1 - sorting the database
        Store miniMart = new Store("file50.txt");
        System.out.println("Database before sorted: ");
        System.out.println();
        miniMart.displayStore();
        miniMart.doSort();
        System.out.println();
        System.out.println("Database after sorted by id: ");
        System.out.println();
        miniMart.displayStore();

        // test of methods from LA28.1 - searching the database
        miniMart.testSearch();
    }
}