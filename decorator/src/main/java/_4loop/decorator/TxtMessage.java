package _4loop.decorator;

import java.util.Optional;

public class TxtMessage implements Message {

    private final String content;

    public TxtMessage(String content) {
        this.content = content;
    }

    @Override
    public String getMessage() {
        return Optional.ofNullable(content).orElse("");
    }
}
