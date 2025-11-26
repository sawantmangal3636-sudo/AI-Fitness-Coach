package fitcoach.model;

public sealed abstract class User permits Beginner , Advanced{
	protected final String name;
	protected final int age;
	public User(String name, int age) {
		//constructor this()
		this.name = name;
		this.age = age;
	}
	
	public String getName() {return name;}
	public int getAge() {return age;}
	
	
	public abstract void showDashboard();//overidden in subclasses
} 

