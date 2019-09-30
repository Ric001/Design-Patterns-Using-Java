package com.mycompany.models;

import java.io.Serializable;

public class Recipe implements Serializable {

    private String url;
    private String mealName;

    public Recipe(String url, String mealName) {
        this.url = url;
        this.mealName = mealName;
    }

    public Recipe() { }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String toString() {
        return "Recipe [mealName=" + mealName + ", url=" + url + "]";
    }
}