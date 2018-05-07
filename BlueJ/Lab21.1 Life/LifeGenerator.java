
public class LifeGenerator
{
    public static void main(String[]args){
        Life life = new Life("life100.txt");
        for(int i = 0; i <= 5; i++){
            System.out.println("Generation: " + i);
            life.printGrid();     
            System.out.println("Alive: " + life.alive());
            System.out.println("# Alive in row 10: " + life.rowAlive());
            System.out.println("# Alive in col 10: " + life.colAlive());
            life.newGrid();
            System.out.println();
        }
    }
}
