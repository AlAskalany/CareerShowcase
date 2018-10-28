package com.alaskalany.careershowcase.data;

import android.graphics.Bitmap;
import android.net.Uri;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity
public class Logo {

    @Ignore
    private Bitmap bitmap;
    @ColumnInfo(name = "logo_url")
    private Uri logoUri;

    public Logo() {

    }

    public Bitmap getBitmap() {

        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {

        this.bitmap = bitmap;
    }

    public Uri getLogoUri() {

        return logoUri;
    }

    public void setLogoUri(Uri logoUri) {

        this.logoUri = logoUri;
    }
}