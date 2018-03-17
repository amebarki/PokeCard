package team8.com.pokecard.data.model;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iem on 15/11/2017.
 */

public class User {


    private int userId;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    private ArrayList<Pokemon> myPokemons;


    public User(String name, String email) {
        this.name = name;
        this.email = email;
        myPokemons = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ArrayList<Pokemon> getMyPokemons() {
        return myPokemons;
    }

    public void setMyPokemons(List<Pokemon> myPokemons) {
        this.myPokemons.addAll(myPokemons);
    }
}
