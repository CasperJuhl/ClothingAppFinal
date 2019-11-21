package com.example.clothingapp.Model;

public class Cloth {
    private String mStore;
    private String mWebsite;
    private int mIcon;

    public Cloth(String store, String site, int icon) {
        mStore = store;
        mWebsite = site;
        mIcon = icon;
    }

    public String getSite() {
        return mWebsite;
    }

    public int getIcon() {
        return mIcon;
    }

    public String getStore()
    {
        return mStore;
    }
}
