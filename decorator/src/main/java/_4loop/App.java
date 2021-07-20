package _4loop;

import _4loop.decorator.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        Message message = new TxtMessage("Hello");
        log.info("Txt message: " + message.getMessage());

        MessageDecorator encoded = new EncodedMessage(message);
        log.info("Encoded message: " + encoded.getMessage());

        MessageDecorator decoded = new DecodedMessage(encoded);
        log.info("Decoded message: " + decoded.getMessage());
    }

}