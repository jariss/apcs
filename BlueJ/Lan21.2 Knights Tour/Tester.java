
public class Tester
{
    public static void main(String[]args){
        KnightsTour knight = new KnightsTour();
        while(!knight.noMoreMoves()){
            knight.move();
        }
        knight.print();
    }
}
