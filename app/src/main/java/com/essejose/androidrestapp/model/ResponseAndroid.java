package com.essejose.androidrestapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by essejose on 21/06/2017.
 */


public class ResponseAndroid {

    @SerializedName("android")
    private List<Android> androids;

    public List<Android> getAndroids() {
        return androids;
    }

    public void setAndroids(List<Android> androids) {
        this.androids = androids;
    }



}
