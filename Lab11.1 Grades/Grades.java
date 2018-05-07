import chn.util.*;
public class Grades
{
    public static void main(String[]args){
        double gpa=0;
        double score = 0;
        String grades = "";
        char grade;
        int classes = 0;
        boolean fail = false;  
        ConsoleIO input = new ConsoleIO();
        System.out.print("Enter letter grades with spaces in between or q to quit. ");
        grades = input.readToken();
        grades = grades.toLowerCase();
        while(grades.equals("a") || grades.equals("b") || grades.equals("c") || grades.equals("d") || grades.equals("f")){            
            grade = grades.charAt(0);
            switch(grade){
                case 'a':
                score = 4.0;
                break;
                case 'b':
                score = 3.0;
                break;
                case 'c':
                score = 2.0;
                break;
                case 'd':
                score = 1.0;
                break;
                case 'f':
                fail = true;
                score = 0.0;
                break;
                default:
                break;
            }
            classes++;
            gpa += score;     
            System.out.print("Enter Letter Grade or enter a non-grade character to quit: ");
            grades = input.readLine();
            grades = grades.toLowerCase();
        }  
        System.out.println("Your GPA is: " + gpa/classes);

        if (gpa >= 2  && classes >= 4 && fail == false){
            System.out.println("Eligible");
        }else if(classes < 4){
            System.out.println("Ineligible, taking less than 4 classes");
        }else if(gpa < 2.0 && fail == false && classes >= 4 ){
            System.out.println("Ineligible, gpa below 2.0");
        }else if(gpa >= 2.0 && fail != false && classes >= 4 ){
            System.out.println("Ineligible, gpa above 2.0 but has F grade");
        }else if(gpa < 2.0 && fail != false && classes >= 4 ){
            System.out.println("Ineligible, gpa below 2.0 and has F grade");
        }
    }
}