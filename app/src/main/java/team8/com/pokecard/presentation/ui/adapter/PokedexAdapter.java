package team8.com.pokecard.presentation.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.R;

/**
 * Created by Adam on 13/11/2017.
 */

public class PokedexAdapter extends ArrayAdapter<Pokemon> {
    private Context context;

    public PokedexAdapter(Context context, List<Pokemon> pokemonList) {
        super(context, 0, pokemonList);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_list_pokemon, parent, false);
        }

        PokemonItemViewHolder viewHolder = (PokemonItemViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new PokemonItemViewHolder();
            viewHolder.id = convertView.findViewById(R.id.list_pokemon_row_id_pokemon);
            viewHolder.name = convertView.findViewById(R.id.list_pokemon_row_name);
            viewHolder.image = convertView.findViewById(R.id.list_pokemon_image);
            convertView.setTag(viewHolder);
        }

        //Récupération du Pokemon
        Pokemon pokemon = getItem(position);

        //Remplissage de la vue
        if (pokemon != null) {
            Log.d("Adapter", pokemon.toString());
            viewHolder.id.setText(String.valueOf(pokemon.getId()));
            viewHolder.name.setText(pokemon.getName());
            Picasso.with(context).load(pokemon.getSprite()).into(viewHolder.image);
        }

        return convertView;
    }

    private class PokemonItemViewHolder {
        public TextView id;
        public TextView name;
        public ImageView image;
    }
}
