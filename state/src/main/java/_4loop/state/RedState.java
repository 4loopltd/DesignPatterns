package _4loop.state;

public class RedState implements State {

    @Override
    public void prev(Context context) {
        context.setState(new AmberState());
    }

    @Override
    public void next(Context context) {
        context.setState(new RedAmberState());
    }

    @Override
    public String toString() {
        return "RedState{}";
    }
}
