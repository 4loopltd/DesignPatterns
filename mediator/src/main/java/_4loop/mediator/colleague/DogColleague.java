package _4loop.mediator.colleague;

import _4loop.mediator.Mediator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DogColleague extends Colleague {
    public DogColleague(Mediator mediator) {
        super(mediator);
    }

    public void receive(String message) {
        log.info("Dog Received: " + message);
    }
}
