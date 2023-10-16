//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class WordFun
{
	private String word;

	public WordFun()
	{
	}

	public WordFun(String w)
	{
		word = w;
	}

	public void setWord(String w)
	{
		word = w;
	}

	public void makeUpper()
	{
		word = word.toUpperCase();
	}

	public void addHyphen()
	{
		int loc;
		loc = word.indexOf(" ");
		word = word.substring(0,loc) + "-" + word.substring(loc+1,word.length());

	}

	public String toString()
	{
		return word + "\n";
	}
}