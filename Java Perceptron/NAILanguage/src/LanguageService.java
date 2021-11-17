import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LanguageService 
{
	String sourcePath = "data/TrainSet.csv";
	String testPath = "data/TestSet.csv";
	List<Perceptron> languages;
	double precision = 0.001;
	
	public LanguageService()
	{
		languages= new ArrayList<Perceptron>();
		languages.add(new Perceptron("Itl",precision));
		languages.add(new Perceptron("Esp",precision));
		languages.add(new Perceptron("Ptg",precision));
		LoadTrainSet();
	}
	//Trenuje perceptrony u¿ywaj¹c danych z pliku TrainSet.csv powtarza proces
	public void LoadTrainSet()
	{
		List<Sentence> dataSet= new ArrayList<Sentence>();
		try
		{
			
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(sourcePath));
			String line = reader.readLine();
			while (line != null) 
			{
				dataSet.add(new Sentence(line));
				line = reader.readLine();
			}
			reader.close();
			boolean allOk=false;
			while(!allOk)
			{
				allOk=true;
				for(Sentence sent : dataSet)
				{
					for(Perceptron perc : languages)
					{
						if(!perc.learn(sent))
							allOk=false;
					}
				}
			}
		}
		catch(Exception e)
			{
			System.out.println("File cant be open: "+sourcePath);
			}
	}
	
	//Testuje perceptronami Fragmenty teksu z pliku TestSet.csv (Wywo³ywane poprzez przycisk GUI)
	public String testFile()
	{
		String result = "";
		try
		{
			BufferedReader reader;
			reader = new BufferedReader(new FileReader(testPath));
			String line = reader.readLine();
			while (line != null) 
			{
				System.out.println(line);
				result+= determineLanguage(line)+" ";
				line = reader.readLine();
			}
			reader.close();
		}
		catch(Exception e)
			{
			System.out.println("File cant be open: "+testPath);
			}
		return result;
	}
	
	//Tworzy stringa zawieraj¹cego kody jêzyków wszystkich perceptronów które akceptuj¹ fragment tekstu
	public String determineLanguage(String input)
	{
		String result =".";
		Sentence sentence = new Sentence(input);
		for(Perceptron x : languages)
		{
			if(x.check(sentence))
			{
				result+=x.lang;
			}
		}
		return result;
	}
}
