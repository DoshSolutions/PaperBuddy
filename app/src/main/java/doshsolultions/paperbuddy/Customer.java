package doshsolultions.paperbuddy;


/**
 * Created by Dosh for ITC303 project.
 */

import android.net.Uri;


public class Customer {
    private String address;
    private String courier;
    private String australian;
    private String finreview;
    private String sydneyHerald;


    public String getAddress() {
        return address;
    }

    public void setAddress(String input) {
        this.address = input;
    }


    public String getCourier() {
        return courier;
    }

    public void setCourier(String input) {
        this.courier = input;
    }

    public String getAustralian() {
        return australian;
    }

    public void setAustralian(String input) {
        this.australian = input;
    }

    public String getFinreview() {
        return finreview;
    }

    public void setFinreview(String input) {
        this.finreview = input;
    }

    public String getSydneyHerald() {
        return sydneyHerald;
    }

    public void setSydneyHerald(String input) {
        this.sydneyHerald = input;
    }
}
