package uk.co._4loop;

import lombok.extern.slf4j.Slf4j;
import uk.co._4loop.chainofresponsibility.handler.*;
import uk.co._4loop.chainofresponsibility.request.GoRequest;
import uk.co._4loop.chainofresponsibility.request.LeftRequest;
import uk.co._4loop.chainofresponsibility.request.RightRequest;
import uk.co._4loop.chainofresponsibility.request.StopRequest;

@Slf4j
public class App {

    static final RequestHandler accelerate = new AccelerateHandler();
    static final RequestHandler turnLeft = new TurnLeftHandler();
    static final RequestHandler turnRight = new TurnRightHandler();
    static final RequestHandler brake = new BrakeHandler();
    static final RequestHandler chain;

    static {
        accelerate.setNext(turnLeft);
        turnLeft.setNext(turnRight);
        turnRight.setNext(brake);

        chain = accelerate;
    }

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("Request Go");
        chain.handle(new GoRequest());

        log.info("Request Left");
        chain.handle(new LeftRequest());

        log.info("Request Right");
        chain.handle(new RightRequest());

        log.info("Request Stop");
        chain.handle(new StopRequest());

    }

}