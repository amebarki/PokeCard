package team8.com.pokecard.presentation.presenter;

import java.util.List;

import team8.com.pokecard.data.model.Pokemon;

/**
 * Created by Adam on 19/11/2017.
 */

public interface BasePresenter{

    void getPokemon(Pokemon p);

    void getListPokemons(List<Pokemon> allPokemon);

    void infoMessage(String message);

    void errorMessage(String message);
}
