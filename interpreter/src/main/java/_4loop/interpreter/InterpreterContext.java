package _4loop.interpreter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InterpreterContext {

    private final String INVALID = "[Invalid Value %s]";

    public String getDecimalFromBinary(String value) {
        try {
            return String.valueOf(Long.parseLong(value.substring(2), 2));
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
        }
        return String.format(INVALID, value);
    }

    public String getDecimalFromHex(String value) {
        try {
            return String.valueOf(Long.parseLong(value.substring(2), 16));
        } catch (NumberFormatException e) {
            log.error(e.getMessage());
        }

        return String.format(INVALID, value);
    }

    public String trimLeadingZeros(String value) {
        return value.replaceFirst("^0+(?!$)", "");
    }
}
