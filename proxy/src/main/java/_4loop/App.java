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

        final Subject subject = new ProxySubject();
        timeAndExecute("first pass", subject);
        timeAndExecute("second pass", subject);
        timeAndExecute("third pass", subject);
    }

    private static void timeAndExecute(final String passName, final Subject subject) {
        log.info("Calling Process {}", passName);
        final Instant start = Instant.now();
        subject.process();
        final long duration = Duration.between(start, Instant.now()).toMillis();
        log.info("Process completed in {} ms", duration);
    }
}