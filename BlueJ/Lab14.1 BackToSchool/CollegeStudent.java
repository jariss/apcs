
public class CollegeStudent extends Student
{
    private String myMajor;
    private int myYear;

    public CollegeStudent(String myName,int myAge,String myGender,
    String myIdNum,double myGPA,int year, String major){
        super(myName, myAge, myGender, myIdNum, myGPA);

        myMajor = major;
        myYear = year;
    }

    public void setMajor(String maj){
        this.myMajor = maj;
    }

    public String getMajor(){
        return myMajor;
    }

    public void setSubject(int year){
        this.myYear = year;
    }

    public int getSubject(){
        return myYear;
    }

    @Override
    public String toString(){
        return super.toString() + ", year " + myYear + ", major: "
        + myMajor;
    }
}