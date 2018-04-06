package ru.golden.weather.model.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Clouds implements Serializable {

    @SerializedName("all")
    public Integer all;
}

