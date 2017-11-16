package team8.com.pokecard.presenter;

import team8.com.pokecard.manager.PokemonManager;
import team8.com.pokecard.model.Pokemon;

/**
 * Created by iem on 15/11/2017.
 */

public class PokedexPresenter {

    Pokemon pok;

    public void test() {



        PokemonManager.getInstance().getPokemon(1, new PokemonManager.IPokemon() {
            @Override
            public void onSuccess(Pokemon p) {
                pok = p;
            }
        });

    }



}
