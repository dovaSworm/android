package com.example.danij.retrofitjson.model;

import android.widget.ArrayAdapter;

import com.example.danij.retrofitjson.model.children.Children;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Data {

    @SerializedName("modhash")
    @Expose
    private String modhash;
    @SerializedName("children")
    @Expose
    private ArrayList<Children> children = new ArrayList<>();

    @Override
    public String toString() {
        return "Data{" +
                "modhash='" + modhash + '\'' +
                ", children=" + children +
                '}';
    }

    public String getModhash() {
        return modhash;
    }

    public void setModhash(String modhash) {
        this.modhash = modhash;
    }

    public ArrayList<Children> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Children> children) {
        this.children = children;
    }
}
