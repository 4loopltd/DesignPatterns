package uk.co._4loop.chainofresponsibility.handler;

import lombok.extern.slf4j.Slf4j;
import uk.co._4loop.chainofresponsibility.request.LeftRequest;
import uk.co._4loop.chainofresponsibility.request.Request;

import java.util.Optional;

@Slf4j
public class TurnLeftHandler extends RequestHandler {

    @Override
    public void handle(Request request) {

        if (request instanceof LeftRequest) {
            log.info(request.getAction());
            return;
        }

        log.info("Passing down the chain -> ");
        if (Optional.ofNullable(next).isPresent()) {
            next.handle(request);
        }
    }

}
