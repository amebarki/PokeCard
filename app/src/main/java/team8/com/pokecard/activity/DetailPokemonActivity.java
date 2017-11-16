package team8.com.pokecard.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import team8.com.pokecard.R;

public class DetailPokemonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pokemon);

        ImageView imageView = (ImageView) findViewById(R.id.detail_picture_pokemon);
        Picasso.with(getBaseContext()).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/150.png").into(imageView);
    }
}
