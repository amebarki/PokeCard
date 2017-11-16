package team8.com.pokecard.Service;

import retrofit2.Call;
import team8.com.pokecard.model.Pokemon;

/**
 * Created by iem on 15/11/2017.
 */

public interface PokemonService {

    Call<Pokemon> getPokemon(int id);


}
