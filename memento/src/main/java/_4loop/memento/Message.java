package _4loop.memento;

public class Message {

    private StringBuilder content = new StringBuilder();

    public String read() {
        return content.toString();
    }

    public void write(String text) {
        content.append(text);
        content.append("\n");
    }

    public void restore(String text) {
        content = new StringBuilder(text);
    }

}
