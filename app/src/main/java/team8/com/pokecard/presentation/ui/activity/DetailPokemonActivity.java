package team8.com.pokecard.presentation.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import team8.com.pokecard.PokemonApplication;
import team8.com.pokecard.R;
import team8.com.pokecard.data.manager.Navigator;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.presentation.presenter.CollectionPresenter;
import team8.com.pokecard.presentation.presenter.DetailPresenter;
import team8.com.pokecard.presentation.ui.view.DetailView;

public class DetailPokemonActivity extends AppCompatActivity implements DetailView {

    Pokemon pokemon;
    DetailPresenter presenter;
    ImageView imageView;
    TextView nameTextView;
    TextView idTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pokemon);

        presenter = Navigator.getInstance().getDetailPresenter(this,this);

        setIdView();
        setNameView();
        setImageView();
    }

    private void setImageView() {
        imageView = findViewById(R.id.detail_image);
        Picasso.with(this).load(pokemon.getSprite()).into(imageView);
    }

    public void setIdView() {
        idTextView = findViewById(R.id.detail_text_id);
        idTextView.setText(String.valueOf(pokemon.getId()));
    }

    private void setNameView() {
        nameTextView = findViewById(R.id.detail_text_name);
        nameTextView.setText(pokemon.getName());
    }

    @Override
    public void DisplayErrorMessage() {

    }

    @Override
    public void DisplayInformationMessage() {

    }
}
