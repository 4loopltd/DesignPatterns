package _4loop.mediator;

import _4loop.mediator.colleague.Colleague;

public interface Mediator {
    void send(String message, Colleague colleague);
}