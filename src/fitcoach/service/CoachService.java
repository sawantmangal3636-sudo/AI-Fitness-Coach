package fitcoach.service;

import fitcoach.util.ConsoleColors;
import fitcoach.model.WorkoutPlan;

public interface CoachService {
	//abstract method
	WorkoutPlan generatePlan(String planName, String goal);//abstract method
	
	//Default method
	default void printBanner() {
		System.out.println(fitcoach.util.ConsoleColors.colorize(fitcoach.util.ConsoleColors.CYAN, getHeader()));
	}
	//Static method
	static void info() {
		System.out.println(ConsoleColors.colorize(ConsoleColors.BLUE, "CoachService v1 - provides plan generation."));
	}
		//Private method in interface
		private String getHeader(){
			return "AI Fitness Coach";

	}
}
