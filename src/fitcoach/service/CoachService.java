package fitcoach.service;
import fitcoach.model.WorkoutPlan;

public interface CoachService {
	//abstract method
	WorkoutPlan generatePlan(String planName, String goal);//abstract method
	
	//Default method
	default void printBanner() {
		System.out.println(getHeader());
	}
    //Static method
	static void info() {
		System.out.println("CoachService v1 - provides paln generation.");
	}
		//Private method in interface
		private String getHeader(){
			return "AiFitnessCoach";
		
	}
}
