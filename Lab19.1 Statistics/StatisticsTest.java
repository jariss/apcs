public class StatisticsTest
{
    public static void main(String[]args){
        Statistics in1 = new Statistics("numbers.txt");
        in1.readFileAndArray();
        in1.calcAverage();
        in1.calcStandDeviation();
        in1.calcModes();
    }
}
