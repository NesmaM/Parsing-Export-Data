
/**
 * Write a description of WhichCountryExport here.
 * 
 * @author (Nesma Abouzaid) 
 * @version (7/02/2023))
 */

import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountryExport {
    
    public void tester(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        
        
        //Make sure to rest parser for each test
        //parser = fr.getCSVParser();
        //Call countryInfo
        System.out.println(countryInfo(parser, "Germany"));
        
        //Call listExportersTwoProducts 
        parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "gold", "diamonds");
        
        //Call numberOfExporters
        parser = fr.getCSVParser();
        System.out.println("The number of Exporters exports gold is: " + numberOfExporters(parser, "gold"));
        
        //Call bigExporters
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999");
    }
    
    public void testerQuiz (){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "fish", "nuts");
        
        parser = fr.getCSVParser();
        System.out.println("The number of countries export sugar is: " + numberOfExporters(parser, "sugar"));
        
        parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Nauru"));        
        
        parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999");
    
    }
    
    public String countryInfo (CSVParser parser, String country){
        String result = "";
        for(CSVRecord record : parser){

            if(record.get("Country").equals(country)){
                result = record.get("Country");
                result = result.concat(": ");
                result = result.concat(record.get("Exports"));
                result = result.concat(": ");
                result = result.concat(record.get("Value (dollars)"));
            }
        }
        if (result == ""){
            return "NOT FOUND";
        } else {
            return result;
        }

        }
        
        
    public void listExportersTwoProducts (CSVParser parser, String exportItem1 , String exportItem2){
        for (CSVRecord record : parser){
            String testRecord = record.get("Exports");
            if (testRecord.contains(exportItem1) && testRecord.contains(exportItem2)){
                System.out.println(record.get("Country"));
            }
        }
    }
    
    public int numberOfExporters(CSVParser parser, String exportItem){
        int numberOfOccur = 0;
        for (CSVRecord record : parser){
            String testRecord = record.get("Exports");
            if (testRecord.contains(exportItem)){
                numberOfOccur = numberOfOccur +1;
            }
        }
        return numberOfOccur;
    }

    
    public void bigExporters (CSVParser parser, String amount){
        for (CSVRecord record : parser){
            String testRecord = record.get("Value (dollars)");
            if (testRecord.length() > amount.length()){
                System.out.println(record.get("Country") + " " + testRecord);
            }
        }
    }
}
    
    

