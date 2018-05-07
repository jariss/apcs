public class Piglatinator
{
    public static String pigLatinWord(String englishPhrase){
        String pigLatin = "", start = "", end = "";
        int vowel = 0;
        for(int i = 0; i < englishPhrase.length(); i++){
            if(englishPhrase.charAt(i) == 'a' || englishPhrase.charAt(i) == 'e' || englishPhrase.charAt(i) == 'i' || englishPhrase.charAt(i) == 'o' || englishPhrase.charAt(i) == 'u'){
                pigLatin = englishPhrase + "ay";
            }
            else if(englishPhrase.substring(0,1) == "a" || englishPhrase.substring(0,1) == "e" || englishPhrase.substring(0,1) == "i" || englishPhrase.substring(0,1) == "o" || englishPhrase.substring(0,1) == "u"){
                pigLatin = englishPhrase + "yay";
            }
            else{
                for(i = 0; i < englishPhrase.length(); i++){
                    char letter = englishPhrase.charAt(i);
                    if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u'){
                        vowel = i;
                        break;
                    }     
                }
                start = englishPhrase.substring(0,vowel);
                end = englishPhrase.substring(vowel, englishPhrase.length());
                pigLatin = end + start + "ay";
            }/  
        }
        return pigLatin;
    }
}