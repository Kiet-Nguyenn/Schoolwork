import java.util.*;
import java.io.*;

public class SpellCheck2 {
    // constant
    public static final int LIST_SIZE = 150000;

    // instance variable
    private String[] wordList;   // list of words
    private int numWords = 0;   // logical size of wordList

    // constructor
    public SpellCheck2() {
        wordList = new String[LIST_SIZE];
        readFile();
        searchWords();
    }

    // Performs a binary search on the wordlist looking for key.
// If key is found, it returns true;  
// otherwise it returns false
    public boolean binarySearch(String key) {
        int left = 0;
        int right = wordList.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(key.equals(wordList[mid])){
                return true;
            }
            if(key.compareTo(wordList[mid]) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public boolean recursiveBinarySearch(String key, int left, int right){
        int mid = (left + right) / 2;
        if(key.equals(wordList[mid])){
            return true;
        }
        if(left > right){
            return false;
        }
        if(key.compareTo(wordList[mid]) < 0){
            return recursiveBinarySearch(key, left, mid - 1);
        } else {
            return recursiveBinarySearch(key, mid + 1, right);
        }
    }

    // Interface used to check spelling of words
    public void searchWords() {
        Scanner keyboard = new Scanner(System.in);
        String ans = "Y";
        while (ans.equalsIgnoreCase("Y")) {
            System.out.print("Enter word -->");
            String word = keyboard.nextLine();
            System.out.println();
            if (recursiveBinarySearch(word, 0, numWords) == true)
                System.out.println(word + " is spelled correctly.");
            else {
                System.out.println(word + " is spelled incorrectly!");
            }
            System.out.println();
            System.out.print("Enter another word[Y/N]? ");
            ans = keyboard.nextLine();
            System.out.println();
        }
    }

    // Populates wordlist from a text file of words
    // Updates logical size of wordList
    public void readFile() {
        System.out.println("Reading wordlist ...");
        System.out.println();
        Scanner scan = null;
        try {
            scan = new Scanner(new File("spellcheck.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("File not found.");
        }
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            wordList[numWords] = str;
            numWords++;
        }
    }

    public static void main(String[] args) {
        SpellCheck2 spellCheck = new SpellCheck2();
    }
}