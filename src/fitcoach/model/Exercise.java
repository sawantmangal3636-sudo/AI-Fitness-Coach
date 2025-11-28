package fitcoach.model;

import fitcoach.util.ConsoleColors;

public class Exercise {
	private final String name;
	private final int caloriesBurnPerHour;
	private final GoalType goalType;
	
	public Exercise(String name, int caloriesBurnPerHour, GoalType goalType) {
		this.name = name;
		this.caloriesBurnPerHour = caloriesBurnPerHour;
		this.goalType = goalType;
	}
	
	public String getname() {return name;}
	public int getCaloriesBurnPerHour() {return caloriesBurnPerHour;}
	public GoalType getGoalType() {return goalType;}
	
	public String toString() {
		// e.g. "Jump Rope (500kcal/hr) - WEIGHT_LOSS"
		return name + " (" + caloriesBurnPerHour + "kcal/hr) - "
				+ ConsoleColors.colorize(ConsoleColors.YELLOW, String.valueOf(goalType));
	}
}

