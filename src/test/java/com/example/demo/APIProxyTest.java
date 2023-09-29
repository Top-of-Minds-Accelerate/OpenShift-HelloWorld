package com.example.demo;

import com.example.demo.api.MeasureDistanceResponse;
import com.example.demo.api.MoveForwardResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class APIProxyTest {

    @Test
    void shouldParseMoveForwardResponse() throws Exception {

        MoveForwardResponse response = new ObjectMapper().readValue(readFileContents("move-forward-response.json"), MoveForwardResponse.class);
        assertEquals(100, response.distanceMoved());
    }

    @Test
    void shouldParseDistanceResponse() throws Exception {

        MeasureDistanceResponse response = new ObjectMapper().readValue(readFileContents("measure-distance-response.json"), MeasureDistanceResponse.class);
        assertEquals(100, response.distance());
    }

    private String readFileContents(String fileLocation) throws IOException, URISyntaxException {
        Path path = Paths.get(Thread.currentThread().getContextClassLoader().getResource(fileLocation).toURI());
        return Files.readString(path);
    }

}