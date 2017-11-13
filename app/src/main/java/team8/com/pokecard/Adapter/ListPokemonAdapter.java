package team8.com.pokecard.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import team8.com.pokecard.JsonPackage.Pokemon;
import team8.com.pokecard.R;

/**
 * Created by Adam on 13/11/2017.
 */

public class ListPokemonAdapter extends ArrayAdapter<Pokemon> {
    //tweets est la liste des models à afficher
    private Context context;

    public ListPokemonAdapter(Context context, List<Pokemon> pokemons) {
        super(context, 0, pokemons);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.row_list_pokemon, parent, false);
        }

        TweetViewHolder viewHolder = (TweetViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new TweetViewHolder();
            viewHolder.id = (TextView) convertView.findViewById(R.id.list_pokemon_row_id_pokemon);
            viewHolder.id = (TextView) convertView.findViewById(R.id.list_pokemon_row_name);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Pokemon poke = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.id.setText(poke.getId()+"");
        viewHolder.name.setText(poke.getName());
        return convertView;
    }

    private class TweetViewHolder {
        public TextView id;
        public TextView name;
    }
}
