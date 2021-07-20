package uk.co._4loop.abstractfactory.plant;

import uk.co._4loop.abstractfactory.AbstractFactory;

public class PlantFactory implements AbstractFactory<Plant> {

    public static final String TYPE = "Plant";

    @Override
    public Plant create(String plantType) {
        if (Tree.TYPE.equalsIgnoreCase(plantType)) {
            return new Tree();
        } else if (Shrub.TYPE.equalsIgnoreCase(plantType)) {
            return new Shrub();
        } else if (Flower.TYPE.equalsIgnoreCase(plantType)) {
            return new Flower();
        }

        return null;
    }
}
