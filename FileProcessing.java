// Name: Stephen Byrne

package assignment;

// Import java libraries
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FileProcessing 
{
	// Initialize attributes
	String Filename;
	Scanner Scan1;
	Scanner Scan2;
	static int tally;
	LinkedHashMap<String, Integer> fileMap = new LinkedHashMap<>();
	static HashMap<String, Integer> Temporary = new HashMap<>();
	static int k;
	static ArrayList<String> stopList = new ArrayList<String>();
	
	// Setter for the Filename attribute
	FileProcessing (String Filename)
	{
		this.Filename = Filename;
	}
	
	// This method allows the contents of the files selected to be read
	public void  readFile(String Filename, int n) 
	{
		// Initialize arrayList
		ArrayList<String> Array1 = new ArrayList<>();
			
		try
		{
			// Initialize file variable to store stopwords file and scanner to read file
			File stopFile = new File("stopwords.txt");
			Scan1 = new Scanner(stopFile);
			// Add words read into arrayList stopList
			while (Scan1.hasNext())
			{
				stopList.add(Scan1.next());
			}
			Scan1.close(); // Close scanner
    
			// Initialize file variable to store file chosen and read with scanner
			File newFile = new File(Filename);
			Scan2 = new Scanner(newFile);
			// Add words into arrayList but doesn't include words contained in stopwords file
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
			Scan2.close(); // Close scanner
			
			// Move values in arrayList Array1 into the linked hashMap fileMap
			for (String Words : Array1)
			{
				fileMap.put(Words, Collections.frequency(Array1, Words));
			}
			
			// Print top words in hashMap with the count beside each word
			// Taken from online source: https://stackoverflow.com/questions/43922882/how-to-print-hashmap-elements-from-max-to-min
			fileMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).limit(n)
            
            		.forEach(x ->
                    	{
                        	System.out.println(x.getKey() + " Amount = "+ x.getValue());
                    	}};
			
			// Count duplicate keys + values present in files using Hashmap Temporary
			for (String element : fileMap.keySet())
			{
				if (Temporary.containsKey(element)) 
               			{
					// The tally variable is incremented if duplicates are present
					if (Temporary.containsValue(fileMap.get(element))) 
                  			{ 
                      				tally++;
                  			}
                		}
			}
			
			// Copy values stored in linked Hashmap fileMap into the Hashmap Temporary
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
