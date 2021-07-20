package _4loop;

import _4loop.interpreter.InterpreterClient;
import _4loop.interpreter.InterpreterContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        String binary = "0b00101010";
        String decimal = "042";
        String hex = "0x2A";

        InterpreterClient ec = new InterpreterClient(new InterpreterContext());
        log.info(binary + " in decimal " + ec.interpret(binary));
        log.info(decimal + " in decimal " + ec.interpret(decimal));
        log.info(hex + " in decimal " + ec.interpret(hex));

    }

}