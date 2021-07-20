package _4loop.state;

public class AmberState implements State {

    @Override
    public void prev(Context context) {
        context.setState(new GreenState());
    }

    @Override
    public void next(Context context) {
        context.setState(new RedState());
    }

    @Override
    public String toString() {
        return "AmberState{}";
    }
}
