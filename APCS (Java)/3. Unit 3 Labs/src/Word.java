import static java.lang.System.*;

public class Word
{
    private String word;
    private static String vowels = "AEIOUaeiou";   //only one

    public Word() {
    }

    public Word(String wrd) {
        word = wrd;
    }

    public void setWord(String wrd) {
        word = wrd;
    }

    public int getNumVowels() {
        int count=0;
        for(int i = 0; i < word.length(); i++){
            for(int k = 0; k < vowels.length(); k++){
                if(word.substring(i,i+1).equals(vowels.substring(k,k+1))){
                    count++;
                }
            }
        }




        return count;
    }

    public int getLength() {
        return word.length();
    }

    public String toString() {
        return word;
    }
}