
public class Pictures
{
    public static void printTable(int rows, int col){
        System.out.printf("%1s", " ");
        for(int i = 1; i <= col; i++){
            System.out.printf("%6d",i);
        }
        System.out.println("\n");
        for(int i = 1; i <= rows; i++){
            System.out.print(i);
            for( int column = 1; column <= col; column++){
                if(i <10)
                    System.out.printf("%6d", i * column);
                else{
                    System.out.printf ("%5d", i * column);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("__________________________________________");
    }

    public static void pyramid(int lines) {
        int spaces = lines - 1;
        int stars = 1;
        for (int i = 1; i <= lines; i ++) { 
            System.out.println();
            for(int j = 1; j <= spaces; j++){
                System.out.print(" ");
            }
            for(int k = 1; k <= stars; k++){
                System.out.print("*");
            }
            spaces--;
            stars += 2;
        }
    }
}
