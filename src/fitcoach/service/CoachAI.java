package fitcoach.service;

import java.util.List;

import fitcoach.model.BodyStats;
import fitcoach.model.GoalType;
import fitcoach.model.WorkoutPlan;

public class CoachAI implements CoachService{
	private final List<WorkoutPlan> savedPlans = ArrayList<>();
	
	public WorkoutPlan generatePlan (String planName, String goal) {
		//overLoads will call this central method after parsing goal 
		GoalType g = parseGoal(goal);
		return generatePlan(planName, g);
	}
	//OverLoaded method : accepts enum
	public WorkoutPlan generatePlan(String planName, GoalType goalType) {
		//switch expression (GoalType)
		List<Exercise> exercises = switch (goalType) {
		case WEIGHT_LOSS -> List.of(
				new Exercise("Jogging", 400, GoalType.Weight_LOSS),
				new Exercise("Cycling", 500, GoalType.Weight_LOSS)
			
				);
		
		case MUSCLE_GGAIN -> List.of(
				new Exercise("Weight Lifting", 600, GoalType.MUSCLE_GAIN),
				new Exercise("Resistance Training", 550, GoalType.MUSCLE_GAIN)
				);
		case MAINTAIN -> List.of(
				new Exercise("Brisk Walk", 250, GoalType.MAINTAIN),
				new Exercise("Swimming", 450, GoalType.MAINTAIN)
				);
		};
		WorkoutPlan plan = buildPlan(planName, exercises.toArray(new Exercise[0]));
		savedPlans.add(plan);
		return plan;
	}
	public WorkoutPlan generatePlan(String planName, BodyStats stats)throw new InvalidBMIException{
		double bmi = stats.bmi();
		if(Double.isNaN(bmi) || bmi <= 0) throw new InvalidBMIException("Invalid BMI from stats.");
		//choose goal by BMI
		GoalTYpe goal = (bmi >= 25.0) ? GoalType.WEIGHT_LOSS : GoalType.MAINTAIN;
		return generatePlan(planName, goal);
	}
	public WorkoutPlan buildPlan(String planName, Exercise...exercise) {
		return WorkoutPlan.of(planName, exercise);
	}
	
	private GoalType parseGoal(String g) {
		try {
			return GoalType.valueOf(g.toUpperCase());
		} catch (Exception e) {
			return GoalType.MAINTAIN;
		}
	}
	
	public List<WorkoutPlan> findPlansByExerciseCalories(int minCalories){
		Predicate<Exercise> heavy = ex -> ex.getCaloriesBurnPerHour() >= minCalories;
		
		return savedPlans.stream()
				.filter(plan -> plan.getExercise().stream().anyMatch(heavy))
				.collect(Collectors.toList());
	}
	
	public WorkoutPlan recommendByUser(User user) {
		if(user instanceof Beginner b) {
			return generatePlan(b.getName)() + " - Starter", GoalType.MAINTAIN);
		}
		else if (user instanceof Advanced a){
			return generatePlan)(a.getName() + " - Pro", GoalType.MUSCLE_GAIN);
		}
		else {
			return generatePlan("Generic Plan", GoalType.MAINTAIN);
		}	
	}
	public List<WorkoutPlan> getSavedPlans(){
		return new ArrayList<>(savedPlans);
	}
	
	
}

