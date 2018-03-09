package team8.com.pokecard.data.manager;

import android.util.Log;

import com.google.firebase.auth.FirebaseUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import team8.com.pokecard.PokemonApplication;
import team8.com.pokecard.data.model.Pokemon;
import team8.com.pokecard.data.model.User;
import team8.com.pokecard.presentation.presenter.BasePresenter;
import team8.com.pokecard.presentation.presenter.LoginPresenter;

/**
 * Created by Adam on 31/01/2018.
 */

public class UserManager {

    private User currentUser;

    public UserManager() {

    }

    public void createUser(FirebaseUser user,LoginPresenter presenter) {
        if (user != null) {
            this.currentUser = new User(user.getDisplayName(),user.getEmail());
        }else
        {
            presenter.errorMessage("");
        }
    }

    public User getCurrentUser(){
        return currentUser;
    }


    public void userExist(final LoginPresenter presenter)
    {
        Call<User> call = PokemonApplication.getPokemonApiService().getUser(currentUser.getEmail());
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()) {
                    // user exist get his pokemon and launch home
                    getUserPokemonsList(presenter);
                }
                else{
                    // user doesn't exist create in the db and launch BoosterPack
                    Log.d("TAGO","Insert New User");
                    insertNewUser(presenter);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
    }

    public void getUserPokemonsList(final LoginPresenter presenter)
    {
        Call<List<Pokemon>> call = PokemonApplication.getPokemonApiService().getUserListPokemon(currentUser.getEmail());
        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                currentUser.setMyPokemons(response.body());
                for (int i = 0; i < currentUser.getMyPokemons().size(); i++) {
                    Log.d("TAGO",currentUser.getMyPokemons().get(i).toString());
                }
                presenter.launchHomeActivity();
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                presenter.errorMessage("");
            }
        });
    }

    public void insertNewUser(final LoginPresenter presenter)
    {
        Call<String> call = PokemonApplication.getPokemonApiService().createUser(currentUser.getName(),currentUser.getEmail());
        //Call<Integer> call = PokemonApplication.getPokemonApiService().createUser(currentUser.getName(),currentUser.getEmail());
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("TAGO","SUCCESS");
                presenter.launchBoosterPackActivity();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("TAGO","FAILURE");
                presenter.errorMessage("");
            }
        });
    }


    public void getPokemonsFromBoosterPack(final BasePresenter presenter)
    {
        Call<List<Pokemon>> call = PokemonApplication.getPokemonApiService().getBoosterPack(currentUser.getEmail());
        call.enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                currentUser.setMyPokemons(response.body());
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable t) {
                presenter.errorMessage("");
            }
        });
    }


    public void insertExchangeOffer(final BasePresenter presenter,int idPokemonOffer, int idPokemonWanted)
    {
        Pokemon poke = new Pokemon(151, "Mewtwo", "sprite");
        Call call = PokemonApplication.getPokemonApiService().offerPokemon(currentUser.getEmail(),idPokemonOffer,idPokemonWanted);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                //info message
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                presenter.errorMessage("");
            }
        });

    }


}
