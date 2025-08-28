package _4loop.state;

public class RedAmberState implements State {

    private static final RedAmberState INSTANCE = new RedAmberState();
    private RedAmberState() {}
    public static RedAmberState getInstance() {
        return INSTANCE;
    }

    @Override
    public void prev(Context context) {
        context.setState(RedState.getInstance());
    }

    @Override
    public void next(Context context) {
        context.setState(GreenState.getInstance());
    }

    @Override
    public String toString() {
        return "RedAmberState{}";
    }
}
