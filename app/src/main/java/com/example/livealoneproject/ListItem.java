package com.example.livealoneproject;

import android.graphics.drawable.Drawable;

public class ListItem {
    public Drawable image;
    public String place;
    public String day;
    public String estate;
    public String Address;
    public int index;

    public ListItem(Drawable image, String place, String day, String estate, String address, int index) {
        this.image = image;
        this.place = place;
        this.day = day;
        this.estate = estate;
        Address = address;
        this.index = index;
    }

    @Override
    public String toString() {
        return "ListItem{" +
                ", image=" + image +
                ", place='" + place + '\'' +
                ", day='" + day + '\'' +
                ", estate='" + estate + '\'' +
                ", Address='" + Address + '\'' +
                ", index='" + Address + '\'' +
                '}';
    }

    public Drawable getImage() {
        return image;
    }
    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getEstate() {
        return estate;
    }

    public void setEstate(String estate) {
        this.estate = estate;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
