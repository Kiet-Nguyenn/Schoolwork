//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab06c
{
   public static void main( String args[] )
   {
		//add test cases
        WordsCompare test = new WordsCompare("abe","ape");
        test.compare();
        System.out.println(test);

        test.setWords("giraffe","gorilla");
        test.compare();
        System.out.println(test);

        test.setWords("one","two");
        test.compare();
        System.out.println(test);

        test.setWords("fun","funny");
        test.compare();
        System.out.println(test);

        test.setWords("123","19");
        test.compare();
        System.out.println(test);

        test.setWords("193","1910");
        test.compare();
        System.out.println(test);

        test.setWords("goofy","godfather");
        test.compare();
        System.out.println(test);

        test.setWords("funnel","fun");
        test.compare();
        System.out.println(test);

	}
}