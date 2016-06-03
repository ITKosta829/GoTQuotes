package com.example.deanc.gotquotes;

/**
 * Created by ezraerani on 6/3/16.
 */
public class Quote {

    private String sayer, said;
    private int imageResource;

    public Quote(String sayer, String said) {
        this.sayer = sayer;
        this.said = said;
    }

    public String getSayer() {
        return sayer;
    }

    public void setSayer(String sayer) {
        this.sayer = sayer;
    }

    public String getSaid() {
        return said;
    }

    public void setSaid(String said) {
        this.said = said;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
