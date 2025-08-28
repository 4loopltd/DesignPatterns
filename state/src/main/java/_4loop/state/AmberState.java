package _4loop.state;

public class AmberState implements State {

    private static final AmberState INSTANCE = new AmberState();

    private AmberState() {}

    public static AmberState getInstance() {
        return INSTANCE;
    }

    @Override
    public void prev(Context context) {
        context.setState(GreenState.getInstance());
    }

    @Override
    public void next(Context context) {
        context.setState(RedState.getInstance());
    }

    @Override
    public String toString() {
        return "AmberState{}";
    }
}
