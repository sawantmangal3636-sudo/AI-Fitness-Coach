package fitcoach.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WorkoutPlan {
	private final String planName;
	private final List<Exercise> exercises;
	
	public WorkoutPlan(String palnName, List<Exercise> exercises) {
		this.planName = planName;
		
		this.exercises = new ArrayList<>(exercises);
		
	}
	public static WorkoutPlan of(String name, Exercise...exercises) {
		return new Workout of(name, Arrays.asList(exercises));
	}
	
	public String getPlanName() {return planName;}
	
	public List<Exercise> getExercises(){
		return new ArrayList<>(exercises);	
		}
	public void printSummary() {
		var sb = new StringBuilder();
		sb.append("Plan:").append(planName).append("\n");
		for(var ex : exercises) {
			sb.append("-").append(ex).append("\n");
		}
		System.out.println(sb.toString());
	}

}
