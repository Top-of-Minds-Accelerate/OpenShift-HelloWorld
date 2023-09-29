package com.example.demo.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AreaResponse {

    public AreaResponse(int area) {
        this.area = area;
    }

    @JsonProperty
    int area;

    public int area() {
        return area;
    }
}
