package uk.co._4loop;

import lombok.extern.slf4j.Slf4j;
import uk.co._4loop.chainofresponsibility.handler.*;
import uk.co._4loop.chainofresponsibility.request.GoRequest;
import uk.co._4loop.chainofresponsibility.request.LeftRequest;
import uk.co._4loop.chainofresponsibility.request.RightRequest;
import uk.co._4loop.chainofresponsibility.request.StopRequest;

@Slf4j
public class App {

    static final RequestHandler chain;

    static {
        // Build the chain fluently
        chain = new AccelerateHandler();
        chain.linkWith(new TurnLeftHandler())
             .linkWith(new TurnRightHandler())
             .linkWith(new BrakeHandler());
    }

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Chain of Responsibility Pattern Demonstration ---");
        log.info("Sending different requests to the head of the chain. Each handler will process or pass on the request.\n");

        log.info(">> Sending GoRequest...");
        chain.handle(new GoRequest());

        log.info("\n>> Sending LeftRequest...");
        chain.handle(new LeftRequest());

        log.info("\n>> Sending RightRequest...");
        chain.handle(new RightRequest());

        log.info("\n>> Sending StopRequest...");
        chain.handle(new StopRequest());

    }

}