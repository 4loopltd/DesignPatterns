package _4loop.state;

public interface State {

    void next(Context context);

    void prev(Context context);

}
