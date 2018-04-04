package team8.com.pokecard.data.model;

/**
 * Created by Adam on 09/03/2018.
 */

public class Trade {

    private String email;
    private int pokemon_offer_id;
    private int pokemon_wanted_id;
    private int offer_accepted;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPokemon_offer_id() {
        return pokemon_offer_id;
    }

    public void setPokemon_offer_id(int pokemon_offer_id) {
        this.pokemon_offer_id = pokemon_offer_id;
    }

    public int getPokemon_wanted_id() {
        return pokemon_wanted_id;
    }

    public void setPokemon_wanted_id(int pokemon_wanted_id) {
        this.pokemon_wanted_id = pokemon_wanted_id;
    }

    public int getOffer_accepted() {
        return offer_accepted;
    }

    public void setOffer_accepted(int offer_accepted) {
        this.offer_accepted = offer_accepted;
    }
}
