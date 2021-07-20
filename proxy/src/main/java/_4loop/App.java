package _4loop;

import _4loop.proxy.ProxySubject;
import _4loop.proxy.Subject;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        Subject subject = new ProxySubject();

        log.info("Calling Process first pass");
        Instant start = Instant.now();
        subject.process();
        log.info("Process competed: {}", Duration.between(start, Instant.now()).toMillis());

        log.info("Calling Process second pass");
        start = Instant.now();
        subject.process();
        log.info("Process competed: {}", Duration.between(start, Instant.now()).toMillis());

        log.info("Calling Process third pass");
        start = Instant.now();
        subject.process();
        log.info("Process competed: {}", Duration.between(start, Instant.now()).toMillis());
    }

}