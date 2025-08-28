package _4loop;

import _4loop.mediator.ApplicationMediator;
import _4loop.mediator.colleague.CatColleague;
import _4loop.mediator.colleague.Colleague;
import _4loop.mediator.colleague.DogColleague;
import lombok.extern.slf4j.Slf4j;

/**
 * Mediator Pattern Demonstration Application
 * 
 * The Mediator Pattern defines how a set of objects interact with each other.
 * Instead of objects communicating directly, they communicate through a central
 * mediator object. This pattern promotes loose coupling by preventing objects
 * from referring to each other explicitly, and it lets you vary their interaction
 * independently.
 * 
 * Key Components demonstrated:
 * - Mediator: Interface that defines communication contract (ApplicationMediator interface)
 * - ConcreteMediator: Implements mediator and coordinates communication (ApplicationMediator)
 * - Colleague: Interface for objects that communicate via mediator (Colleague)
 * - ConcreteColleague: Implements colleague and communicates through mediator (CatColleague, DogColleague)
 * 
 * This example demonstrates:
 * - Animals communicating through a central mediator rather than directly
 * - Decoupled communication - colleagues don't know about each other
 * - Centralized communication logic in the mediator
 * - Easy to add new communication participants without changing existing ones
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Mediator Pattern with animal communication.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Mediator Pattern Demonstration ---");
        log.info("Animals communicate through a central mediator instead of directly.\n");

        log.info("--- Setting up Communication Network ---");
        // Central mediator coordinates all communication
        ApplicationMediator mediator = new ApplicationMediator();

        // Colleagues know only about the mediator, not each other
        Colleague cat = new CatColleague(mediator);    // Cat registers with mediator
        Colleague dog = new DogColleague(mediator);    // Dog registers with mediator

        log.info("--- Registering Participants with Mediator ---");
        // Mediator maintains registry of all participants
        mediator.addColleague(cat);                    // Mediator knows about cat
        mediator.addColleague(dog);                    // Mediator knows about dog

        log.info("--- Demonstrating Mediated Communication ---");
        log.info(">> Cat sends message through mediator:");
        // Cat doesn't send directly to dog - sends through mediator
        cat.send("Hello Dog");                         // Mediator routes message to appropriate recipient

        log.info("\n>> Dog responds through mediator:");
        // Dog responds through same mediator - maintains consistent communication pattern
        dog.send("Hello Cat");                         // Mediator handles routing and delivery

        log.info("\n--- Communication Flow Analysis ---");
        log.info("1. Cat calls send() with message");
        log.info("2. Cat's send() calls mediator.send(message, this)");
        log.info("3. Mediator determines appropriate recipient(s)");
        log.info("4. Mediator calls receive() on target colleague(s)");
        log.info("5. Dog receives and processes the message");

        log.info("\n--- Mediator Pattern Benefits Demonstrated ---");
        log.info("1. Colleagues are decoupled - they don't reference each other directly");
        log.info("2. Communication logic is centralized in the mediator");
        log.info("3. Easy to add new participants without changing existing colleagues");
        log.info("4. Complex communication protocols can be handled by mediator");
        log.info("5. Promotes reusability - colleagues can work with different mediators");
        log.info("6. Follows Single Responsibility Principle - mediator handles communication logic");

    }

}