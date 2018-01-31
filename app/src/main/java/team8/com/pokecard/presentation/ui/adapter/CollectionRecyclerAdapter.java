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
                .inflate(R.layout.collection_recycler_item, viewGroup, false);

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
        holder.nameTextView.setText(pokemonArrayList.get(position).getName());
        holder.idTextView.setText(String.valueOf(pokemonArrayList.get(position).getId()));
        Picasso.with(context).load(pokemonArrayList.get(position).getSprite()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return pokemonArrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView  nameTextView;
        TextView idTextView;
        ImageView imageView;

        MyHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.collection_recycle_item_name);
            idTextView = itemView.findViewById(R.id.collection_recycle_item_id);
            imageView = itemView.findViewById(R.id.collection_recycle_item_image);
        }
    }
}
