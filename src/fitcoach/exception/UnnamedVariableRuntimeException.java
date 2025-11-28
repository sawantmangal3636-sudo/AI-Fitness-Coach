package fitcoach.exception;

/**
 * Runtime exception used to demonstrate a Java 22 "unnamed variable" scenario.
 *
 * This class is only a demo exception — it represents an error condition where an
 * 'unnamed' variable (such as the single underscore `_`) is present and treated as
 * an invalid or unsupported case. Use this in examples or tests only.
 */
public class UnnamedVariableRuntimeException extends RuntimeException {

    public UnnamedVariableRuntimeException() {
        super();
    }

    public UnnamedVariableRuntimeException(String message) {
        super(message);
    }

    public UnnamedVariableRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnnamedVariableRuntimeException(Throwable cause) {
        super(cause);
    }
}
