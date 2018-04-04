package team8.com.pokecard.presentation.ui.view;

import java.util.List;

import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.data.model.Trade;

/**
 * Created by Adam on 07/03/2018.
 */

public interface TradeView extends BaseView {

        void DisplayAllPokemon(List<Pokemon> allPokemon);

        void displayListOfTradePokemons(List<Trade> tradeList);

}
