package uk.co._4loop.chainofresponsibility.handler;

import uk.co._4loop.chainofresponsibility.request.Request;

public abstract class RequestHandler {

    protected RequestHandler next;

    public void setNext(RequestHandler next) {
        this.next = next;
    }

    public abstract void handle(Request request);
}
