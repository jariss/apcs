import chn.util.*;
public class Palindrome
{
    public  boolean isPal(String phrase){
        String filter = "",reverse = "", out = "";

        filter = filter(phrase); 
        reverse = reverseString(filter); 
        
        if(reverse.equalsIgnoreCase(filter))
            return true;
        else
            return false;
    }

    public String filter(String phrase)
    {
        char ch;
        String filter = ""; 
        for(int i=0; i<phrase.length(); i++){
            ch = phrase.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                filter += "" + ch;
            }
        }
        return filter; 

    }

    public String reverseString(String phrase)
    {
        String reverse = ""; 
        for(int i=phrase.length()-1; i>=0;i--){
            reverse += phrase.charAt(i);
        }  
        return reverse; 

    }
}