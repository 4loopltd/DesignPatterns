package _4loop;

import _4loop.singleton.SingletonFour;
import _4loop.singleton.SingletonOne;
import _4loop.singleton.SingletonThree;
import _4loop.singleton.SingletonTwo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        // early
        SingletonOne singletonOneA = SingletonOne.getInstance();
        log.info("singletonOne: {}", singletonOneA.hashCode());

        SingletonOne singletonOneB = SingletonOne.getInstance();
        log.info("singletonOne: {}", singletonOneB.hashCode());

        // lazy
        SingletonTwo singletonTwoA = SingletonTwo.getInstance();
        log.info("SingletonTwo: {}", singletonTwoA.hashCode());

        SingletonTwo singletonTwoB = SingletonTwo.getInstance();
        log.info("SingletonTwo: {}", singletonTwoB.hashCode());

        // double lock
        SingletonThree singletonThreeA = SingletonThree.getInstance();
        log.info("SingletonThree: {}", singletonThreeA.hashCode());

        SingletonThree singletonThreeB = SingletonThree.getInstance();
        log.info("SingletonThree: {}", singletonThreeB.hashCode());

        // single shutdown hook
        SingletonFour singletonFourA = SingletonFour.getInstance();
        log.info("SingletonFour: {}", singletonFourA.hashCode());

        SingletonFour singletonFourB = SingletonFour.getInstance();
        log.info("SingletonFour: {}", singletonFourB.hashCode());

        // etc.......

    }

}