package Ranjith_Thesis;

//JSON Object
import java.util.ArrayList;
import org.json.simple.JSONObject;

public class Debug {
    public static void JSONObject(JSONObject jsonObject){
        System.out.println("JSON Object: "+jsonObject.toJSONString());
    }
    public static void Headers(ArrayList<String> headers){
        System.out.println("Headers: "+headers);
    }
    public static void Number_of_objects(int RECORD_ID){
        System.out.println("Pushed RECORD_ID: "+RECORD_ID);
    }
    public static void Number_of_cells(int numberOfCells){
        System.out.println("Number of Cells (Excluding Headers): "+numberOfCells);
    }
    public static void Number_of_records_pushed(){
        System.out.println("Number of Records Pushed into ElasticSearch: "+(JSON_ElasticSearch.RECORD_ID - 1));
    }
    public static void Number_of_errors(int numberOfError){
        System.out.println("Number of Errors in reading cells: "+numberOfError);
    }
}
