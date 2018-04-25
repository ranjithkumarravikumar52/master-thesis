package Ranjith_Thesis;

public class Ranjith_Thesis_Main {
    
    //port to elastic search
    public static final String ELASTIC_PORT = "http://localhost:9200";
    //name of the index
    public static final String INDEX_NAME = "/ranjith-thesis";
    //name of the doc
    public static final String DOC_NAME = "/Q24(Tier-1)";
    //filename; change name here to change the excel file to parse;
    public static final String FILE_NAME = "Open-Ended.xlsx";

    public static void main(String[] args){
        
        Excel_JSON.parseExceltoJSON(FILE_NAME);
        
    }//end main
 
}
