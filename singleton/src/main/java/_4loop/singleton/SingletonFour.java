package _4loop.singleton;

import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("InstantiationOfUtilityClass")
@Slf4j
public class SingletonFour {

    static SingletonFour instance;

    protected SingletonFour() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.info("Cleaning up");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
    }

    public static SingletonFour getInstance() {

        if (instance == null) {
            synchronized (SingletonFour.class) {
                if (instance == null) {
                    instance = new SingletonFour();
                }
            }
        }

        return instance;
    }
}
