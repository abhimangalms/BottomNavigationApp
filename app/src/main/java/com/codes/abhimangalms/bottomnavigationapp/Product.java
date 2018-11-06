package com.codes.abhimangalms.bottomnavigationapp;

/** created by Abhimangal on 28/10/2018*/

public class Product {

    private int id;
    private String title;
    private String date;
    private String shortdesc;
    private String imageUrl;


    public Product(int id, String title, String date, String shortdesc, String imageUrl) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.shortdesc = shortdesc;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
