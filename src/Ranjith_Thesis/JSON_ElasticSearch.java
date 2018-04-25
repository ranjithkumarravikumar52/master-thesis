package Ranjith_Thesis;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;


public class JSON_ElasticSearch {
    //assign each JSON object with an id
    public static int RECORD_ID=1;
    
    public static void PushJSON(JSONObject jsonObject){
        
        try{
            
            URL url = new URL(Ranjith_Thesis_Main.ELASTIC_PORT+Ranjith_Thesis_Main.INDEX_NAME+Ranjith_Thesis_Main.DOC_NAME+"/"+RECORD_ID);
            System.out.println("Pushing above JSON Object to: "+url);            
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            OutputStreamWriter osw = new OutputStreamWriter(connection.getOutputStream());
            osw.write(jsonObject.toJSONString());
            osw.flush();
            osw.close();
            System.err.println(connection.getResponseCode());
            RECORD_ID++;  
            //Next build check for error codes
        }
        catch(Exception e){
            System.out.println("Push Failed");
            e.printStackTrace();
        }        
        
    }
}
