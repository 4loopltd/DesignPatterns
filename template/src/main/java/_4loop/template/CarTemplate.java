package _4loop.template;

import java.util.ArrayList;
import java.util.List;

public abstract class CarTemplate {

    protected final List<String> parts = new ArrayList<>();

    public final Car buildCar() {
        addFrame();
        addEngine();
        addBody();
        addWheels();

        return new Car(parts);
    }

    protected abstract void addFrame();

    protected abstract void addEngine();

    protected abstract void addBody();

    protected abstract void addWheels();

}
