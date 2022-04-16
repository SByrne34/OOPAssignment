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
    }
    
    catch (FileNotFoundException e) 
		{
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
