import chn.util.*;
import apcslib.*;
public class Testing
{
    public static void main(String[]args){
        ConsoleIO input = new ConsoleIO();
        System.out.println("Student's name: ");
        String name = input.readLine();
        System.out.println("Student's ID: ");
        String ID = input.readLine();

        StudentGPA student = new StudentGPA(name, ID);
        System.out.println("Initial GPA: " + student.getGPA());
        for(int i = 0; i<3; i++){
            System.out.println("Enter a grade:");
            int grade = input.readInt();
            student.addGrade(grade);
            System.out.format("GPA: %.2f%n", student.getGPA());
        }
    }
}
