package _4loop.memento;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MementoTest {

    @Test
    void saveAndUndo_restoresPreviousText() {
        Caretaker editor = new Caretaker(new Message());
        editor.write("first line");
        editor.save();
        editor.write("second line");

        // Undo should restore to after first line
        editor.undo();
        String text = editor.read();
        assertEquals("first line\n", text);
    }
}
