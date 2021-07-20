package _4loop.interpreter.expression;

import _4loop.interpreter.InterpreterContext;

public class BinaryToDecimalExpression implements Expression {

    private final String value;

    public BinaryToDecimalExpression(String value) {
        this.value = value;
    }

    @Override
    public String interpret(InterpreterContext context) {
        return context.getDecimalFromBinary(value);
    }
}
