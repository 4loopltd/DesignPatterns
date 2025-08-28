package _4loop;

import _4loop.visitor.PrintVisitor;
import _4loop.visitor.parts.*;
import lombok.extern.slf4j.Slf4j;

/**
 * Visitor Pattern Demonstration Application
 * 
 * The Visitor Pattern represents an operation to be performed on elements of an
 * object structure. It lets you define a new operation without changing the classes
 * of the elements on which it operates. This pattern is useful when you have a
 * complex object structure and want to perform various operations on it without
 * polluting the classes with operation-specific code.
 * 
 * Key Components demonstrated:
 * - Visitor: Interface that declares visit methods for each ConcreteElement (Visitor)
 * - ConcreteVisitor: Implements operations to be performed on elements (PrintVisitor)
 * - Element: Interface that declares accept method taking Visitor (Part interface)
 * - ConcreteElement: Implements accept method and defines entry point for visitor (Frame, Engine, Body, Wheels)
 * - ObjectStructure: Contains elements and provides interface for visitor access (Car)
 * 
 * This example demonstrates:
 * - Car with different parts that can be visited by operations
 * - Print operation implemented as visitor without modifying part classes
 * - Double dispatch mechanism - runtime type resolution for both visitor and element
 * - Separation of data structure from operations performed on it
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Visitor Pattern with car parts inspection.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Visitor Pattern Demonstration ---");
        log.info("Performing operations on object structures without modifying the structure classes.\n");

        log.info("--- Building Composite Object Structure ---");
        log.info("Creating a car with various parts (Frame, Engine, Body, Wheels):");

        // ObjectStructure - contains elements that can be visited
        Car car = new Car();
        car.add(new Frame());              // ConcreteElement - can accept visitors
        car.add(new Engine());             // Each part implements accept(Visitor)
        car.add(new Body());               // Parts don't know about specific operations
        car.add(new Wheels());             // Operations are defined in visitors

        log.info("✓ Car structure built with parts");

        log.info("\n--- Applying Print Visitor ---");
        log.info(">> Visitor traverses structure and performs print operation on each part:");
        // ConcreteVisitor - implements specific operation (printing)
        // The visitor knows how to handle each type of part differently
        car.accept(new PrintVisitor());    // Double dispatch: car delegates to parts, parts call visitor

        log.info("\n--- Visitor Pattern Double Dispatch Explained ---");
        log.info("1. car.accept(printVisitor) - ObjectStructure accepts visitor");
        log.info("2. For each part: part.accept(printVisitor) - Element accepts visitor");
        log.info("3. part.accept() calls printVisitor.visit(this) - Element calls visitor with itself");
        log.info("4. printVisitor.visit(specificPart) - Visitor performs type-specific operation");
        log.info("5. Runtime determines both visitor type AND element type for correct method dispatch");

        log.info("\n--- Demonstrating Visitor Flexibility ---");
        log.info("Same object structure can be visited by different visitors for different operations:");
        log.info("• PrintVisitor: Displays part information");
        log.info("• CostCalculatorVisitor: Could calculate total cost");
        log.info("• MaintenanceVisitor: Could schedule maintenance");
        log.info("• SerializationVisitor: Could convert to XML/JSON");

        // Could easily add more visitors without changing Car or Part classes:
        // car.accept(new CostCalculatorVisitor());
        // car.accept(new MaintenanceVisitor());

        log.info("\n--- Visitor Pattern Benefits Demonstrated ---");
        log.info("1. Operations separated from data structure - clean separation of concerns");
        log.info("2. Easy to add new operations - create new visitor, no changes to elements");
        log.info("3. Operations can accumulate state during traversal");
        log.info("4. Related operations grouped together in visitor class");
        log.info("5. Double dispatch enables type-specific behavior for both visitor and element");
        log.info("6. Elements don't need to know about all possible operations");

    }

}