package uk.co._4loop.builder.parts;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum EngineType {

    PETROL("petrol"),
    DIESEL("diesel"),
    ELECTRIC("electric");

    private final String name;

    @Override
    public String toString() {
        return name;
    }

}
