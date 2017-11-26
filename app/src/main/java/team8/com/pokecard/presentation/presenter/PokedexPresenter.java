package team8.com.pokecard.presentation.presenter;

import android.content.Context;

import java.util.List;

import team8.com.pokecard.data.manager.PokemonManager;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.ui.view.PokedexView;

/**
 * Created by iem on 15/11/2017.
 */

public class PokedexPresenter implements BasePresenter {

    Pokemon pok;
    PokedexView pokedexView;
    PokemonManager pokemonManager;
    Context context;
    Pokemon poke;
    public PokedexPresenter(Context context, PokedexView pokedexView)
    {
        this.context = context;
        this.pokedexView = pokedexView;
    }


  /*  public void test() {

        PokemonManager.getInstance().getPokemon(1, new PokemonManager.IPokemon() {
            @Override
            public void onSuccess(Pokemon p) {
                pok = p;
            }
        });

    }*/



    public void requestPokemon() {
            boolean success=true;
            // call manager
            PokemonManager.getInstance().getPokemon(1,this);


    }

    public void requestGeneration()
    {
        PokemonManager.getInstance().getGeneration(1,this);
    }

    @Override
    public void getPokemon(Pokemon p) {
        this.poke = p;
        if(poke !=null)
        {
            pokedexView.DisplayPokemon(poke);
        }
        else
        {
            // displayError
        }
    }

    @Override
    public void getGeneration(List<Pokemon> generation) {
        if(generation != null)
        {
            pokedexView.DisplayGeneration(generation);
        }else
        {
            // display Error
        }
    }
}
