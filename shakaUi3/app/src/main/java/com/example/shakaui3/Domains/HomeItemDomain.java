package com.example.shakaui3.Domains;


import android.content.Context;

import java.io.Serializable;

public class HomeItemDomain implements Serializable {

    private String activity_title;

    public String getActivity_title() {
        return activity_title;
    }

    public void setActivity_title(String activity_title) {
        this.activity_title = activity_title;
    }

    public String getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(String activity_id) {
        this.activity_id = activity_id;
    }

    private String activity_id;

    public HomeItemDomain(Context context, String activity_id, String activity_title){
        this.activity_id = activity_id;
        this.activity_title= activity_title;
    }


}
