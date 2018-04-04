package team8.com.pokecard.presentation.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import team8.com.pokecard.R;
import team8.com.pokecard.data.manager.Navigator;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.data.model.Trade;
import team8.com.pokecard.presentation.presenter.TradePresenter;
import team8.com.pokecard.presentation.ui.adapter.SelectRecyclerAdapter;
import team8.com.pokecard.presentation.ui.view.TradeView;
import team8.com.pokecard.tools.CustomItemClickListener;

public class SelectFragment extends Fragment implements TradeView {
    RecyclerView recyclerView;
    ArrayList<Trade> tradeArrayList;
    ArrayList<Pokemon> pokemonArrayList;
    TradePresenter tradePresenter;
    Context context;

    public SelectFragment() {
        // Required empty public constructor
    }

    public static SelectFragment newInstance() {
        SelectFragment fragment = new SelectFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tradeArrayList = new ArrayList<>();
        pokemonArrayList = new ArrayList<>();
        tradePresenter = Navigator.getInstance().getTradePresenter(context,this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_select, container, false);

        setRecyclerView(view);

        tradePresenter.requestExchangeList();


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
        recyclerView = view.findViewById(R.id.trade_select_recycler);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(context, 2);

        final SelectRecyclerAdapter recyclerAdapter = new SelectRecyclerAdapter(tradeArrayList, pokemonArrayList, context, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

            }
        });

        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void displayErrorMessage() {

    }

    @Override
    public void displayInformationMessage() {

    }

    @Override
    public void DisplayAllPokemon(List<Pokemon> allPokemon) {
        pokemonArrayList.addAll(allPokemon);
        recyclerView.getAdapter().notifyDataSetChanged();

    }

    @Override
    public void displayListOfTradePokemons(List<Trade> tradeList) {
        tradeArrayList.addAll(tradeList);
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}
