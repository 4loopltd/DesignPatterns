package _4loop.interpreter.expression;

import _4loop.interpreter.InterpreterContext;

public class HexToDecimalExpression implements Expression {

    private final String value;

    public HexToDecimalExpression(String value) {
        this.value = value;
    }

    @Override
    public String interpret(InterpreterContext context) {
        return context.getDecimalFromHex(value);
    }
}
