package _4loop.template;

import java.util.List;

public class Car {

    final List<String> parts;

    public Car(List<String> parts) {
        this.parts = parts;
    }

    public List<String> getCarParts() {
        return parts;
    }
}
