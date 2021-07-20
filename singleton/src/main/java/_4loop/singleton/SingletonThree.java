package _4loop.singleton;

@SuppressWarnings("InstantiationOfUtilityClass")
public class SingletonThree {

    static SingletonThree instance;

    protected SingletonThree() {
    }

    public static SingletonThree getInstance() {

        if (instance == null) {
            synchronized (SingletonThree.class) {
                if (instance == null) {
                    instance = new SingletonThree();
                }
            }
        }

        return instance;
    }
}
