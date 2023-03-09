package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Read symptoms and quantity from a specified file 
public class ReadSymptomDataFromFile implements ISymptomReader {
	private String filePath;
	
	public ReadSymptomDataFromFile (String filePath) {
		this.filePath = filePath;
	}
	
	// return a list of symtpoms, if symptoms not present, return null
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		
		if (filePath != null) {
			try
			 {
				BufferedReader reader = new BufferedReader (new FileReader(filePath));
				String line = reader.readLine();
				while(line != null)
				{
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
      }
  	} else 
      result = null;
		return result;
	}

}