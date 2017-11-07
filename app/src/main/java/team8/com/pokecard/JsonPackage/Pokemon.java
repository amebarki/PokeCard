package team8.com.pokecard.JsonPackage;

/**
 * Created by iem on 07/11/2017.
 */

public class Pokemon {

    private int id;
    private String name;

    public Pokemon(int id, String name){
        this.id = id;
        this.name = name;
    }


    @Override
    public String toString() {
        return "Pokemon [ " +
                "id='" + id + '\'' +
                ", name='" + name + '\'' + "]";

    }


}
