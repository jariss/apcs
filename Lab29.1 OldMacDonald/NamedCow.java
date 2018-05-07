
public class NamedCow extends Cow
{
    private String myName;
    public NamedCow(String myType, String name, String mySound){
        super(myType, mySound);
        myName = name;
    }

    public String getName(){
        return myName;
    }
}
