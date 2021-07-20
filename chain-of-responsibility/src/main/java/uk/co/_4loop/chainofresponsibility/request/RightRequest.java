package uk.co._4loop.chainofresponsibility.request;

public class RightRequest implements Request {
    @Override
    public String getAction() {
        return "Turning Right";
    }
}
