package _4loop.momento;

public class Caretaker {

    private final Message message;
    private MessageState messageState;

    public Caretaker(Message message) {
        this.message = message;
    }

    public String read() {
        return message.read();
    }

    public void write(String text) {
        message.write(text);
    }

    public void save() {
        messageState = new MessageState(message.read());
    }

    public void undo() {
        message.restore(messageState.getText());
    }
}
