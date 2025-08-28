package uk.co._4loop.chainofresponsibility.handler;

import uk.co._4loop.chainofresponsibility.request.Request;

public abstract class RequestHandler {

    protected RequestHandler next;

    /**
     * Sets the next handler in the chain and returns it for fluent building.
     * @param next The next handler.
     * @return The next handler.
     */
    public RequestHandler linkWith(RequestHandler next) {
        this.next = next;
        return next;
    }

    public void setNext(RequestHandler next) {
        this.next = next;
    }

    public abstract void handle(Request request);
}
