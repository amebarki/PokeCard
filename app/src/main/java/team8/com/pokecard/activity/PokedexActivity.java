package team8.com.pokecard.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

import team8.com.pokecard.Adapter.PokedexAdapter;
import team8.com.pokecard.model.Pokemon;
import team8.com.pokecard.JsonPackage.RecupApi;
import team8.com.pokecard.R;


public class PokedexActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static ListView list_pokemon_listview;
    private static ArrayList<Pokemon> array;
    private static PokedexAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pokemon);
         array = new ArrayList<>();
        list_pokemon_listview = (ListView) findViewById(R.id.list_pokemon_list_view);

        adapter = new PokedexAdapter(this,array);
        list_pokemon_listview.setAdapter(adapter);

        RecupApi recup = new RecupApi();
        recup.execute(array,adapter);
        // envoyer instance d'une liste et la mettre a jour dans l'async task

    }
}