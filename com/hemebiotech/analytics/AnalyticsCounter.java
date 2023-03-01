package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class AnalyticsCounter {
	private static int headacheCount = 0;	
	private static int rashCount = 0;		
	private static int pupilCount = 0;		

  private static ISymptomWriter writer;
  private static ISymptomReader reader;

  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer){
    this.reader = reader;
    this.writer = writer;
  }
	
	public static void main(String args[]) throws Exception {

   
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		int i = 0;	
		int headCount = 0;	
		while (line != null) {
			i++;	
			System.out.println("symptom from file: " + line);
			if (line.equals("headache")) {
				headCount++;
				System.out.println("number of headaches: " + headCount);
			}
			else if (line.equals("rush")) {
				rashCount++;
			}
			else if (line.contains("pupils")) {
				pupilCount++;
			}

			line = reader.readLine();	// get another symptom
		}
		
		// next generate output
		FileWriter writer = new FileWriter ("result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}

  public List<String> getSymptoms(){
    return reader.getSymptoms();
  }

  public Map<String,Integer> countSymptoms(List<String> symptoms){
    Map<String,Integer> mapList =new HashMap<>();
		int quantity=1;
		for ( int i = 0; i < symptoms.size(); i++) {
			String field = symptoms.get(i);
			for(int j = i; j < symptoms.size(); j++) {
				if(field.equals(symptoms.get(j))) {
					quantity  +=1;
				}
				else
					continue;
			}
			if(!mapList.containsKey(field))
			{
				mapList.put(field, quantity);
			}
			quantity = 1;
		}
		return mapList;
	}

 
  public Map<String,Integer> sortSymptoms(Map<String,Integer> symptoms){
    Map<String,Integer> mapSorted = new LinkedHashMap<String,Integer>();
		List<String> symptomsOnly = new ArrayList<String>();
		for(Map.Entry<String, Integer> c : symptoms.entrySet()) {
			symptomsOnly.add(c.getKey());
		}
		Collections.sort(symptomsOnly);
		int i = 0;
		while( i<symptomsOnly.size()) {
			mapSorted.put(symptomsOnly.get(i), symptoms.get(symptomsOnly.get(i)));
			i++;
		}
		return mapSorted;
	}
  

  public void writeSymptoms(Map<String,Integer> symptoms){
    writer.writeSymptoms(symptoms);
  }



}