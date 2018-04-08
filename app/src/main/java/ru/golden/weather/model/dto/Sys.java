package ru.golden.weather.model.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sys implements Serializable {

    @SerializedName("type")
    private Integer type;

    @SerializedName("id")
    private Integer id;

    @SerializedName("message")
    private Float message;

    @SerializedName("country")
    private String country;

    @SerializedName("sunrise")
    private Integer sunrise;

    @SerializedName("sunset")
    private Integer sunset;
}
