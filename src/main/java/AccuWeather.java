import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class AccuWeather {
    public static void doHttpGet(){

        String url = "http://dataservice.accuweather.com/forecasts/v1/daily/5day/168720?apikey=" + ApiKey.getApiKey();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse resp = null;
        try {
            resp = client.execute(get);
            HttpEntity entity = resp.getEntity();
            System.out.println("Json response");
            System.out.println(EntityUtils.toString(entity));

        }
        catch (IOException ioe) { System.err.println("Something went wrong");  ioe.printStackTrace(); }
        catch (Exception e ){ System.err.println("Unknown error: "); e.printStackTrace(); }
    }
}
