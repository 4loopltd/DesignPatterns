package uk.co._4loop.chainofresponsibility.handler;

import lombok.extern.slf4j.Slf4j;
import uk.co._4loop.chainofresponsibility.request.Request;
import uk.co._4loop.chainofresponsibility.request.StopRequest;

import java.util.Optional;

@Slf4j
public class BrakeHandler extends RequestHandler {

    @Override
    public void handle(Request request) {

        if (request instanceof StopRequest) {
            log.info(request.getAction());
            return;
        }

        log.info("Passing down the chain -> ");
        if (Optional.ofNullable(next).isPresent()) {
            next.handle(request);
        }
    }

}
