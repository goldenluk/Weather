package ru.golden.weather.model.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Main implements Serializable {

    @SerializedName("temp")
    public Float temp;

    @SerializedName("pressure")
    public Integer pressure;

    @SerializedName("humidity")
    public Integer humidity;

    @SerializedName("temp_min")
    public Float tempMin;

    @SerializedName("temp_max")
    public Float tempMax;
}
