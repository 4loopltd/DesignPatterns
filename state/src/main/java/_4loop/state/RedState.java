package _4loop.state;

public class RedState implements State {

    private static final RedState INSTANCE = new RedState();

    private RedState() {}

    public static RedState getInstance() {
        return INSTANCE;
    }

    @Override
    public void prev(Context context) {
        context.setState(AmberState.getInstance());
    }

    @Override
    public void next(Context context) {
        // Assuming RedAmberState is also converted to a singleton
        context.setState(RedAmberState.getInstance());
    }

    @Override
    public String toString() {
        return "RedState{}";
    }
}
