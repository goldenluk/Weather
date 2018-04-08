package ru.golden.weather.model.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Wind implements Serializable {

    @SerializedName("speed")
    private Float speed;

    @SerializedName("deg")
    private Float deg;
}
