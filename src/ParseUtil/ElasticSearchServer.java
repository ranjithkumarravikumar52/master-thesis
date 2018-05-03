package ParseUtil;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import org.json.simple.JSONObject;

public class ElasticSearchServer {

    private static final String ELASTIC_PORT = "http://localhost:9200";
    //name of the index - elastic search
    private static final String INDEX_NAME = "/ranjith-thesis";
    //name of the doc - elastic search
    private static final String DOC_NAME = "/Q24(Tier-1)";
    //record ID
    private static int recordID;

    public static void pushToElasticSearch(JSONObject jsonObj) {

        try {
            URL url = new URL(ELASTIC_PORT + INDEX_NAME + DOC_NAME + "/" + recordID);
//            System.out.println("Pushing above JSON Object to: " + url);
            HttpURLConnection portConnection = getHTTPConnection(url);
            writeToElasticSearchPort(portConnection, jsonObj);
            recordID++;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void writeToElasticSearchPort(HttpURLConnection connection, JSONObject jsonObj) {
        try {
            OutputStreamWriter outputStreamWriterObject = new OutputStreamWriter(connection.getOutputStream());
            outputStreamWriterObject.write(jsonObj.toJSONString());
            outputStreamWriterObject.flush();
            outputStreamWriterObject.close();
            System.err.println(connection.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static HttpURLConnection getHTTPConnection(URL url) throws ProtocolException, IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        return connection;
    }
}
