import apcslib.*;
import chn.util.*;
public class Item implements Comparable<Item>
{
  private int myId;
  private int myInv;
  
  public Item(int id, int inv)
  {
    myId = id;
    myInv = inv;
  }
  
  public int getId(){ 
     return myId;
  }  
  public int getInv(){
      return myInv;
  }
  public int compareTo(Item otherObject){
      if(myId>(otherObject.myId))
        return -1;
      else if(myId<(otherObject.myId))
        return 1;
      else
        return 0;
  }
  public boolean equals(Item otherObject){
      if(myId==(otherObject.myId))
        return true;
      else
        return false;
  }
  @Override
  public String toString(){
          return Format.right(myId,5) + "" + Format.right(myInv,5);
  }
}
