package uk.co._4loop.chainofresponsibility.request;

public class LeftRequest implements Request {
    @Override
    public String getAction() {
        return "Turning Left";
    }
}
