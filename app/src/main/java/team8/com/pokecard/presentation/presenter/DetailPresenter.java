package team8.com.pokecard.presentation.presenter;

import android.content.Context;

import team8.com.pokecard.data.manager.PokemonManager;
import team8.com.pokecard.presentation.ui.view.DetailView;

/**
 * Created by iem on 15/11/2017.
 */

public class DetailPresenter {

    private Context context = null;
    private PokemonManager pokemonManager = null;
    private DetailView detailView = null;

    public DetailPresenter(Context context, PokemonManager manager, DetailView view)
    {
        this.context = context;
        this.pokemonManager = manager;
        this.detailView = view;
    }

}
