package team8.com.pokecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;



public class ListPokemonActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pokemon);
        final TextView test = (TextView) findViewById(R.id.tv);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    URL url = new URL("http://pokecard.local/index.php/gamers/response");
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    if (httpURLConnection.getResponseCode() == HttpsURLConnection.HTTP_OK)
                    {
                        String temp;
                        StringBuilder builder = new StringBuilder();
                        BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                        while ((temp = in.readLine()) != null)
                        {
                            builder.append(temp);
                        }
                        final String str = builder.toString();
                        runOnUiThread(new Runnable()
                        {
                            @Override
                            public void run()
                            {
                                test.setText(str);
                            }
                        });
                    }
                }
                catch (IOException e)
                {
                    final Exception ex = e;
                    e.printStackTrace();
                    runOnUiThread(new Runnable()
                    {

                        @Override
                        public void run()
                        {
                            test.setText(ex.getMessage());
                        }
                    });
                }
            }
        }).start();
    }
}