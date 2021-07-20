package _4loop.interpreter;

import _4loop.interpreter.expression.BinaryToDecimalExpression;
import _4loop.interpreter.expression.Expression;
import _4loop.interpreter.expression.HexToDecimalExpression;
import _4loop.interpreter.expression.NullExpression;

public class InterpreterClient {

    final InterpreterContext context;

    public InterpreterClient(InterpreterContext context) {
        this.context = context;
    }

    public String interpret(String value) {
        Expression exp = new NullExpression(value);
        if (value.startsWith("0b")) {
            exp = new BinaryToDecimalExpression(value);
        } else if (value.startsWith("0x")) {
            exp = new HexToDecimalExpression(value);
        }
        return exp.interpret(context);
    }
}
