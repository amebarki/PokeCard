package team8.com.pokecard.presentation.ui.activity;

import android.content.DialogInterface;
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

        int position = -1;
        if(getIntent().getExtras() != null) {
            position = getIntent().getExtras().getInt("position");
        }
        // TODO: 09/03/2018   if position is the id of the pokemon selected -> you can delete it
        // TODO: 09/03/2018   the id is keep by the manager itself
        if(position > -1) {
            //presenter.requestCurrentPokemon(position + 1);
            // TODO: 09/03/2018 replace by this function
            // TODO: 09/03/2018  presenter.requestPokemonSelected();
        } else {
            final android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(this);
            alertDialogBuilder.setPositiveButton("Ok",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });

            alertDialogBuilder.setMessage("Erreur");
            alertDialogBuilder.show();
        }

    }

    private void setImageView() {
        imageView = findViewById(R.id.detail_pokemon_image);
        Picasso.with(this).load(pokemon.getSprite()).into(imageView);
    }

    public void setIdView() {
        idTextView = findViewById(R.id.detail_pokemon_id);
        idTextView.setText(String.valueOf(pokemon.getId()));
    }

    private void setNameView() {
        nameTextView = findViewById(R.id.detail_pokemon_name);
        nameTextView.setText(pokemon.getName());
    }



    public void DisplayPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;

        setIdView();
        setNameView();
        setImageView();
    }

    @Override
    public void displayErrorMessage() {

    }

    @Override
    public void displayInformationMessage() {

    }
}
