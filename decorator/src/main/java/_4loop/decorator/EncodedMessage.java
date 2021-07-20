package _4loop.decorator;

import java.util.Base64;

public class EncodedMessage extends MessageDecorator {

    public EncodedMessage(Message message) {
        originalMessage = message;
    }

    @Override
    public String getMessage() {
        return encode(originalMessage.getMessage());
    }

    private String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

}
