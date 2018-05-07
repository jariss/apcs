public class Teacher extends Person
{
    private String mySubject;
    private double mySalary;

    public Teacher(String name, int age, String gender,
    String subject, double salary)
    {
        // use the super class' constructor
        super(name, age, gender);

        // initialize what's new to Student
        mySubject = subject;
        mySalary = salary;
    }

    public void setSubject(String sub){
        this.mySubject = sub;
    }
    
    public String getSubject(){
        return mySubject;
    }
    
    public void setSalary(double sal){
        this.mySalary = sal;
    }
    
    public double getSalary(){
        return mySalary;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + ", subject: " + mySubject + ", salary: " 
        + mySalary;
    }
}
