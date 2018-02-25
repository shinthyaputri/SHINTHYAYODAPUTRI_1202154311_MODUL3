package com.tugas.shinthya.shinthya_1202154311_sc3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class water {
    String title, description, detail;
    int image;

    public water(String title, String description, String detail, int image){
        this.title= title;
        this.description=description;
        this.detail= detail;
        this.image= image;

    }

    public String getTitle() {
        return title;
    }

    public String getDescpription() {
        return description;
    }

    public String getDetail() {
        return detail;
    }

    public int getImage() {
        return image;
    }
}