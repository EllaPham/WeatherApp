
package com.openweathermap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("type")
    @Expose
    private Integer type = 1;
    @SerializedName("id")
    @Expose
    private Integer id = 5093;
    @SerializedName("message")
    @Expose
    private Double message = 0.0081D;
    @SerializedName("country")
    @Expose
    private String country = "GB";
    @SerializedName("sunrise")
    @Expose
    private Integer sunrise = 1449301749;
    @SerializedName("sunset")
    @Expose
    private Integer sunset = 1449330774;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    public Integer getSunset() {
        return sunset;
    }

    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }

}
