package fitcoach.model;

import fitcoach.util.ConsoleColors;

public final class Advanced extends User {
		public Advanced(String name, int age) {
			super(name, age);
		}
		public void showDashboard() {
			String header = "Advanced Dashboard for " + name + " (age " + age + ")";
			System.out.println(ConsoleColors.colorize(ConsoleColors.PURPLE, header));
		}
}


 