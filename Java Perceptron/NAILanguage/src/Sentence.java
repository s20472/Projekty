import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence 
{
	double[] appearance;
	String lang;
	
	public Sentence(String input)
	{
		String regex = "(...);(.*)";
		Pattern p=Pattern.compile(regex);
		Matcher m = p.matcher(input);
		if(m.matches())
		{
			String temp = m.group(2).replaceAll("[^a-zA-Z]", "").toLowerCase();
			double length = temp.length();
			this.lang=m.group(1);
			this.appearance = new double[26];
			for(char x : temp.toCharArray())
			{
				appearance[x-97]+=1.0;
			}
			for(double x : appearance)
			{
				x=x/length;
			}
		}
		else
		{
			String temp = input.replaceAll("[^a-zA-Z]", "").toLowerCase();
			double length = temp.length();
			this.appearance = new double[26];
			for(char x : temp.toCharArray())
			{
				appearance[x-97]+=1.0;
			}
			for(double x : appearance)
			{
				x=x/length;
			}
		}
	}
	
	//kalkuluje "dystans" miêdzy jednym zdaniem a drogim u¿ywaj¹c tabeli wag
	public double distance(Sentence other)
	{
		double result =0.0;
		for(int i=0;i<26;i++)
		{
			result+=Math.pow(other.appearance[i]-this.appearance[i],2.0);
		}
		result=Math.sqrt(result);
		return result;
	}
	
}
