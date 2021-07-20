package _4loop.state;

public class RedAmberState implements State {

    @Override
    public void prev(Context context) {
        context.setState(new RedState());
    }

    @Override
    public void next(Context context) {
        context.setState(new GreenState());
    }

    @Override
    public String toString() {
        return "RedAmberState{}";
    }
}
