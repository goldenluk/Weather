package ru.golden.weather.model.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Sys implements Serializable {

    @SerializedName("type")
    public Integer type;

    @SerializedName("id")
    public Integer id;

    @SerializedName("message")
    public Float message;

    @SerializedName("country")
    public String country;

    @SerializedName("sunrise")
    public Integer sunrise;

    @SerializedName("sunset")
    public Integer sunset;
}
