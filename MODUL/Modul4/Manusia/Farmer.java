package Manusia;

import Plant.TalkAble;


public class Farmer {
    private  String name;
    private String favorite;
 

    public Farmer(String name){
        this.name = name;
        this.favorite =  "No favorite yet";
    }
    public void Talk(TalkAble TalkAble){
        TalkAble.Talk();
    }


}
