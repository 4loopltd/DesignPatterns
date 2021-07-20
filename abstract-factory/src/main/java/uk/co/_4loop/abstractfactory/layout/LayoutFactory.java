package uk.co._4loop.abstractfactory.layout;

import uk.co._4loop.abstractfactory.AbstractFactory;

public class LayoutFactory implements AbstractFactory<Layout> {

    public static final String TYPE = "Layout";

    @Override
    public Layout create(String gardenType) {
        if (Fruit.TYPE.equalsIgnoreCase(gardenType)) {
            return new Fruit();
        } else if (Rock.TYPE.equalsIgnoreCase(gardenType)) {
            return new Rock();
        } else if (Rose.TYPE.equalsIgnoreCase(gardenType)) {
            return new Rose();
        }

        return null;
    }
}
