import apcslib.*;	
import chn.util.*;
public class SqueezeFilter
{
    private FileInput infile;//used to read the file
    private FileOutput outfile;//the file we are going to create

    public SqueezeFilter(String name1, String name2){
        infile = new FileInput(name1);//name1 is the name of the file
        outfile = new FileOutput(name2);//name2is the name of the file
    }

    public void readFileAndRemoveSpaces(){
        System.out.println("Removing the spaces from the file...");
        int num = 0;
        String newLine = "";

        while(infile.hasMoreLines()){
            System.out.println("Reading");
            num = 0;
            String line = infile.readLine();
            if(line.length()>0){
                while(line.charAt(num) == ' '){

                    num++;

                }
            }
            outfile.println(Format.left(num, 3) + line.substring(num));
            System.out.println("Finished reading");
        }
        outfile.close();
    }
}