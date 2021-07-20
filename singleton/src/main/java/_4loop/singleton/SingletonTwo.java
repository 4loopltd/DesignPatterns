package _4loop.singleton;

@SuppressWarnings("InstantiationOfUtilityClass")
public class SingletonTwo {

    static SingletonTwo instance;

    protected SingletonTwo() {
    }

    synchronized public static SingletonTwo getInstance() {

        if (instance == null) {
            instance = new SingletonTwo();
        }

        return instance;
    }
}
