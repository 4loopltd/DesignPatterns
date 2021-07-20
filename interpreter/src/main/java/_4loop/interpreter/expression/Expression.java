package _4loop.interpreter.expression;

import _4loop.interpreter.InterpreterContext;

public interface Expression {

    String interpret(InterpreterContext context);
}
