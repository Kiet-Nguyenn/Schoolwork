import java.util.*;

public class MethodPractice2
{
    private Scanner keyboard = new Scanner(System.in);

    // Implement methods below this line

    public void greeting(String firstName, int num){
        for(int i = 0; i < num; i++){
            System.out.println(firstName + ", have a nice day.");
        }
    }

    public void range(int begin, int end){
        for(int i = begin; i <= end; i++){
            System.out.println(i);
        }
    }

    public boolean compare(String str){
        String firstLetter = str.substring(0,1);
        String lastLetter = str.substring(str.length()-1,str.length());
        if(firstLetter.equalsIgnoreCase(lastLetter)){
            return true;
        } else {
            return false;
        }
    }

    public String reverse(String str){
        String reversed = "";
        for(int i = str.length(); i > 0; i--){
            reversed += str.substring(i-1,i);
        }
        return reversed;
    }

    public int numOccurrences(String word, String letter){
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.substring(i,i+1).equalsIgnoreCase(letter)){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        MethodPractice2 app = new MethodPractice2();

        System.out.println("******************");
        System.out.println("   Test greeting");
        System.out.println("******************");
        app.greeting("Kendall", 6);

        System.out.println("\n\n******************");
        System.out.println("   Test range");
        System.out.println("******************");
        app.range(10, 15);

        System.out.println("\n\n******************");
        System.out.println("   Test compare");
        System.out.println("******************");
        System.out.println(app.compare("demand"));
        System.out.println(app.compare("football"));
        System.out.println(app.compare("bulb"));

        System.out.println("\n\n******************");
        System.out.println("   Test reverse");
        System.out.println("******************");
        System.out.println(app.reverse("ball"));
        System.out.println(app.reverse("courage"));
        System.out.println(app.reverse("hamburger"));

        System.out.println("\n\n******************");
        System.out.println("   Test numOccurrences");
        System.out.println("******************");
        System.out.println(app.numOccurrences("MISSISSIPPI", "I"));
        System.out.println(app.numOccurrences("AUTOMOBILE", "O"));
        System.out.println(app.numOccurrences("TEXAS", "R"));
        System.out.println();
    }
}