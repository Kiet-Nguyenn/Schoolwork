import static java.lang.System.*;

public class ChickenCounter {
    public static void main(String args[]) {
        String word = "itatfun";
        String word2 = "itatchickenfun";
        String word3 = "chchickchickenenicken";
        String word4 = "chickchickfun";
        String word5 = "chickenbouncetheballchicken";

        out.println("Chicken count for " +word+ ": " + countChickens(word));
        out.println("Chicken count for " +word2+ ": " + countChickens(word2));
        out.println("Chicken count for " +word3+ ": " + countChickens(word3));
        out.println("Chicken count for " +word4+ ": " + countChickens(word4));
        out.println("Chicken count for " +word5+ ": " + countChickens(word5));

    }

    public static int countChickens(String word) {
        if(word.indexOf("chicken") >= 0){
            return 1 + countChickens(word.substring(0, word.indexOf("chicken")) + word.substring(word.indexOf("chicken") + 7));
        }
        return 0;
    }
}