package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {	

  private static ISymptomWriter writer;
  private static ISymptomReader reader;

  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  public List<String> getSymptoms() {//return all symtpoms -without quantity & not ordonned
    return reader.getSymptoms();
  }

	//return all symptoms with quantity
  public Map<String,Integer> countSymptoms(List<String> symptoms) {
    Map<String,Integer> mapList =new HashMap<>();
		int quantity=0;
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
			quantity = 0;
		}
		return mapList;
	}

	//return all symptoms and quantity in alphabetical order
  public Map<String,Integer> sortSymptoms(Map<String,Integer> symptoms) {
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
  
	//write symptoms in a specified file
  public void writeSymptoms(Map<String,Integer> symptoms) {
    writer.writeSymptoms(symptoms);
  }

}

