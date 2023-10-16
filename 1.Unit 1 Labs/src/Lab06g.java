//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Lab06g
{
	public static void main( String args[] )
	{
	   WordFun test = new WordFun("Hello World");
	   out.println(test);
	   test.makeUpper();
	   out.println(test);
	   test.addHyphen();
	   out.println(test);

	   //add more test cases

		test.setWord("Jim Bob");
		out.println(test);
		test.makeUpper();
		out.println(test);
		test.addHyphen();
		out.println(test);

		test.setWord("Computer Science");
		out.println(test);
		test.makeUpper();
		out.println(test);
		test.addHyphen();
		out.println(test);

		test.setWord("UIL TCEA");
		out.println(test);
		test.makeUpper();
		out.println(test);
		test.addHyphen();
		out.println(test);

		test.setWord("State Champions");
		out.println(test);
		test.makeUpper();
		out.println(test);
		test.addHyphen();
		out.println(test);
	}
}
