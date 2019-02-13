
package com.openweathermap;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OpenWeatherMap {

    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("coord")
    @Expose
    private Coord coord;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("base")
    @Expose
    private String base = "cmc stations";
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("main")
    @Expose
    private Main main;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("wind")
    @Expose
    private Wind wind;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("dt")
    @Expose
    private Integer dt = 1449303600;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("sys")
    @Expose
    private Sys sys;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("id")
    @Expose
    private Integer id = 2643743;
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("name")
    @Expose
    private String name = "London";
    /**
     * 
     * (Required)
     * 
     */
    @SerializedName("cod")
    @Expose
    private Integer cod = 200;

    /**
     * 
     * (Required)
     * 
     */
    public Coord getCoord() {
        return coord;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    /**
     * 
     * (Required)
     * 
     */
    public List<Weather> getWeather() {
        return weather;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getBase() {
        return base;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setBase(String base) {
        this.base = base;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Main getMain() {
        return main;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Wind getWind() {
        return wind;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Clouds getClouds() {
        return clouds;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Integer getDt() {
        return dt;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Sys getSys() {
        return sys;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setSys(Sys sys) {
        this.sys = sys;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * (Required)
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * (Required)
     * 
     */
    public Integer getCod() {
        return cod;
    }

    /**
     * 
     * (Required)
     * 
     */
    public void setCod(Integer cod) {
        this.cod = cod;
    }

}
