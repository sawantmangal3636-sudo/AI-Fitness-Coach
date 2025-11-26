package fitcoach.service;
import fitcoach.model.WorkoutPlan;

public interface CoachService {
	WorkoutPlan generatePlan(String planName, String goal);//abstract method
	
	default void printBanner() {
		System.out.println(getHeader());
	}

	static void info() {
		System.out.println("CoachService v1 - provides paln generation.");
		
		private String getHeader() {
			return "AiFitnessCoach";
		}
	}
}
