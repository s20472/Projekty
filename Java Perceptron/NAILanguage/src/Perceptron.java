
public class Perceptron 
{
	
	double[] wagi;
	double uczenie;
	String lang;

	//n = pr�g uczenia
	public Perceptron(String lang,double n)
	{
		this.lang = lang;
		this.uczenie = n;
		this.wagi=new double[26];
		for(int i=0;i<wagi.length;i++)
		{
			wagi[i]=0.05;
		}
	}
	
	//perceptron uczy si� zmieniaj�c wagi w wektorze znak�w poki nie zostanie otrzymany oczekiwany rezultat
	boolean learn(Sentence sentence)
	{
		double real;
		double expected;
		boolean result;
		if(sentence.lang.equals(lang))
			expected=1.0;
		else
			expected=0.0;
		if(check(sentence))
			real=1.0;
		else
			real=0.0;
		if(expected!=real)
		{
			result=false;
			for(int i=0;i<wagi.length;i++)
			{
				wagi[i]=wagi[i]+(sentence.appearance[i]*uczenie*(expected-real));
			}
		}
		else
			result = true;
		return result;
	}
	
	//Por�wnuje wektor wag wektora z perceptronem i zwraca decyzj� czy j�zyk zosta� wykryty
	boolean check(Sentence sentence)
	{
		double sum = 0.0;
		for(int i=0;i<wagi.length;i++)
		{
			sum+=sentence.appearance[i]*wagi[i];
		}
		System.out.println(lang + " " + sum);
		if(sum<=0)
			return false;
		else
			return true;
	}
}
