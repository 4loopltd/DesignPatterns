package _4loop.mediator.colleague;

import _4loop.mediator.Mediator;

public abstract class Colleague {

    private final Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public void send(String message) {
        mediator.send(message, this);
    }

    public abstract void receive(String message);
}