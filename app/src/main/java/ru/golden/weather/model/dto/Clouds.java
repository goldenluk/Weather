package ru.golden.weather.model.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Clouds implements Serializable {

    @SerializedName("all")
    private Integer all;
}

