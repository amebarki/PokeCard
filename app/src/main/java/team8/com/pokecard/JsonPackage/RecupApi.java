package team8.com.pokecard.JsonPackage;

import android.os.AsyncTask;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by iem on 07/11/2017.
 */

public class RecupApi extends  AsyncTask<Object, Void, String> {

        private TextView tv;
        private URL url;
        private String test="";
    @Override
    protected String doInBackground(Object... objects) {
        tv = (TextView) objects[0];
        try {
            test = this.GET();
        } catch (IOException e) {
            e.printStackTrace();
        }

            test = this.parseJSOn(test);

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tv.setText(test);
    }

    protected String GET() throws IOException {

            String str="";
            String urlLink ="http://pokecard.local/index.php/gamers/response";
           try {
               url = new URL(urlLink);
               HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
               if (httpURLConnection.getResponseCode() == HttpsURLConnection.HTTP_OK) {
                   String temp;
                   StringBuilder builder = new StringBuilder();
                   BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                   while ((temp = in.readLine()) != null) {
                       builder.append(temp);
                   }
                   str = builder.toString();

               }
           }
           catch (IOException e)
           {
               final Exception ex = e;
               e.printStackTrace();
                   str = e.getMessage();
           }
            return  str;
    }

    protected String parseJSOn(String url){
        Gson gson = new Gson();
        Pokemon poke = gson.fromJson(url, Pokemon.class);
        return poke.toString();

    }


}
