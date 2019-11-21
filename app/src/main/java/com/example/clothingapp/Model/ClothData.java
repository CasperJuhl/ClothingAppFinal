package com.example.clothingapp.Model;

public class ClothData {
    private String brand;
    private String name;
    private String website;
    private String itemcode;

    public ClothData(String brand, String name, String website, String itemcode) {
        this.brand = brand;
        this.name = name;
        this.website = website;
        this.itemcode = itemcode;
    }

    public ClothData()
    {
    }

    public String getBrand()
    {
        return brand;
    }

    public String getName()
    {
        return name;
    }

    public String getSite()
    {
        return website;
    }

    public String getItemcode()
    {
        return itemcode;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSite(String website)
    {
        this.website = website;
    }

    public void setItemcode(String itemcode)
    {
        this.itemcode = itemcode;
    }
}
