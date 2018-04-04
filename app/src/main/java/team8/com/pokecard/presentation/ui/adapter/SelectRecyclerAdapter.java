package team8.com.pokecard.presentation.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import team8.com.pokecard.R;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.data.model.Trade;
import team8.com.pokecard.tools.CustomItemClickListener;

/**
 * Created by iem on 06/12/2017.
 */

public class SelectRecyclerAdapter extends RecyclerView.Adapter<SelectRecyclerAdapter.MyHolder> {
    private ArrayList<Pokemon> pokemonArrayList;
    private ArrayList<Trade> tradeArrayList;
    private Context context;

    private CustomItemClickListener listener;

    public SelectRecyclerAdapter(ArrayList<Trade> tradeArrayList, ArrayList<Pokemon> pokemonArrayList, Context context, CustomItemClickListener listener) {
        this.pokemonArrayList = pokemonArrayList;
        this.tradeArrayList = tradeArrayList;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        final View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_item_collection, viewGroup, false);

        final MyHolder myHolder = new MyHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(v, myHolder.getLayoutPosition());
            }
        });

        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.sendPokemonNameTextView.setText(tradeArrayList.get(position).getPokemon_offer_id());
        holder.sendUserNameTextView.setText(tradeArrayList.get(position).getEmail());
        holder.wantPokemonNameTextView.setText(tradeArrayList.get(position).getPokemon_wanted_id());
        setImagePokemonSend(holder, position);
        setImagePokemonWant(holder, position);
    }

    private void setImagePokemonWant(MyHolder holder, int idPokemon) {
        Pokemon pokemonWant = getPokemonById(idPokemon);
        if (pokemonWant != null) {
            Picasso.with(context).load(pokemonWant.getSprite()).into(holder.wantImageView);
        }
    }

    private void setImagePokemonSend(MyHolder holder, int idPokemon) {
        Pokemon pokemonSend = getPokemonById(idPokemon);
        Picasso.with(context).load(pokemonSend.getSprite()).into(holder.sendImageView);
    }

    @Override
    public int getItemCount() {
        return pokemonArrayList.size();
    }

    private Pokemon getPokemonById(int id) {
        for (Pokemon pokemon : pokemonArrayList) {
            if (pokemon.getId() == id) {
                return pokemon;
            }
        }

        return null;
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView  sendPokemonNameTextView;
        TextView  sendUserNameTextView;
        ImageView sendImageView;
        TextView  wantPokemonNameTextView;
        ImageView wantImageView;

        MyHolder(View itemView) {
            super(itemView);
            sendPokemonNameTextView = itemView.findViewById(R.id.trade_select_item_send_id_name);
            sendUserNameTextView = itemView.findViewById(R.id.trade_select_item_send_user_name);
            sendImageView = itemView.findViewById(R.id.trade_select_item_send_image);
            wantPokemonNameTextView = itemView.findViewById(R.id.trade_select_item_want_id_name);
            wantImageView = itemView.findViewById(R.id.trade_select_item_want_image);
        }
    }
}
