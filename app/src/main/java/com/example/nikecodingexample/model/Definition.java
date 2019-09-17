package com.example.nikecodingexample.model;

import android.graphics.drawable.Drawable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Definition {

    @SerializedName("definition")
    @Expose
    private String definition;

    @SerializedName("defid")
    @Expose
    private String defid;

    @SerializedName("thumbs_up")
    @Expose
    private String thumbs_up;

    @SerializedName("thumbs_down")
    @Expose
    private String thumbs_down;

    @SerializedName("permalink")
    @Expose
    private String permalink;

    public Definition() {
    }

    public Definition(String definition, String defid, String thumbs_up, String thumbs_down, String permalink) {
        this.definition = definition;
        this.defid = defid;
        this.thumbs_up = thumbs_up;
        this.thumbs_down = thumbs_down;
        this.permalink = permalink;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getDefid() {
        return defid;
    }

    public void setDefid(String defid) {
        this.defid = defid;
    }

    public String getThumbs_up() {
        return thumbs_up;
    }

    public void setThumbs_up(String thumbs_up) {
        this.thumbs_up = thumbs_up;
    }

    public String getThumbs_down() {
        return thumbs_down;
    }

    public void setThumbs_down(String thumbs_down) {
        this.thumbs_down = thumbs_down;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }
}
