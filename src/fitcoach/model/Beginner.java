package fitcoach.model;

import fitcoach.util.ConsoleColors;

public final class Beginner extends User {
	public Beginner(String name, int age) {
		super(name, age);//super()
	}
	
	//Override
	public void showDashboard() {
		String header = "Beginner Dashboard for " + name + " (age " + age + ")";
		System.out.println(ConsoleColors.colorize(ConsoleColors.CYAN, header));
	}
	
	//Example method to show super. usage (calls parent behaviour)
	public void showAndNote() {
		showDashboard();
		System.out.println(ConsoleColors.colorize(ConsoleColors.WHITE, "Note: beginner tips shown above."));
	}

}
