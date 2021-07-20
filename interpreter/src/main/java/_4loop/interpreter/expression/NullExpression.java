package _4loop.interpreter.expression;

import _4loop.interpreter.InterpreterContext;

public class NullExpression implements Expression {

    private final String value;

    public NullExpression(String value) {
        this.value = value;
    }

    @Override
    public String interpret(InterpreterContext context) {
        return context.trimLeadingZeros(value);
    }

}
