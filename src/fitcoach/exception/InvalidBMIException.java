package fitcoach.exception;

//Demonstrates checked exception(extends Exception)
 public class InvalidBMIException extends Exception {
	public InvalidBMIException(String message) {
		super(message);
	}
}
