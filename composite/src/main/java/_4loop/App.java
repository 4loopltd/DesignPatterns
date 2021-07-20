package _4loop;

import _4loop.composite.DeveloperLeaf;
import _4loop.composite.EmployeeComponent;
import _4loop.composite.ManagerComposite;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        ManagerComposite generalManager = new ManagerComposite("General Manager", "Bill Gates", 3200);
        EmployeeComponent manager = new ManagerComposite("Manager", "Mark Zuckerberg", 2400);
        EmployeeComponent lead = new DeveloperLeaf("Lead Developer", "Ada Lovelace", 2000);
        EmployeeComponent dev1 = new DeveloperLeaf("Developer", "Linus Torvalds", 1400);
        EmployeeComponent dev2 = new DeveloperLeaf("Developer", "Ken Thompson", 1800);

        generalManager.add(manager);
        generalManager.add(lead);
        manager.add(dev1);
        manager.add(dev2);

        generalManager.print();

    }
}