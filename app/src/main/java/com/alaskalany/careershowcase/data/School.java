package com.alaskalany.careershowcase.data;

import android.net.Uri;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.alaskalany.careershowcase.data.Location;
import com.alaskalany.careershowcase.data.Logo;

@Entity
public class School {

    @PrimaryKey
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "website_uri")
    private Uri websiteUri;
    @Embedded
    private Location location;
    @Embedded
    private Logo logo;

    public School() {

    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Uri getWebsiteUri() {

        return websiteUri;
    }

    public void setWebsiteUri(Uri websiteUri) {

        this.websiteUri = websiteUri;
    }

    public Location getLocation() {

        return location;
    }

    public void setLocation(Location location) {

        this.location = location;
    }

    public Logo getLogo() {

        return logo;
    }

    public void setLogo(Logo logo) {

        this.logo = logo;
    }
}