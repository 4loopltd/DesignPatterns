package _4loop;

import _4loop.composite.DeveloperLeaf;
import _4loop.composite.EmployeeComponent;
import _4loop.composite.ManagerComposite;
import lombok.extern.slf4j.Slf4j;

/**
 * Composite Pattern Demonstration Application
 * 
 * The Composite Pattern composes objects into tree structures to represent part-whole
 * hierarchies. This pattern lets clients treat individual objects and compositions
 * of objects uniformly. It's useful when you need to work with tree-like structures
 * and want to treat leaf nodes and branches consistently.
 * 
 * Key Components demonstrated:
 * - Component: Interface/abstract class for all objects in composition (EmployeeComponent)
 * - Leaf: Represents leaf objects with no children (DeveloperLeaf)  
 * - Composite: Stores child components and implements child-related operations (ManagerComposite)
 * - Client: Manipulates objects through Component interface (App)
 * 
 * This example demonstrates:
 * - Organizational hierarchy where managers can contain other managers or developers
 * - Uniform treatment of individual employees and groups of employees
 * - Tree traversal where operations cascade through the hierarchy
 * - Part-whole relationships in corporate structure
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Composite Pattern with organizational hierarchy.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Composite Pattern Demonstration ---");
        log.info("Building an organizational hierarchy where managers (composites) contain employees (leaves/composites).\n");

        log.info("--- Creating Individual Employees (Leaf Components) ---");
        // Leaf nodes - cannot contain other employees
        EmployeeComponent lead = new DeveloperLeaf("Lead Developer", "Ada Lovelace", 2000);
        EmployeeComponent dev1 = new DeveloperLeaf("Developer", "Linus Torvalds", 1400);
        EmployeeComponent dev2 = new DeveloperLeaf("Developer", "Ken Thompson", 1800);

        log.info("--- Creating Managers (Composite Components) ---");
        // Composite nodes - can contain other employees (both leaves and composites)
        ManagerComposite generalManager = new ManagerComposite("General Manager", "Bill Gates", 3200);
        EmployeeComponent manager = new ManagerComposite("Manager", "Mark Zuckerberg", 2400);

        log.info("--- Building Organizational Tree Structure ---");
        // Building the hierarchy - demonstrating part-whole relationships
        generalManager.add(manager);     // General Manager manages a Manager (composite contains composite)
        generalManager.add(lead);        // General Manager also directly manages Lead Developer (composite contains leaf)

        // Manager has direct reports - showing nested structure
        manager.add(dev1);               // Manager manages Developer 1 (composite contains leaf)
        manager.add(dev2);               // Manager manages Developer 2 (composite contains leaf)

        log.info("--- Tree Structure Built ---");
        log.info("General Manager");
        log.info("├── Manager");
        log.info("│   ├── Developer (Linus)");
        log.info("│   └── Developer (Ken)");
        log.info("└── Lead Developer (Ada)");


        log.info("--- Demonstrating Uniform Treatment ---");
        log.info("Calling print() on root - operation cascades through entire hierarchy:");
        // The same operation works on both individual employees and groups
        // The client doesn't need to know whether it's dealing with a leaf or composite
        generalManager.print();          // Recursive operation through tree structure

        log.info("\n--- Composite Pattern Benefits Demonstrated ---");
        log.info("1. Uniform treatment of individual objects and compositions");
        log.info("2. Tree structures can be built and traversed easily");
        log.info("3. Client code is simplified - no distinction between leaf and composite");
        log.info("4. Easy to add new component types without changing existing code");
        log.info("5. Operations can be applied to entire hierarchies recursively");

    }
}