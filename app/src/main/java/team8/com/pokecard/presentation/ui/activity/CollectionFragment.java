package team8.com.pokecard.presentation.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import team8.com.pokecard.PokemonApplication;
import team8.com.pokecard.R;
import team8.com.pokecard.data.manager.Navigator;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.presenter.CollectionPresenter;
import team8.com.pokecard.presentation.presenter.PokedexPresenter;
import team8.com.pokecard.presentation.ui.adapter.CollectionRecyclerAdapter;
import team8.com.pokecard.presentation.ui.adapter.PokedexAdapter;
import team8.com.pokecard.presentation.ui.view.CollectionView;
import team8.com.pokecard.presentation.ui.view.PokedexView;
import team8.com.pokecard.tools.CustomItemClickListener;

public class CollectionFragment extends Fragment implements CollectionView {
    RecyclerView recyclerView;
    ArrayList<Pokemon> pokemonArrayList;
    CollectionPresenter collectionPresenter;
    Context context;

    public static CollectionFragment newInstance() {
        Bundle args = new Bundle();
        CollectionFragment fragment = new CollectionFragment();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pokemonArrayList = new ArrayList<>();
        collectionPresenter = Navigator.getInstance().getCollectionPresenter(context,this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collection, container, false);

        setRecyclerView(view);
        // TODO: 09/03/2018 get the pokemon of the user 
        collectionPresenter.requestPokemonsOfUser();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.context = null;
    }

    private void setRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.collection_recycler);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(context, 2);

        final CollectionRecyclerAdapter recyclerAdapter = new CollectionRecyclerAdapter(pokemonArrayList, context, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

            }
        });

        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void DisplayCollectionPokemon(List<Pokemon> allPokemon) {
        pokemonArrayList.addAll(allPokemon);
        recyclerView.getAdapter().notifyDataSetChanged();

    }

    @Override
    public void displayErrorMessage() {

    }

    @Override
    public void displayInformationMessage() {

    }
}
