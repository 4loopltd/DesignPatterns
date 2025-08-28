package _4loop;

import _4loop.memento.Caretaker;
import _4loop.memento.Message;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    /**
     * Program entry point.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        Caretaker messageEditor = new Caretaker(new Message());
        messageEditor.write("The Memento pattern contains a snapshot of the state of an object, so that the object can return to its original state without having to reveal its content to the rest of the world.");
        messageEditor.save();
        messageEditor.write("The Memento pattern allows the state of an object to be captured and stored.");

        log.info(messageEditor.read());

        messageEditor.undo();
        messageEditor.write("The Memento pattern allows the state of an object to be captured and stored. The object can be put back to this (previous) state, when needed.");

        log.info(messageEditor.read());
    }

}