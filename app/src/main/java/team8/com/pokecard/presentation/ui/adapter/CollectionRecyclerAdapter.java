package team8.com.pokecard.presentation.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import team8.com.pokecard.R;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.ui.activity.WantActivity;
import team8.com.pokecard.tools.CustomItemClickListener;

/**
 * Created by iem on 06/12/2017.
 */

public class CollectionRecyclerAdapter extends RecyclerView.Adapter<CollectionRecyclerAdapter.MyHolder> {
    private ArrayList<Pokemon> pokemonArrayList;
    private Context context;

    private CustomItemClickListener listener;

    public CollectionRecyclerAdapter(ArrayList<Pokemon> pokemonArrayListList, Context context, CustomItemClickListener listener) {
        this.pokemonArrayList = pokemonArrayListList;
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
    public void onBindViewHolder(MyHolder holder, final int position) {
        holder.nameTextView.setText(pokemonArrayList.get(position).getName());
        Picasso.with(context).load(pokemonArrayList.get(position).getSprite()).into(holder.imageView);
        holder.tradeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, WantActivity.class);

                intent.putExtra("idTradePokemon", pokemonArrayList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemonArrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView  nameTextView;
        ImageView imageView;
        Button tradeButton;

        MyHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.collection_pokemon_name);
            imageView = itemView.findViewById(R.id.collection_pokemon_image);
            tradeButton = itemView.findViewById(R.id.collection_pokemon_button_trade);
        }
    }
}
