package uk.co._4loop;

import lombok.extern.slf4j.Slf4j;
import uk.co._4loop.abstractfactory.FactoryProvider;
import uk.co._4loop.abstractfactory.layout.Layout;
import uk.co._4loop.abstractfactory.plant.Plant;

import java.math.BigDecimal;

/**
 * Abstract Factory Pattern Demonstration Application
 * 
 * The Abstract Factory Pattern provides an interface for creating families of related
 * or dependent objects without specifying their concrete classes. This pattern is useful
 * when you need to create objects that work together and you want to ensure that the
 * family of created objects is consistent.
 * 
 * Key Components demonstrated:
 * - AbstractFactory: Interface for creating abstract product families (AbstractFactory interface)
 * - ConcreteFactory: Implements AbstractFactory to create concrete products (LayoutFactory, PlantFactory)
 * - AbstractProduct: Interface for a type of product object (Layout, Plant)
 * - ConcreteProduct: Implements AbstractProduct interface (RockLayout, RoseLayout, Shrub, Flower, Tree)
 * - FactoryProvider: Provides access to concrete factories (FactoryProvider)
 * 
 * This example demonstrates:
 * - Garden design system where layouts and plants must be compatible
 * - Three different garden types: Rock Garden (shrubs), Rose Garden (flowers), Fruit Garden (trees)
 * - Factory selection at runtime based on garden type
 * - Consistent object families - each garden type uses appropriate layout and plant combinations
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Abstract Factory Pattern with garden design system.
     *
     * @param args command line args
     */
    @SuppressWarnings({"ConstantConditions", "DuplicatedCode"})
    public static void main(String[] args) {

        log.info("--- Abstract Factory Pattern Demonstration ---");
        log.info("Creating different garden types using families of related objects.\n");

        log.info("--- Creating Rock Garden (Shrub-based Design) ---");
        // Abstract Factory Pattern: FactoryProvider returns appropriate factories
        // Each factory creates compatible families of objects
        Layout rockGarden = (Layout) FactoryProvider.getFactory("Layout").create("Rock");
        Plant shrub = (Plant) FactoryProvider.getFactory("Plant").create("Shrub");

        log.info("Rock Garden Specifications:");
        log.info("• Layout - Width: {}, Length: {}", rockGarden.getWidth(), rockGarden.getLength());
        log.info("• Plant - Type: Shrub, Height: {}", shrub.getHeight());

        // Cost calculation for rock garden with 5 shrubs
        BigDecimal rockGardenCost = BigDecimal.ZERO;
        rockGardenCost = rockGardenCost.add(rockGarden.getCost());      // Layout cost
        for (int i = 0; i < 5; i++) {
            rockGardenCost = rockGardenCost.add(shrub.getCost());       // Add 5 shrubs
        }
        log.info("• Total Rock Garden cost (layout + 5 shrubs): ${}", rockGardenCost);

        log.info("\n--- Creating Rose Garden (Flower-based Design) ---");
        // Same factory interface, different concrete implementations
        // Demonstrates family consistency - rose layout paired with flowers
        Layout roseGarden = (Layout) FactoryProvider.getFactory("Layout").create("Rose");
        Plant flower = (Plant) FactoryProvider.getFactory("Plant").create("Flower");

        log.info("Rose Garden Specifications:");
        log.info("• Layout - Width: {}, Length: {}", roseGarden.getWidth(), roseGarden.getLength());
        log.info("• Plant - Type: Flower, Height: {}", flower.getHeight());

        // Cost calculation for rose garden with 50 flowers
        BigDecimal roseGardenCost = BigDecimal.ZERO;
        roseGardenCost = roseGardenCost.add(roseGarden.getCost());      // Layout cost
        for (int i = 0; i < 50; i++) {
            roseGardenCost = roseGardenCost.add(flower.getCost());      // Add 50 flowers
        }
        log.info("• Total Rose Garden cost (layout + 50 flowers): ${}", roseGardenCost);

        log.info("\n--- Creating Fruit Garden (Tree-based Design) ---");
        // Third family of objects - fruit garden layout with trees
        // Demonstrates extensibility of abstract factory system
        Layout fruitGarden = (Layout) FactoryProvider.getFactory("Layout").create("Fruit");
        Plant tree = (Plant) FactoryProvider.getFactory("Plant").create("Tree");

        log.info("Fruit Garden Specifications:");
        log.info("• Layout - Width: {}, Length: {}", fruitGarden.getWidth(), fruitGarden.getLength());
        log.info("• Plant - Type: Tree, Height: {}", tree.getHeight());

        // Cost calculation for fruit garden with 5 trees
        BigDecimal fruitGardenCost = BigDecimal.ZERO;
        fruitGardenCost = fruitGardenCost.add(fruitGarden.getCost());   // Layout cost
        for (int i = 0; i < 5; i++) {
            fruitGardenCost = fruitGardenCost.add(tree.getCost());      // Add 5 trees
        }
        log.info("• Total Fruit Garden cost (layout + 5 trees): ${}", fruitGardenCost);

        log.info("\n--- Abstract Factory Pattern Analysis ---");
        log.info("Factory Selection Process:");
        log.info("1. FactoryProvider.getFactory('Layout') returns LayoutFactory");
        log.info("2. LayoutFactory.create('Rock'/'Rose'/'Fruit') creates appropriate layout");
        log.info("3. FactoryProvider.getFactory('Plant') returns PlantFactory");
        log.info("4. PlantFactory.create('Shrub'/'Flower'/'Tree') creates compatible plant");
        log.info("5. Each garden type uses consistent family of related objects");

        log.info("\n--- Cost Comparison Summary ---");
        log.info("Rock Garden Total: ${}", rockGardenCost);
        log.info("Rose Garden Total: ${}", roseGardenCost);
        log.info("Fruit Garden Total: ${}", fruitGardenCost);

        log.info("\n--- Abstract Factory Pattern Benefits Demonstrated ---");
        log.info("1. Ensures product families are used together (layout + compatible plants)");
        log.info("2. Isolates concrete classes from client code");
        log.info("3. Easy to exchange entire product families");
        log.info("4. Promotes consistency among products in same family");
        log.info("5. Factory selection can be configured at runtime");
        log.info("6. Adding new product families doesn't require changing existing client code");

    }
}
