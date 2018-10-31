package com.codes.abhimangalms.bottomnavigationapp;

/** created by Abhimangal on 28/10/2018*/

public class Product {

    private int id;
    private int image; //images in the drawable folder has a unique id ie, int type
    private String title;
    private String shortdesc;

    private String price;

    public Product(int id, String title, String shortdesc, String price, int image) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.shortdesc = shortdesc;

        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public String getPrice() {
        return price;
    }
}
