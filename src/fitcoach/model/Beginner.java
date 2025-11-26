package fitcoach.model;

public final class Beginner extends User {
	public Beginner(String name, int age) {
		super(name, age);//super()
	}
	
	//Override
	public void showDashboard() {
		System.out.println("Beginner Dashboard for"+ name + "(age" + age +")");
	}
	
	//Example method to show super. usage (calls parent behaviour)
	public void showAndNote() {
		showDashboard();
		System.out.println("Note: beginner tips shown above.");
	}

}
