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
    @SerializedName("description")
    private String description;
    @SerializedName("type1")
    private int type1;
    @SerializedName("type2")
    private int type2;


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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType1() {
        return type1;
    }

    public void setType1(int type1) {
        this.type1 = type1;
    }

    public int getType2() {
        return type2;
    }

    public void setType2(int type2) {
        this.type2 = type2;
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
