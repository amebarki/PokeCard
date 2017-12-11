package team8.com.pokecard.presentation.ui.view;

import java.util.List;

import team8.com.pokecard.data.model.Pokemon;

/**
 * Created by iem on 15/11/2017.
 */

public interface PokedexView {

    void DisplayPokemon(Pokemon pokemon);

    void DisplayGeneration(List<Pokemon> generation);

    void DisplayAllPokemon(List<Pokemon> allPokemon);
}
