package uk.co._4loop.builder;

import uk.co._4loop.builder.parts.BodyColour;
import uk.co._4loop.builder.parts.EngineType;
import uk.co._4loop.builder.parts.Gearbox;
import uk.co._4loop.builder.parts.Wheels;

public class VehicleBuilder {

    private final String type;
    private Wheels wheels;
    private EngineType engineType;
    private Gearbox gearbox;
    private BodyColour bodyColour;

    public VehicleBuilder(String type) {
        this.type = type;
    }

    public VehicleBuilder(String type, Wheels wheels, EngineType engineType, Gearbox gearbox, BodyColour bodyColour) {
        this.type = type;
        this.wheels = wheels;
        this.engineType = engineType;
        this.gearbox = gearbox;
        this.bodyColour = bodyColour;
    }

    public VehicleBuilder setWheels(Wheels wheels) {
        this.wheels = wheels;
        return this;
    }

    public VehicleBuilder setEngineType(EngineType engineType) {
        this.engineType = engineType;
        return this;
    }

    public VehicleBuilder setGearbox(Gearbox gearbox) {
        this.gearbox = gearbox;
        return this;
    }

    public VehicleBuilder setBodyColour(BodyColour bodyColour) {
        this.bodyColour = bodyColour;
        return this;
    }

    public Vehicle build() {
        return new Vehicle(type, wheels, engineType, gearbox, bodyColour);
    }

}
