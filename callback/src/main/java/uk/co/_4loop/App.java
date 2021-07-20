package uk.co._4loop;

import lombok.extern.slf4j.Slf4j;
import uk.co._4loop.callback.SimpleTask;
import uk.co._4loop.callback.Task;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {
        Task task = new SimpleTask();
        task.executeWith(() -> log.info("Completed."));
    }
}

