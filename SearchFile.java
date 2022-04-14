package assignment;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class SearchFile {
	
	Scanner FileScanner;
	String Name;
	File newFile;
	
	SearchFile (String Name)
	{
		this.Name = Name;
	}
	
	void FileConnection()
	{
		newFile = new File(Name);
	}
	
	String[] FileReader()
	{
		int count = 0;
		String word = "Crazy";
		try
		{
			
			FileScanner = new Scanner(newFile);
			while (FileScanner.hasNextLine());
			{
				String FileLines = FileScanner.nextLine();
				
				if (FileLines.contains(word))
				{
					count++;
				}
				else
				{
					System.out.println("Word is not present in file");
				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("run time error " + e.getMessage());
		}
		
		finally
		{
			return count;
		}
	}
}
