
public class Squeeze
{
    public static void main(String[]args){
        SqueezeFilter f1 = new SqueezeFilter("beforeSqueeze.txt", "afterSqueeze.txt");
        f1.readFileAndRemoveSpaces();
        System.out.println("Finished writing to afterSqueeze.txt");
    }
}
