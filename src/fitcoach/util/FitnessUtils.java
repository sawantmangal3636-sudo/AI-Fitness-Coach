package fitcoach.util;

import fitcoach.model.GoalType;
import fitcoach.exception.UnnamedVariableRuntimeException;

public class FitnessUtils {
	
	public static String goalDescription(GoalType g) {
		return switch (g) {
		case WEIGHT_LOSS ->"Burn calories and reduce weight";
		case MUSCLE_GAIN -> "Build muscle mass and strength";
		case MAINTAIN ->"Keep current fitness level";
		};
	}
		
	public static void mutateString(String s) {
		// Demo: If the input is the underscore character '_' (commonly used to denote
		// an unused or unnamed variable), throw a custom runtime exception. This emulates
		// the case where code analysis or a language-level check flags an unnamed
		// variable as an error. In real Java, '_' as a single identifier is illegal
		// starting from JDK 9, but this demonstrates throwing a runtime exception.
		if (s != null && s.equals("_")) {
			throw new UnnamedVariableRuntimeException("Detected unnamed variable '_', which is invalid in this demo.");
		}

		s = s + " mutated";
		System.out.println(ConsoleColors.colorize(ConsoleColors.BLUE, "Inside mutateString: " + s));

	}

		
}


