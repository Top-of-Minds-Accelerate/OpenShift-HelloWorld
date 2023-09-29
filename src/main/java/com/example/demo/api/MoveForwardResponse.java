package com.example.demo.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoveForwardResponse {

    @JsonProperty
    int distanceMoved;

    public int distanceMoved() {
        return distanceMoved;
    }
}
