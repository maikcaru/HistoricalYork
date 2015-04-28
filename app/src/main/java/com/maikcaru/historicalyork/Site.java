package com.maikcaru.historicalyork;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

/**
 * Created by Mikey on 21/02/2015.
 */
public class Site implements Serializable{

    private String name;
    private LatLng latlng;
    private String info;
    private String imageLocation;


    public Site(){}


    public Site (String name, LatLng latlng, String info){

        this.name = name;
        this.latlng = latlng;
        this.info = info;
    }

    public String getName(){
        return this.name;
    }
    public LatLng getLatLng(){
        return this.latlng;
    }
    public String getInfo(){
        return this.info;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setLatLng(LatLng latlng){
         this.latlng = latlng;
    }
    public void setInfo(String info){  this.info = info; }
    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public String getImageLocation() {
        return imageLocation;
    }
}
