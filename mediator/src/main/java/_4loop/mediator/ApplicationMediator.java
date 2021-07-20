package _4loop.mediator;

import _4loop.mediator.colleague.Colleague;

import java.util.ArrayList;

public class ApplicationMediator implements Mediator {

    private final ArrayList<Colleague> colleagues = new ArrayList<>();

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void send(String message, Colleague originator) {
        for (Colleague colleague : colleagues) {
            if (colleague != originator) {
                colleague.receive(message);
            }
        }
    }

}