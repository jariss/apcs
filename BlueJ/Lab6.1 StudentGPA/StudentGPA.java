
/**
 * Write a description of class StudentGPA here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StudentGPA
{
    private String myName;        // student's name 
    private String myID;          // student's ID
    private int myTotalPoints;    // sum of all grades entered
    private int myNumGrades;    // number of grades entered
    private double myGPA;    // student's GPA
    public StudentGPA(String myName, String myID)
    {
        this.myName = myName;
        this.myID = myID;
    }
    public void addGrade(int grade){
        myTotalPoints += grade;
        myNumGrades++;
        myGPA = (double)myTotalPoints/myNumGrades;
    }
    public double getGPA(){
        return myGPA;
    }
}
