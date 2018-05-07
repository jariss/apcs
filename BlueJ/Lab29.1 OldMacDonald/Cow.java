public class Cow implements Animal
{
  private String myType;
  private String mySound;  
  public Cow(String type, String sound)
  {
    this.myType = type;
    this.mySound = sound;
  }

  public String getSound() { return mySound; }
  public String getType() { return myType; }
}