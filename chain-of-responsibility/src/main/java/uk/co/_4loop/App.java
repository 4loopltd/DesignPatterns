package uk.co._4loop;

import lombok.extern.slf4j.Slf4j;
import uk.co._4loop.chainofresponsibility.handler.*;
import uk.co._4loop.chainofresponsibility.request.GoRequest;
import uk.co._4loop.chainofresponsibility.request.LeftRequest;
import uk.co._4loop.chainofresponsibility.request.RightRequest;
import uk.co._4loop.chainofresponsibility.request.StopRequest;

/**
 * Chain of Responsibility Pattern Demonstration Application
 * 
 * The Chain of Responsibility Pattern passes requests along a chain of handlers.
 * Upon receiving a request, each handler decides either to process the request
 * or to pass it to the next handler in the chain. This pattern decouples the
 * sender of a request from its receivers, giving multiple objects a chance
 * to handle the request.
 * 
 * Key Components demonstrated:
 * - Handler: Defines interface for handling requests and optional successor link (RequestHandler)
 * - ConcreteHandler: Handles requests it's responsible for, passes others to successor
 *   (AccelerateHandler, TurnLeftHandler, TurnRightHandler, BrakeHandler)
 * - Client: Initiates requests to ConcreteHandler objects in the chain
 * 
 * This example demonstrates:
 * - Vehicle control system where different handlers process different types of requests
 * - Fluent chain construction for readable setup
 * - Request processing delegation along the chain
 * - Single responsibility - each handler knows only about its specific request type
 */
@Slf4j
public class App {

    // Static chain configuration - demonstrates chain setup and immutability
    static final RequestHandler chain;

    static {
        // Build the chain fluently - demonstrates chain construction pattern
        // Each handler links to the next, forming a processing pipeline
        chain = new AccelerateHandler();              // Head of chain - handles GoRequest
        chain.linkWith(new TurnLeftHandler())        // Handles LeftRequest
             .linkWith(new TurnRightHandler())       // Handles RightRequest  
             .linkWith(new BrakeHandler());          // Handles StopRequest (tail of chain)
    }

    /**
     * Program entry point - demonstrates Chain of Responsibility Pattern with vehicle control.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Chain of Responsibility Pattern Demonstration ---");
        log.info("Sending different requests to the head of the chain. Each handler will process or pass on the request.\n");

        log.info("--- Chain Structure ---");
        log.info("AccelerateHandler -> TurnLeftHandler -> TurnRightHandler -> BrakeHandler");
        log.info("Each request enters at the head and travels until a handler can process it.\n");

        log.info(">> Sending GoRequest...");
        // Request handled by AccelerateHandler (first in chain)
        chain.handle(new GoRequest());

        log.info("\n>> Sending LeftRequest...");
        // Request passes through AccelerateHandler, handled by TurnLeftHandler
        chain.handle(new LeftRequest());

        log.info("\n>> Sending RightRequest...");
        // Request passes through first two handlers, handled by TurnRightHandler
        chain.handle(new RightRequest());

        log.info("\n>> Sending StopRequest...");
        // Request passes through all handlers until BrakeHandler processes it
        chain.handle(new StopRequest());

        log.info("\n--- Chain of Responsibility Pattern Benefits Demonstrated ---");
        log.info("1. Decouples request senders from receivers");
        log.info("2. Multiple objects get chance to handle request");
        log.info("3. Chain can be configured dynamically");
        log.info("4. Single Responsibility - each handler has one reason to change");
        log.info("5. Open/Closed Principle - easy to add new handlers without modifying existing ones");

    }

}