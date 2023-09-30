package com.example.demo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AreaModelTest {



    @ParameterizedTest
    @MethodSource("measureData")
    void shouldCalculateCorrectArea(int width, int midHeight, int totalHeight, int expected) {
        AreaModel model = new AreaModel(width, midHeight, totalHeight);
        assertEquals(expected, model.getArea());
    }


    private static Stream<Arguments> measureData() {
        return Stream.of(
                Arguments.of(10, 20, 30, 500)
        );
    }
}