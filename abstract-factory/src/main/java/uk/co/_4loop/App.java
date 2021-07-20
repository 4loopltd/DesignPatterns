package uk.co._4loop;

import lombok.extern.slf4j.Slf4j;
import uk.co._4loop.abstractfactory.FactoryProvider;
import uk.co._4loop.abstractfactory.layout.Layout;
import uk.co._4loop.abstractfactory.plant.Plant;

import java.math.BigDecimal;

@Slf4j
public class App {

    @SuppressWarnings({"ConstantConditions", "DuplicatedCode"})
    public static void main(String[] args) {

        log.info("Creating Rock Garden");
        Layout rockGarden = (Layout) FactoryProvider.getFactory("Layout").create("Rock");
        Plant shrub = (Plant) FactoryProvider.getFactory("Plant").create("Shrub");
        log.info("Width: " + rockGarden.getWidth());
        log.info("Length: " + rockGarden.getLength());
        log.info("Height: " + shrub.getHeight());
        BigDecimal rockGardenCost = BigDecimal.ZERO;
        rockGardenCost = rockGardenCost.add(rockGarden.getCost());
        for (int i = 0; i < 5; i++) {
            rockGardenCost = rockGardenCost.add(shrub.getCost());
        }
        log.info("Total cost: " + rockGardenCost);


        log.info("Creating Rose Garden");
        Layout roseGarden = (Layout) FactoryProvider.getFactory("Layout").create("Rose");
        Plant flower = (Plant) FactoryProvider.getFactory("Plant").create("Flower");
        log.info("Width: " + roseGarden.getWidth());
        log.info("Length: " + roseGarden.getLength());
        log.info("Height: " + flower.getHeight());
        BigDecimal roseGardenCost = BigDecimal.ZERO;
        roseGardenCost = roseGardenCost.add(roseGarden.getCost());
        for (int i = 0; i < 50; i++) {
            roseGardenCost = roseGardenCost.add(flower.getCost());
        }
        log.info("Total cost: " + roseGardenCost);


        log.info("Creating Fruit Garden");
        Layout fruitGarden = (Layout) FactoryProvider.getFactory("Layout").create("Fruit");
        Plant tree = (Plant) FactoryProvider.getFactory("Plant").create("Tree");
        log.info("Width: " + fruitGarden.getWidth());
        log.info("Length: " + fruitGarden.getLength());
        log.info("Height: " + tree.getHeight());
        BigDecimal fruitGardenCost = BigDecimal.ZERO;
        fruitGardenCost = fruitGardenCost.add(fruitGarden.getCost());
        for (int i = 0; i < 5; i++) {
            fruitGardenCost = fruitGardenCost.add(tree.getCost());
        }
        log.info("Total cost: " + fruitGardenCost);

    }
}
