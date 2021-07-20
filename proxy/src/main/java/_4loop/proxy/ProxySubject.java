package _4loop.proxy;

public class ProxySubject implements Subject {

    private static RealSubject realSubject;

    @Override
    public void process() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.process();
    }
}
