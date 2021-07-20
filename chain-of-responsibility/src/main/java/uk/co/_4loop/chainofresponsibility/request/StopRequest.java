package uk.co._4loop.chainofresponsibility.request;

public class StopRequest implements Request {
    @Override
    public String getAction() {
        return "Braking";
    }
}
