 package fitcoach.model;

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
	public GoalType getGoalType() {return goaltype;}
	
	public String to string() {
		return name + "(" + caloriesBurnPerHour + "kcal/hr) -" + goalType;
	}
}

