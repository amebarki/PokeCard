package team8.com.pokecard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import team8.com.pokecard.JsonPackage.RecupApi;


public class ListPokemonActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static ListView list_pokemon_listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pokemon);

        list_pokemon_listview = (ListView) findViewById(R.id.list_pokemon_list_view);
        RecupApi recup = new RecupApi();
        recup.execute();

    }
}