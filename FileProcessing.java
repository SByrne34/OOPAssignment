package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FileProcessing {

	String Filename;
	Scanner Scan1;
	Scanner Scan2;
	
	static int tally;
	static LinkedHashMap<String, Integer> fileMap = new LinkedHashMap<>();
	static HashMap<String, Integer> Temporary = new HashMap<>();
	static int k;
	static ArrayList<String> stopList = new ArrayList<String>();

	FileProcessing (String Filename)
	{
		this.Filename = Filename;
	}
	
	public void  readFile(String Filename, int n) 
	{

		ArrayList<String> Array1 = new ArrayList<>();
			
		try
		{
			File stopFile = new File("stopwords.txt");
			Scan1 = new Scanner(stopFile);
			while (Scan1.hasNext())
			{
				stopList.add(Scan1.next());
			}
			Scan1.close();
    
			File newFile = new File(Filename);
			Scan2 = new Scanner(newFile);
			
			while (Scan2.hasNext())
			{
				String word = Scan2.next();
				if (stopList.contains(word))
				{
					
				}
				else
				{
					Array1.add(word);
				}
			}
			Scan2.close();
			
			
			for (String Words : Array1)
			{
				fileMap.put(Words, Collections.frequency(Array1, Words));
			}
			

			// Taken from online source: https://stackoverflow.com/questions/43922882/how-to-print-hashmap-elements-from-max-to-min
			fileMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(n)
            
            .forEach(x ->
                    {
                        System.out.println(x.getKey() + " Amount = "+ x.getValue());
                    });
			
		
			for (String element : fileMap.keySet())
			{
				if (Temporary.containsKey(element)) 
                { 
						
			
                  if (Temporary.containsValue(fileMap.get(element))) 
                  { 
                      tally++;
                  }
                }
			}
			
	
			if (k == 0)
			{

				Temporary.putAll(fileMap);
				k = 1;
			}
		}
        
		catch (FileNotFoundException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}
