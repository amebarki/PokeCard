package team8.com.pokecard.presentation.ui.view;

import java.util.List;

import team8.com.pokecard.data.model.Exchange;

/**
 * Created by Adam on 07/03/2018.
 */

public interface ExchangeView extends BaseView {

        void displayListOfTradePokemons(List<Exchange> tradeList);

}
