package team8.com.pokecard.presentation.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import team8.com.pokecard.PokemonApplication;
import team8.com.pokecard.R;
import team8.com.pokecard.data.manager.Navigator;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.presenter.PokedexPresenter;
import team8.com.pokecard.presentation.ui.adapter.PokedexAdapter;
import team8.com.pokecard.presentation.ui.view.PokedexView;

public class PokedexFragment extends Fragment implements PokedexView {
    private ListView pokemonListView;
    private ArrayList<Pokemon> pokemonArrayList = new ArrayList<>();
    private PokedexAdapter pokedexAdapter;
    private PokedexPresenter pokedexPresenter;

    public static PokedexFragment newInstanceAll() {
        return newInstance(PokemonApplication.PRINT_LIST_GENERATION,1, 0);
    }

    private static PokedexFragment newInstance(int printType, int generation, int id) {
        PokedexFragment fragment = new PokedexFragment();
        Bundle bundle = new Bundle();

        //Ajout des arguments
        bundle.putInt("print", printType);
        bundle.putInt("generation", generation);
        bundle.putInt("id", id);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pokedexPresenter = Navigator.getInstance().getPokedexPresenter(getContext(),this);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokedex, container, false);

        //Initialisation des variables
        pokemonArrayList = new ArrayList<>();
        pokedexAdapter = new PokedexAdapter(getContext(), pokemonArrayList);
        pokemonListView = view.findViewById(R.id.pokedex_list_view);

        pokemonListView.setAdapter(pokedexAdapter);

        //Mise à jour de la liste avec tout les Pokemon
        if(savedInstanceState != null) {
            int print = savedInstanceState.getInt("print");
            switch (print) {
                case PokemonApplication.PRINT_LIST_ONE:
                    pokedexPresenter.requestPokemon(savedInstanceState.getInt("id"));
                    break;

                case PokemonApplication.PRINT_LIST_GENERATION:
                    pokedexPresenter.requestGeneration(savedInstanceState.getInt("generation"));
                    break;

                default:
                    pokedexPresenter.requestAllPokemon();

            }
        } else {
            pokedexPresenter.requestAllPokemon();
        }

        return view;
    }

    @Override
    public void DisplayPokemon(Pokemon pokemon) {
        //Affiche le Pokemon
        pokemonArrayList.add(pokemon);
        pokedexAdapter.notifyDataSetChanged();
    }

    @Override
    public void DisplayGeneration(List<Pokemon> generation) {
        //Affiche tous les Pokemon de la génération
        pokemonArrayList.addAll(generation);
        pokedexAdapter.notifyDataSetChanged();
    }

    @Override
    public void DisplayAllPokemon(List<Pokemon> allPokemon) {
        //Affiche tous les Pokemon
        Log.d("Display",allPokemon.toString());
        pokemonArrayList.addAll(allPokemon);
        pokedexAdapter.notifyDataSetChanged();
    }

}
