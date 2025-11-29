package fitcoach.exception;

/**
 * Runtime exception used to demonstrate a Java 22 "unnamed variable" scenario.
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
