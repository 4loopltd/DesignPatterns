package _4loop.state;

public class GreenState implements State {

    private static final GreenState INSTANCE = new GreenState();
    private GreenState() {}

    public static GreenState getInstance() {
        return INSTANCE;
    }

    @Override
    public void prev(Context context) {
        context.setState(RedAmberState.getInstance());
    }

    @Override
    public void next(Context context) {
        context.setState(AmberState.getInstance());
    }

    @Override
    public String toString() {
        return "GreenState{}";
    }
}
