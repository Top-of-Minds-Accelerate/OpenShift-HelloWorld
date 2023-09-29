package com.example.demo.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeasureDistanceResponse {

    @JsonProperty
    int distance;

    public int distance() {
        return distance;
    }
}
