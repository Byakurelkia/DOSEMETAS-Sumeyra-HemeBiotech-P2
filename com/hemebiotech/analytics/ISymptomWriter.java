package com.hemebiotech.analytics;
import java.util.Map;

public interface ISymptomWriter {
   
   /* write symptoms in a specified file */
  void writeSymptoms(Map<String,Integer> symptoms);
}
