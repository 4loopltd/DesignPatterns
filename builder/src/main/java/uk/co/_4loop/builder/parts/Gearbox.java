package uk.co._4loop.builder.parts;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Gearbox {

    MANUAL("manual"),
    AUTOMATIC("automatic");

    private final String name;

    @Override
    public String toString() {
        return name;
    }
}
