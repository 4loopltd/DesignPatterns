package _4loop.mediator.colleague;

import _4loop.mediator.Mediator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CatColleague extends Colleague {

    public CatColleague(Mediator mediator) {
        super(mediator);
    }

    public void receive(String message) {
        log.info("Cat Received: " + message);
    }
}
