package team8.com.pokecard.json;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

import javax.net.ssl.HttpsURLConnection;

import team8.com.pokecard.PokemonApplication;
import team8.com.pokecard.presentation.ui.adapter.PokedexAdapter;
import team8.com.pokecard.data.model.Pokemon;

/**
 * Created by iem on 07/11/2017.
 */

public class RecupApi extends AsyncTask<Object, Void, String> {
    private String test;
    private URL url;
    private ArrayList<Pokemon> list_pokemon;
    private PokedexAdapter adapter;
    @Override
    protected String doInBackground(Object... objects) {
        try {
            list_pokemon = (ArrayList<Pokemon>) objects[0];
            adapter = (PokedexAdapter) objects[1];
            test = this.GET();
            Boolean b =  list_pokemon.addAll(this.parseJSOn(test));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return test;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        this.adapter.notifyDataSetChanged();
    }

    protected String GET() throws IOException {

        String str = "";
        String urlLink = PokemonApplication.API_BASE_URL + "pokemon/generation/get/1";
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
        } catch (IOException e) {
            final Exception ex = e;
            e.printStackTrace();
            str = e.getMessage();
        }
        return str;
    }

    public Collection<Pokemon> parseJSOn(String url) {
        Gson gson = new Gson();
        Type collectionType = new TypeToken<Collection<Pokemon>>() {
        }.getType();
        Collection<Pokemon> poke = gson.fromJson(url, collectionType);
        return poke;
    }


    protected void POST(String myurl, String parameters) {

        HttpURLConnection conn = null;
        try {
            StringBuffer response = null;
            URL url = new URL(myurl);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            OutputStream out = new BufferedOutputStream(conn.getOutputStream());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.write(parameters.toString());
            writer.close();
            out.close();
            int responseCode = conn.getResponseCode();
            Log.d("POST REQUEST : ", responseCode + "");
            switch (responseCode) {
                case 200:
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String inputLine;
                    response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }


    protected String getGeneration(int generation_id) {
        String str = "";
        String urlLink = "http://pokecard.local/index.php/generation/get/" + generation_id;
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
        } catch (IOException e) {
            final Exception ex = e;
            e.printStackTrace();
            str = e.getMessage();
        }
        return str;
    }


    public Collection<Pokemon> getList_pokemon() {
        return list_pokemon;
    }


}
