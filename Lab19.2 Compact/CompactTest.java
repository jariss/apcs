
public class CompactTest
{
   public static void main(String[]args){
       Compact in1 = new Compact("compact.txt");
       in1.readFileAndArray();
       in1.printArray();
       in1.compact();
    }
}
