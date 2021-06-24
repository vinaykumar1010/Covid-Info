package com.vinay.resourcesc_19;

import java.io.Serializable;

public class HelthTips implements Serializable {
    private final String name;
    private final String link;

    public HelthTips(String name, String link){
        this.name = name;
        this.link = link;
    }

    public String getName1(){return  name;}
    public  String getLink1(){return link;}
}
