import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class WordsTester
{
    public static void main( String args[] )
    {
        Words test = new Words("one two three four five six seven alligator");
        out.println(test);
        out.println("word with 2 vowels = "+test.countWordsWithXVowels(2));
        out.println("word with 3 vowels = "+test.countWordsWithXVowels(3));
        out.println("word with 4 vowels = "+test.countWordsWithXVowels(4));
        out.println("word with 2 chars = "+test.countWordsWithXChars(2));
        out.println("word with 3 chars = "+test.countWordsWithXChars(3));
        out.println("word with 4 chars = "+test.countWordsWithXChars(4));
        out.println("word with 5 chars = "+test.countWordsWithXChars(5));
        int vowelsRemoved = test.removeWordsWithXChars(3);
        out.println("\nafter removing words with 3 chars \n" + test);
        out.println("\nnumber of vowels in the words removed == " + vowelsRemoved);
        out.println("\n\n");


        //more test cases

    }
}

class Words
{
    private ArrayList<String> words;
    private static String vowels = "AEIOUaeiou";   //only one

    public Words()
    {
        setWords("");
    }

    public Words(String wordList)
    {
        words = new ArrayList<>();
        while(wordList.indexOf(' ') != -1){
            words.add(wordList.substring(0, wordList.indexOf(' ')));
            wordList = wordList.substring(wordList.indexOf(' ')+1);
        }

        words.add(wordList);
    }

    public void setWords(String wordList)
    {
        words = new ArrayList<>();
        while(wordList.indexOf(' ') != -1){
            words.add(wordList.substring(0, wordList.indexOf(' ')));
            wordList = wordList.substring(wordList.indexOf(' ')+1);
        }

        words.add(wordList);
    }

    public int countWordsWithXChars(int size)
    {
        int count=0;
        for(int i = 0; i < words.size(); i++){
            if(words.get(i).length() == size){
                count++;
            }
        }
        return count;
    }

    //this method will remove all words with a specified size / length
    //this method will also return the sum of the vowels in all words removed
    public int removeWordsWithXChars(int size) {
        ArrayList<String> removed = new ArrayList<>();
        for(int i = words.size()-1; i>= 0; i--){
            if(words.get(i).length() == size){
                removed.add(words.remove(i));
            }
        }

        int count = 0;

        for(int i = 0; i < removed.size(); i++){
            for(int k = 0; k < removed.get(i).length(); k++){
                for(int vowel = 0; vowel < vowels.length(); vowel++){
                    if(removed.get(i).substring(k,k+1).equals(vowels.substring(vowel,vowel+1))){
                        count++;
                    }
                }
            }
        }


        return count;
    }

    public int countWordsWithXVowels(int numVowels)
    {
        int count=0;
        int vowelCount = 0;
        for(int word = 0; word < words.size(); word++){
            for(int letter = 0; letter < words.get(word).length(); letter++) {
                for (int k = 0; k < vowels.length(); k++) {
                    if (words.get(word).substring(letter, letter + 1).equals(vowels.substring(k, k + 1))) {
                        vowelCount++;
                    }
                }
            }
            if(vowelCount == numVowels){
                count++;
            }
            vowelCount = 0;
        }
        return count;
    }

    public String toString()
    {
        return "" + words;
    }
}