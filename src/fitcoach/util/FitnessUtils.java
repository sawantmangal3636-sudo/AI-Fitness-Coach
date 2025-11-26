package fitcoach.util;

import fitcoach.model.GoalType;

public class FitnessUtils {
	
	public static String goalDescription(GoalType g) {
		return switch (g) {
		case WEIGHT_LOSS ->"Burn calories and reduce weight";
		case MUSCLE_GAIN -> "Build muscle mass and strength";
		case MAINTAIN ->"Keep current fitness level";
		};
	}
		
	public static void mutateString(String s) {
		s = s + "mutated";
		System.out.println("Inside mutateString:"+s);
	
    }

		
}


