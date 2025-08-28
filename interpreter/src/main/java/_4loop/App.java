package _4loop;

import _4loop.interpreter.InterpreterClient;
import _4loop.interpreter.InterpreterContext;
import lombok.extern.slf4j.Slf4j;

/**
 * Interpreter Pattern Demonstration Application
 * 
 * The Interpreter Pattern defines a representation for a grammar along with an
 * interpreter that uses the representation to interpret sentences in the language.
 * This pattern is useful when you have a language to interpret and you can represent
 * statements in the language as abstract syntax trees. It's commonly used for
 * implementing domain-specific languages, configuration file parsers, and expression evaluators.
 * 
 * Key Components demonstrated:
 * - AbstractExpression: Interface for executing operations (various number format interpreters)
 * - TerminalExpression: Implements operations for terminal symbols in grammar (literal values)
 * - NonterminalExpression: Implements operations for non-terminal symbols (complex expressions)
 * - Context: Contains information that's global to the interpreter (InterpreterContext)
 * - Client: Builds abstract syntax tree and invokes interpret operation (InterpreterClient)
 * 
 * This example demonstrates:
 * - Number format interpretation (binary, octal, decimal, hexadecimal)
 * - Context-aware parsing based on format prefixes
 * - Grammar rules for different number representations
 * - Extensible interpretation system for adding new formats
 */
@Slf4j
public class App {

    /**
     * Program entry point - demonstrates Interpreter Pattern with number format conversion.
     *
     * @param args command line args
     */
    public static void main(final String[] args) {

        log.info("--- Interpreter Pattern Demonstration ---");
        log.info("Interpreting different number formats using grammar rules and context.\n");

        log.info("--- Number Format Grammar Rules ---");
        log.info("Binary: '0b' followed by binary digits (0,1)");
        log.info("Octal: '0' followed by octal digits (0-7)");  
        log.info("Hexadecimal: '0x' followed by hex digits (0-9,A-F)");
        log.info("Decimal: No prefix, decimal digits (0-9)");

        // Sample inputs representing the same value (42) in different formats
        String binary = "0b00101010";     // Binary representation of 42
        String decimal = "042";           // Octal representation of 42 (note: 042 octal = 34 decimal)
        String hex = "0x2A";             // Hexadecimal representation of 42

        log.info("--- Creating Interpreter with Context ---");
        // Context holds shared information and state for interpretation
        InterpreterClient ec = new InterpreterClient(new InterpreterContext());

        log.info("--- Interpreting Different Number Formats ---");

        log.info(">> Interpreting Binary Format:");
        log.info("Input: {} -> Decimal: {}", binary, ec.interpret(binary));
        // Interpreter recognizes '0b' prefix and applies binary parsing rules

        log.info("\n>> Interpreting Octal Format:");  
        log.info("Input: {} -> Decimal: {}", decimal, ec.interpret(decimal));
        // Interpreter recognizes leading '0' and applies octal parsing rules

        log.info("\n>> Interpreting Hexadecimal Format:");
        log.info("Input: {} -> Decimal: {}", hex, ec.interpret(hex));
        // Interpreter recognizes '0x' prefix and applies hexadecimal parsing rules

        log.info("\n--- Testing Additional Cases ---");
        String plainDecimal = "42";
        log.info(">> Interpreting Plain Decimal:");
        log.info("Input: {} -> Decimal: {}", plainDecimal, ec.interpret(plainDecimal));

        log.info("\n--- Interpreter Pattern Benefits Demonstrated ---");
        log.info("1. Grammar rules are represented as classes (easy to understand and modify)");
        log.info("2. Easy to add new grammar rules without changing existing code");
        log.info("3. Complex parsing logic is broken down into manageable pieces");
        log.info("4. Context allows sharing of interpretation state and data");
        log.info("5. Expressions can be combined and reused to build complex interpreters");
        log.info("6. Supports recursive grammar structures naturally");

    }

}