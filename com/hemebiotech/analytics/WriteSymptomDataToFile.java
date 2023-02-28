package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.io.File;

//Class for writes symptoms and quantity 
public class WriteSymptomDataToFile implements  ISymptomWriter {

  public WriteSymptomDataToFile (){
  }

  //write symptoms and quantity on the file specified
  public void writeSymptoms(Map<String,Integer> mapSymptoms){
    if(fileExists("result.out")){
      try{
        BufferedWriter bWriter = new BufferedWriter(new FileWriter("result.out"));
        for(Map.Entry<String,Integer> datas : mapSymptoms.entrySet()){
        bWriter.write(datas.getKey() + ":"+ datas.getValue());
      }
      }catch(Exception e){
        e.printStackTrace();
      }
      
    } 
}

//control if file is present or not, if not, creates a new file
public static boolean fileExists(String pathFile){

		 
      boolean value;
		  try {
      File file = new File (pathFile);
			if(file.createNewFile())
				  value = true;
			  else
				  value = true;
			}
			 catch (Exception e)
			 {
					e.printStackTrace();
          value = false;
			  }
		  return value;
		}
}
