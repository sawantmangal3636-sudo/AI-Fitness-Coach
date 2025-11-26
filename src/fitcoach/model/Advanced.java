package fitcoach.model;

public final class Advanced extends User {
		public Advanced(String name, int age) {
			super(name, age);
		}
		public void showDashboard() {
			System.out.println("Advanced Dashboard for "+ name + "(age" + age + ")");
		}
}


