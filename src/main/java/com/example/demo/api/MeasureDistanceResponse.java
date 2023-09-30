package com.example.demo.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeasureDistanceResponse {

    public MeasureDistanceResponse() {
    }

    public MeasureDistanceResponse(int distance) {
        this.distance = distance;
    }

    @JsonProperty
    int distance;

    public int distance() {
        return distance;
    }
}
