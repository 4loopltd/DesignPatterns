package _4loop.singleton;

@SuppressWarnings("InstantiationOfUtilityClass")
public class SingletonOne {

    static final SingletonOne instance = new SingletonOne();

    protected SingletonOne() {
    }

    public static SingletonOne getInstance() {
        return instance;
    }
}
