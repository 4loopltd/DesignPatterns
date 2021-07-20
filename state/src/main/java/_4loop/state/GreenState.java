package _4loop.state;

public class GreenState implements State {

    @Override
    public void prev(Context context) {
        context.setState(new RedAmberState());
    }

    @Override
    public void next(Context context) {
        context.setState(new AmberState());
    }

    @Override
    public String toString() {
        return "GreenState{}";
    }
}
