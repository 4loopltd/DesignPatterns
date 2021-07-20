package uk.co._4loop.chainofresponsibility.request;

public class GoRequest implements Request {
    @Override
    public String getAction() {
        return "Accelerating";
    }
}
