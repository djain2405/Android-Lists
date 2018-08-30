package com.example.divya.simplelistview.model;

import android.graphics.drawable.Drawable;

public class AppObj {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    private String name;
    private Drawable icon;

}
