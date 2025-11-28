package fitcoach.app;

import fitcoach.util.ConsoleColors;

import fitcoach.model.*;
import fitcoach.service.*;
import fitcoach.exception.*;
import fitcoach.util.FitnessUtils;

import java.time.LocalDate;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		try {
			System.out.println(ConsoleColors.colorize(ConsoleColors.CYAN, "AI Fitness Coach"));
			
			//Sealed classes + Overiding +polymorphism
			User u1 = new Beginner("Maya", 22);
			User u2 = new Advanced("Ravi", 28);
			u1.showDashboard();//overridden Beginner.showDashboard()
			u2.showDashboard();//overridden Advanced.showDashboard()
			
			//records + BMI calculation
			BodyStats stats = new BodyStats(70.0, 1.75, LocalDate.now());
			// Print BMI for a user
			String bmiStr = String.format("BMI of %s: %.2f", "Maya", stats.bmi());
			System.out.println(ConsoleColors.colorize(ConsoleColors.YELLOW, bmiStr));
			
			//coachAI usage(Implemets interface CoachService)
			CoachAI coach = new CoachAI();
			CoachService.info();//static interface method
			coach.generatePlan("Quick Start", "weight_loss");//overload-> string parse;
			WorkoutPlan wp2 = coach.generatePlan("By Goal", GoalType.MUSCLE_GAIN);//overload enum
			// use the plan to avoid unused variable and show result
			wp2.printSummary();
			
			//buildPlan
			    WorkoutPlan planVarargs = coach.buildPlan("VarargsPlan",
					new Exercise("Jump Rope", 500, GoalType.WEIGHT_LOSS),
					new Exercise("Push Ups", 300, GoalType.MUSCLE_GAIN)
			
	
		);
		// Use varargs plan we just built
		planVarargs.printSummary();
		
		//var
		var plans = coach.getSavedPlans();//var used
		System.out.println(ConsoleColors.colorize(ConsoleColors.GREEN, String.format("Saved plans count: %d", plans.size())));
		
		//Print using method reference 
		plans.forEach(WorkoutPlan::printSummary);//method refrence
		

		//Lambdas + Predicate find plans with heavy exercises
		List<WorkoutPlan> heavyPlans = coach.findPlansByExerciseCalories(500);
		System.out.println(ConsoleColors.colorize(ConsoleColors.YELLOW, String.format("Heavy plans count: %d", heavyPlans.size())));
		heavyPlans.forEach(WorkoutPlan::printSummary);
		System.out.println(ConsoleColors.colorize(ConsoleColors.GREEN, "Saved plans after clearing external copy: " + coach.getSavedPlans().size()));
		
		//Demonstrate call-by-value with string(immutable)
		String original ="original";
		FitnessUtils.mutateString(original);
		System.out.println(ConsoleColors.colorize(ConsoleColors.GREEN, "Outside mutateString: " + original));//unchanged shows pass by value of reference

		// Java 22 - unnamed variable runtime exception Java 22 Exception
		// We pass '_' to the mutateString method to trigger a demo runtime exception
		// that represents an 'unnamed variable' detection. We catch and print it.
		try {
			FitnessUtils.mutateString("_");
		} catch (Exception e) {
			System.out.println(ConsoleColors.colorize(ConsoleColors.RED, "Java 22 exception: " + e.getClass().getSimpleName() + " - " + e.getMessage()));
		}
		
		//Demonstrate checked exception path (valid stats)
		try {
			WorkoutPlan bmiPlan = coach.generatePlan("FromStats", stats);// may throw InvalidBMIException
			bmiPlan.printSummary();
		}catch(InvalidBMIException e) {
			System.out.println(ConsoleColors.colorize(ConsoleColors.RED, "Invalid BMI: " + e.getMessage()));
		}

		// Demo: add a bad BodyStats so that InvalidBMIException is triggered
		// BMI is set to 0 by using weight 0.0 which causes the validation in CoachAI
		// to throw an InvalidBMIException. This demonstrates the exception handling.
		BodyStats badStats = new BodyStats(0.0, 1.75, LocalDate.now());
		try {
			WorkoutPlan badPlan = coach.generatePlan("From Bad Stats", badStats);
			badPlan.printSummary();
		} catch (InvalidBMIException e) {
			System.out.println(ConsoleColors.colorize(ConsoleColors.RED, " Invalid BMI: " + e.getMessage()));
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
		System.out.println(ConsoleColors.colorize(ConsoleColors.YELLOW, report.toString()));
		
		//Show switch expression helper
		System.out.println(ConsoleColors.colorize(ConsoleColors.CYAN, FitnessUtils.goalDescription(GoalType.WEIGHT_LOSS)));
		
	}catch (Exception ex) {
		ex.printStackTrace();
		}
	}

}
