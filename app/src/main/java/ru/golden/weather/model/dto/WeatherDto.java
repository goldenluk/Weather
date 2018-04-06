package ru.golden.weather.model.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WeatherDto implements Serializable {

    @SerializedName("coord")
    public Coord coord;

    @SerializedName("weather")
    public List<Weather> weather = null;

    @SerializedName("base")
    public String base;

    @SerializedName("main")
    public Main main;

    @SerializedName("visibility")
    public Integer visibility;

    @SerializedName("wind")
    public Wind wind;

    @SerializedName("clouds")
    public Clouds clouds;

    @SerializedName("dt")
    public Integer dt;

    @SerializedName("sys")
    public Sys sys;

    @SerializedName("id")
    public Integer id;

    @SerializedName("name")
    public String name;

    @SerializedName("cod")
    public Integer cod;
}
