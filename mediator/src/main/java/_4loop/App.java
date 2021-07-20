package _4loop;

import _4loop.mediator.ApplicationMediator;
import _4loop.mediator.colleague.CatColleague;
import _4loop.mediator.colleague.Colleague;
import _4loop.mediator.colleague.DogColleague;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        ApplicationMediator mediator = new ApplicationMediator();

        Colleague cat = new CatColleague(mediator);
        Colleague dog = new DogColleague(mediator);

        mediator.addColleague(cat);
        mediator.addColleague(dog);

        cat.send("Hello Dog");
        dog.send("Hello Cat");
    }

}