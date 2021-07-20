package uk.co._4loop.builder.parts;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Wheels {

    TWO("two"),
    THREE("three"),
    FOUR("four");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
