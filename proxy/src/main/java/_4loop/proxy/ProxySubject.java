package _4loop.proxy;

public class ProxySubject implements Subject {

    // Each proxy should manage its own real subject instance.
    // Making it static would mean all ProxySubject instances share a single RealSubject.
    private RealSubject realSubject;

    @Override
    public void process() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        realSubject.process();
    }
}
