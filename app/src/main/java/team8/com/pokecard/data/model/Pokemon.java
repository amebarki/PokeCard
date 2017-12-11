package team8.com.pokecard.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by iem on 07/11/2017.
 */

public class Pokemon {



    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("sprite")
    private String sprite;


    public Pokemon(int id, String name,String sprite){
        this.id = id;
        this.name = name;
        this.sprite = sprite;
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


    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sprite='" + sprite + '\'' +
                '}';
    }
}
