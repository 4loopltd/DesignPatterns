package uk.co._4loop.builder.parts;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BodyColour {

    RED("red"),
    GREEN("green"),
    BLUE("blue"),
    YELLOW("yellow");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
