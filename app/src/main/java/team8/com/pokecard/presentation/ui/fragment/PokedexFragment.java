package team8.com.pokecard.presentation.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import team8.com.pokecard.PokemonApplication;
import team8.com.pokecard.R;
import team8.com.pokecard.data.manager.Navigator;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.data.model.Trade;
import team8.com.pokecard.presentation.presenter.PokedexPresenter;
import team8.com.pokecard.presentation.presenter.TradePresenter;
import team8.com.pokecard.presentation.ui.activity.DetailPokemonActivity;
import team8.com.pokecard.presentation.ui.adapter.PokedexAdapter;
import team8.com.pokecard.presentation.ui.view.PokedexView;
import team8.com.pokecard.presentation.ui.view.TradeView;

public class PokedexFragment extends Fragment implements PokedexView, TradeView {
    private ListView pokemonListView;
    private ArrayList<Pokemon> pokemonArrayList = new ArrayList<>();
    private PokedexAdapter pokedexAdapter;
    private PokedexPresenter pokedexPresenter;
    private TradePresenter tradePresenter;

    int idTradePokemon;
    boolean isTrading = false;

    public static PokedexFragment newInstanceTrade(int idTradePokemon) {
        return newInstance(PokemonApplication.PRINT_LIST_ALL,0, 0,idTradePokemon);
    }

    public static PokedexFragment newInstanceAll() {
        return newInstance(PokemonApplication.PRINT_LIST_ALL,0, 0, 0);
    }

    private static PokedexFragment newInstance(int printType, int generation, int id, int idTradePokemon) {
        PokedexFragment fragment = new PokedexFragment();
        Bundle bundle = new Bundle();

        //Ajout des arguments
        bundle.putInt("print", printType);
        bundle.putInt("generation", generation);
        bundle.putInt("id", id);
        bundle.putInt("idTradePokemon", idTradePokemon);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pokedexPresenter = Navigator.getInstance().getPokedexPresenter(getContext(),this);
        tradePresenter = Navigator.getInstance().getTradePresenter(getContext(),this);
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
        pokemonListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (isTrading) {
                    tradePresenter.insertExchangeOffer(idTradePokemon, pokemonArrayList.get(position).getId());

                    new AlertDialog.Builder(getActivity())
                            .setTitle("Success")
                            .setMessage("La proposition d'échange a bien été enregistrée")
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    getActivity().finish();
                                }
                            }).show();

                } else {

                    pokedexPresenter.saveIdOfSelectedPokemon(pokemonArrayList.get(position).getId());
                    Intent intent = new Intent(getActivity(), DetailPokemonActivity.class);

                    startActivity(intent);
                }

            }
        });

        //Mise à jour de la liste avec tout les Pokemon
        if(getArguments() != null) {
            int print = getArguments().getInt("print", PokemonApplication.PRINT_LIST_ALL);
            switch (print) {
                case PokemonApplication.PRINT_LIST_ONE:
                    pokedexPresenter.requestPokemon(getArguments().getInt("id"));
                    break;

                case PokemonApplication.PRINT_LIST_GENERATION:
                    pokedexPresenter.requestGeneration(getArguments().getInt("generation"));
                    break;

                default:
                    pokedexPresenter.requestAllPokemon();

            }

            int idTradePokemon = getArguments().getInt("idTradePokemon",0);

            if (idTradePokemon > 0) {
                this.idTradePokemon = idTradePokemon;
                this.isTrading = true;
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

    @Override
    public void displayListOfTradePokemons(List<Trade> tradeList) {

    }

    @Override
    public void displayErrorMessage() {

    }

    @Override
    public void displayInformationMessage() {

    }

}
