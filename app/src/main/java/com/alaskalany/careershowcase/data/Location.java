package com.alaskalany.careershowcase.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity
public class Location {

    @ColumnInfo(name = "label")
    private String label;
    @ColumnInfo(name = "city")
    private String city;
    @ColumnInfo(name = "country")
    private String country;

    public Location() {

    }

    public String getLabel() {

        return label;
    }

    public void setLabel(String label) {

        this.label = label;
    }

    public String getCity() {

        return city;
    }

    public void setCity(String city) {

        this.city = city;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }
}