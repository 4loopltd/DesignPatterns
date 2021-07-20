package _4loop.decorator;

import java.util.Base64;

public class DecodedMessage extends MessageDecorator {

    public DecodedMessage(Message message) {
        originalMessage = message;
    }

    @Override
    public String getMessage() {
        return decode(originalMessage.getMessage());
    }

    private String decode(String message) {
        return new String(Base64.getDecoder().decode(message));
    }

}
