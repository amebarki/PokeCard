package team8.com.pokecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import team8.com.pokecard.JsonPackage.RecupApi;


public class ListPokemonActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pokemon);
        TextView test = (TextView) findViewById(R.id.tv);


        RecupApi recup = new RecupApi();
        recup.execute(test);


    }
}