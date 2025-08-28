package _4loop.memento;

public record MessageState(String text) {

    public String getText() {
        return text;
    }
}
