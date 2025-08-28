package _4loop;

import _4loop.prototype.Animal;
import _4loop.prototype.Mineral;
import _4loop.prototype.Prototype;
import _4loop.prototype.Vegetable;
import lombok.extern.slf4j.Slf4j;

/**
 * Prototype Pattern Demonstration Application
 * 
 * The Prototype Pattern creates objects by cloning existing instances rather than
 * creating new instances from scratch. This pattern is useful when object creation
 * is expensive, when you want to avoid subclassing, or when you need to create
 * objects at runtime whose types are determined dynamically.
 * 
 * Key Components demonstrated:
 * - Prototype: Interface that declares cloning method (Prototype)
 * - ConcretePrototype: Implements cloning operation (Animal, Vegetable, Mineral)
 * - Client: Creates new objects by asking prototype to clone itself (App)
 * 
 * This example demonstrates:
 * - Object creation through cloning rather than constructors
 * - Different types of objects all supporting the same cloning interface
 * - Independence of cloned objects (different hash codes = different instances)
 * - Polymorphic object creation without knowing concrete types
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Prototype Pattern with object cloning.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Prototype Pattern Demonstration ---");
        log.info("Creating objects by cloning existing prototypes instead of using constructors.\n");

        log.info("--- Creating and Cloning Animal Prototype ---");
        // Create original prototype instance
        Prototype cat = new Animal("Puss");
        log.info("Original Animal: {} : hashCode={}", cat, cat.hashCode());

        // Clone the prototype to create new instance
        Prototype cat2 = cat.duplicate();             // Cloning instead of new Animal()
        log.info("Cloned Animal: {} : hashCode={}", cat2, cat2.hashCode());
        log.info("✓ Different hash codes confirm separate instances");

        log.info("\n--- Creating and Cloning Vegetable Prototype ---");
        Prototype carrot = new Vegetable("carrot");
        log.info("Original Vegetable: {} : hashCode={}", carrot, carrot.hashCode());

        Prototype carrot2 = carrot.duplicate();       // Same cloning interface, different type
        log.info("Cloned Vegetable: {} : hashCode={}", carrot2, carrot2.hashCode());
        log.info("✓ Vegetable cloning works identically to Animal cloning");

        log.info("\n--- Creating and Cloning Mineral Prototype ---");
        Prototype quartz = new Mineral("quartz");
        log.info("Original Mineral: {} : hashCode={}", quartz, quartz.hashCode());

        Prototype quartz2 = quartz.duplicate();       // Uniform cloning interface for all types
        log.info("Cloned Mineral: {} : hashCode={}", quartz2, quartz2.hashCode());

        log.info("\n--- Demonstrating Polymorphic Cloning ---");
        log.info("Client can clone any prototype without knowing its concrete type:");

        Prototype[] prototypes = {cat, carrot, quartz};
        for (int i = 0; i < prototypes.length; i++) {
            Prototype original = prototypes[i];
            Prototype clone = original.duplicate();    // Polymorphic cloning
            log.info("Prototype {}: {} -> Cloned to: {}", 
                     i+1, original.getClass().getSimpleName(), clone.getClass().getSimpleName());
        }

        log.info("\n--- Prototype vs Constructor Creation ---");
        log.info("Traditional: new Animal('name') - requires knowing concrete class");
        log.info("Prototype: existingAnimal.duplicate() - works with any prototype type");

        log.info("\n--- Prototype Pattern Benefits Demonstrated ---");
        log.info("1. Avoids expensive object creation by cloning existing instances");
        log.info("2. Creates objects without knowing their concrete classes");
        log.info("3. Uniform creation interface for different object types");
        log.info("4. Can create objects at runtime based on dynamic prototypes");
        log.info("5. Reduces need for complex factory hierarchies");
        log.info("6. Each clone is independent - modifications don't affect original");

    }

}