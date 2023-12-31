import java.util.*;

public class PalindromeApp
{
    public static void main(String[] args)
    {
        PalindromeTester p = new PalindromeTester();
        Scanner keyboard = new Scanner(System.in);
        String ans;

        do
        {
            System.out.print("Enter a word --> ");
            String str = keyboard.nextLine();

            if(p.palindrome(str, str.length()) == true)
                System.out.println("This is a palindrome");
            else
                System.out.println("This is not a palindrome");

            System.out.println();
            System.out.print("Continue[Y/N]? ");
            ans = keyboard.nextLine();
            System.out.println();
        }
        while(ans.equalsIgnoreCase("y"));
    }
}

class PalindromeTester
{
    /**
     * @param str the string to test
     * @param strLength the length of str
     * @return true if str is a palindrome; false otherwise
     */
    public boolean palindrome(String str, int strLength)
    {
        if(strLength == 1 || str.equals("")){
            return true;
        }

        if(str.substring(0,1).equalsIgnoreCase(str.substring(strLength-1))){
            return palindrome(str.substring(1,strLength-1),strLength-2);
        }

        return false;

    }
}

/*
    racecar -> racecar true
    Basecase: "a" or ""

    racecar -> aceca -> cec -> e
    racebar -> aceba -> ceb -> false
    abba -> bb -> ""
 */