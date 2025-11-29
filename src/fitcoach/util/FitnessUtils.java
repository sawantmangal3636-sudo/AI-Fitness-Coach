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
		
		if (s != null && s.equals("")) {
			throw new UnnamedVariableRuntimeException("Detected unnamed variable, which is invalid.");
		}

		s = s + " mutated";
		System.out.println(ConsoleColors.colorize(ConsoleColors.BLUE, "Inside mutateString: " + s));

	}

		
}


