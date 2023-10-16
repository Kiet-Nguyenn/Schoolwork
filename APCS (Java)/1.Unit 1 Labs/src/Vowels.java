import java.util.Scanner;

public class Vowels {
    String[] words = new String[10];

    public void getWords(){
        Scanner key = new Scanner(System.in);
        System.out.println("Enter 10 Words: ");
        for(int i = 0 ; i < 10; i++){
            System.out.print("Word " + (i + 1) + "--> " );
            words[i] = key.nextLine();
        }
    }

    public boolean equalsVowel(String str){
        if(str.equalsIgnoreCase("a") || str.equalsIgnoreCase("e") || str.equalsIgnoreCase("i") || str.equalsIgnoreCase("o") || str.equalsIgnoreCase("u") || str.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
    }

    public int countVowels(String str){
        int vowels = 0;
        for(int i = 0; i < str.length(); i++){
            if (equalsVowel(str.substring(i,i+1))){
                vowels++;
            }
        }
        return vowels;
    }

    public void print(){
        for(int i = 0; i < words.length; i++){
            System.out.println(words[i] + " - " + countVowels(words[i]));
        }
    }

    public static void main(String args[]){
        Vowels app = new Vowels();
        app.getWords();
        System.out.println();
        app.print();
    }

}
