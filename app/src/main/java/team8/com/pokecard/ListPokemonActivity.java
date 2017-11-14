package team8.com.pokecard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

import team8.com.pokecard.Adapter.ListPokemonAdapter;
import team8.com.pokecard.JsonPackage.Pokemon;
import team8.com.pokecard.JsonPackage.RecupApi;


public class ListPokemonActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static ListView list_pokemon_listview;
    private static ArrayList<Pokemon> array;
    private static ListPokemonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_pokemon);
         array = new ArrayList<>();
        list_pokemon_listview = (ListView) findViewById(R.id.list_pokemon_list_view);

        adapter = new ListPokemonAdapter(this,array);
        list_pokemon_listview.setAdapter(adapter);

        RecupApi recup = new RecupApi();
        recup.execute(array,adapter);
        // envoyer instance d'une liste et la mettre a jour dans l'async task

    }
}