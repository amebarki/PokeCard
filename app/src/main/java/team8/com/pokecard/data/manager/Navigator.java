package team8.com.pokecard.data.manager;

import android.content.Context;

import team8.com.pokecard.presentation.presenter.CollectionPresenter;
import team8.com.pokecard.presentation.presenter.DetailPresenter;
import team8.com.pokecard.presentation.presenter.HomePresenter;
import team8.com.pokecard.presentation.presenter.PokedexPresenter;
import team8.com.pokecard.presentation.ui.view.CollectionView;
import team8.com.pokecard.presentation.ui.view.DetailView;
import team8.com.pokecard.presentation.ui.view.HomeView;
import team8.com.pokecard.presentation.ui.view.PokedexView;

/**
 * Created by Adam on 02/03/2018.
 */

public class Navigator {

    private static Navigator instance =null;
    private PokemonDatabaseManager pokemonDatabaseManager = null;
    private PokemonManager pokemonManager = null;
    private UserManager userManager = null;


    public void init()
    {
        this.pokemonManager = new PokemonManager();
        this.userManager = new UserManager();
        this.pokemonDatabaseManager = new PokemonDatabaseManager();
    }


    public static Navigator getInstance() {
        if(instance == null) {
            instance = new Navigator();
        }
        return instance;
    }



    public HomePresenter getHomePresenter(Context context, HomeView homeView)
    {
        return new HomePresenter();
    }

    public PokedexPresenter getPokedexPresenter(Context context, PokedexView pokedexView)
    {
        return new PokedexPresenter(context,this.getPokemonManager(),pokedexView);
    }

    public DetailPresenter getDetailPresenter(Context context, DetailView detailView)
    {
        return new DetailPresenter(context,this.getPokemonManager(),detailView);
    }

    public CollectionPresenter getCollectionPresenter(Context context, CollectionView collectionView)
    {
        return new CollectionPresenter(context,this.getPokemonManager(),collectionView);
    }




    public PokemonManager getPokemonManager() {
        return pokemonManager;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    public PokemonDatabaseManager getPokemonDatabaseManager() {
        return pokemonDatabaseManager;
    }
}