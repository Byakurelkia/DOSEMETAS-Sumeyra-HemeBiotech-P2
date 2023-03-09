package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class Main {

public static void main(String[] args){

  ISymptomReader rSymptomReader = new ReadSymptomDataFromFile("symptoms.txt");
  ISymptomWriter rSymptomWriter =  new WriteSymptomDataToFile();
  AnalyticsCounter aCounter = new AnalyticsCounter(rSymptomReader, rSymptomWriter);

  List<String> symptoms = aCounter.getSymptoms();
  Map<String, Integer> countSymptoms = aCounter.countSymptoms(symptoms);
  Map<String,Integer> sortedSymtpoms = aCounter.sortSymptoms(countSymptoms);
  aCounter.writeSymptoms(sortedSymtpoms);
  



}



}