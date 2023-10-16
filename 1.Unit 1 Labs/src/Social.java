//© A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class Social
{
   private String socialNum;
   private int sum;

	public Social()
	{
	}

	public Social(String soc)
	{
		socialNum = soc;
	}


	public void setWord(String w)
	{
		socialNum = w;
	}

	public void chopAndAdd()
	{
		String sub = socialNum;
		String first = sub.substring(0,sub.indexOf("-"));
		System.out.println(first);
		String second = sub.substring(sub.indexOf("-")+1,sub.lastIndexOf("-"));
		System.out.println(second);
		String third = sub.substring(sub.lastIndexOf("-")+1,sub.length());
		System.out.println(third);

		sum = Integer.parseInt(first) + Integer.parseInt(second) + Integer.parseInt(third);

	}

	public String toString()
	{
		return "SS# " + socialNum + " has a total of " + sum + "\n";
	}
}