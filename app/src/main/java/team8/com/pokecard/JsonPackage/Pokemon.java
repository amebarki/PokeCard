package team8.com.pokecard.JsonPackage;

import com.google.gson.annotations.SerializedName;

/**
 * Created by iem on 07/11/2017.
 */

public class Pokemon {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public Pokemon(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pokemon [ " +
                "id='" + id + '\'' +
                ", name='" + name + '\'' + "]";

    }


}