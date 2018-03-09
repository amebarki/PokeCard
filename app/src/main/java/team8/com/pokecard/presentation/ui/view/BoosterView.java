package team8.com.pokecard.presentation.ui.view;

import java.util.ArrayList;
import java.util.List;

import team8.com.pokecard.data.model.Pokemon;

/**
 * Created by Adam on 07/03/2018.
 */

public interface BoosterView extends BaseView {

    void DisplayBoosterPack(List<Pokemon> boosterPackPokemons);
}
