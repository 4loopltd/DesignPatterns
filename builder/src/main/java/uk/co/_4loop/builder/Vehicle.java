package uk.co._4loop.builder;

import uk.co._4loop.builder.parts.BodyColour;
import uk.co._4loop.builder.parts.EngineType;
import uk.co._4loop.builder.parts.Gearbox;
import uk.co._4loop.builder.parts.Wheels;


public final class Vehicle {

    private final String type;
    private Wheels wheels;
    private EngineType engineType;
    private Gearbox gearbox;
    private BodyColour bodyColour;

    public Vehicle(String type) {
        this.type = type;
    }

    public Vehicle(String type, Wheels wheels, EngineType engineType, Gearbox gearbox, BodyColour bodyColour) {
        this.type = type;
        this.wheels = wheels;
        this.engineType = engineType;
        this.gearbox = gearbox;
        this.bodyColour = bodyColour;
    }

    @Override
    public String toString() {
        return "Built a " + bodyColour + " " + type + " with " + wheels + " wheels a " + gearbox + " gearbox and " + engineType + " engine.";
    }
}
