
package com.openweathermap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coord {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("lon")
    @Expose
    private Double lon = -0.13D;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("lat")
    @Expose
    private Double lat = 51.51D;

    /**
     * 
     * (Required)
     * 
     */
    public Double getLon() {
        return lon;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setLon(Double lon) {
        this.lon = lon;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Double getLat() {
        return lat;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

}
