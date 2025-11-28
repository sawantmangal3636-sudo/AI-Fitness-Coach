package fitcoach.app;

import fitcoach.model.*;
import fitcoach.service.*;
import fitcoach.exception.*;
import fitcoach.util.FitnessUtils;

import java.time.LocalDate;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("AI Fitness Coach");
			
			//Sealed classes + Overiding +polymorphism
			User u1 = new Beginner("Maya", 22);
			User u2 = new Advanced("Ravi", 28);
			u1.showDashboard();//overridden Beginner.showDashboard()
			u2.showDashboard();//overridden Advanced.showDashboard()
			
			//records + BMI calculation
			BodyStats stats = new BodyStats(70.0, 1.75, LocalDate.now());
			System.out.printf("BMI of %.2f%n", "Maya", stats.bmi());
			
			//coachAI usage(Implemets interface CoachService)
			CoachAI coach = new CoachAI();
			CoachService.info();//static interface method
			coach.generatePlan("Quick Start", "weight_loss");//overload-> string parse;
			WorkoutPlan wp2 = coach.generatePlan("By Goal", GoalType.MUSCLE_GAIN);//overload enum
			
			//buildPlan
			WorkoutPlan planVarargs = coach.buildPlan("VarargsPlan",
					new Exercise("Jump Rope", 500, GoalType.WEIGHT_LOSS),
					new Exercise("Push Ups", 300, GoalType.MUSCLE_GAIN)
			
	
		);
		
		//var
		var plans = coach.getSavedPlans();//var used
		System.out.printf("Saved palns counts:" +plans.size());
		
		//Print using method reference 
		plans.forEach(WorkoutPlan::printSummary);//method refrence
		

		//Lambdas + Predicate find plans with heavy exercises
		List<WorkoutPlan> heavyPlans = coach.findPlansByExerciseCalories(500);
		System.out.println("Saved palns after clearing external copy:" + coach.getSavedPlans().size());
		
		//Demonstrate call-by-value with string(immutable)
		String original ="original";
		FitnessUtils.mutateString(original);
		System.out.println("Outside mutateString:" + original);//unchanged shows pass by value of reference
		
		//Demonstrate checked exception path
		try {
			WorkoutPlan bmiPlan = coach.generatePlan("FromStats", stats);// may throw InvalidBMIException
			bmiPlan.printSummary();
		}catch(InvalidBMIException e) {
			System.out.println("Invalid BMI:" +e.getMessage());
		}
		
		//Demonstrate arays usage
		Exercise[] quick = new Exercise[] {
			new Exercise("Walk", 200, GoalType.MAINTAIN),
			new Exercise("Squats", 350, GoalType.MUSCLE_GAIN)
		};
		WorkoutPlan quickPlan = WorkoutPlan.of("Quick Array Plan", quick);
		quickPlan.printSummary();
		
		//Demonstrate custom immutable FitnessReport
		FitnessReport report = new FitnessReport(u1.getName(), stats,"Keep up the good work!");
		System.out.println(report);
		
		//Show switch expression helper
		System.out.println(FitnessUtils.goalDescription(GoalType.WEIGHT_LOSS));
		
	}catch (Exception ex) {
		ex.printStackTrace();
		}
	}

}
