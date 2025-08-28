package _4loop.singleton;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

    @Test
    void singletonOne_returnsSameInstance() {
        SingletonOne a = SingletonOne.getInstance();
        SingletonOne b = SingletonOne.getInstance();
        assertSame(a, b, "SingletonOne should return the same instance");
    }

    @Test
    void singletonTwo_returnsSameInstance_singleThreaded() {
        SingletonTwo a = SingletonTwo.getInstance();
        SingletonTwo b = SingletonTwo.getInstance();
        assertSame(a, b, "SingletonTwo should return the same instance in single thread");
    }

    @Test
    @Timeout(5)
    void singletonThree_isThreadSafe_doubleCheckedLocking() throws InterruptedException {
        int threads = 20;
        ExecutorService pool = Executors.newFixedThreadPool(threads);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(threads);
        Set<Integer> ids = Collections.synchronizedSet(new HashSet<>());

        for (int i = 0; i < threads; i++) {
            pool.submit(() -> {
                try {
                    start.await();
                    SingletonThree s = SingletonThree.getInstance();
                    ids.add(System.identityHashCode(s));
                } catch (InterruptedException ignored) {
                } finally {
                    done.countDown();
                }
            });
        }
        start.countDown();
        boolean completed = done.await(3, TimeUnit.SECONDS);
        pool.shutdownNow();
        assertTrue(completed, "All tasks should complete");
        assertEquals(1, ids.size(), "Only one instance should be observed across threads");
    }

    @Test
    void singletonFour_returnsSameInstance() {
        SingletonFour a = SingletonFour.getInstance();
        SingletonFour b = SingletonFour.getInstance();
        assertSame(a, b, "SingletonFour should return the same instance");
    }
}
