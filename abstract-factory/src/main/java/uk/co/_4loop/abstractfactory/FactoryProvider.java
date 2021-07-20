package uk.co._4loop.abstractfactory;

import uk.co._4loop.abstractfactory.layout.LayoutFactory;
import uk.co._4loop.abstractfactory.plant.PlantFactory;

public class FactoryProvider {

    public static AbstractFactory<?> getFactory(String choice) {

        if (LayoutFactory.TYPE.equalsIgnoreCase(choice)) {
            return new LayoutFactory();
        } else if (PlantFactory.TYPE.equalsIgnoreCase(choice)) {
            return new PlantFactory();
        }

        return null;
    }
}
