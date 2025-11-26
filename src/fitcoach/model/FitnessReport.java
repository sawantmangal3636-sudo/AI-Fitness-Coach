package fitcoach.model;

public class FitnessReport {
	private final String userName;
	private final BodyStats stats;
	private final String summary;
	
	public FitnessReport(String userName, BodyStats stats, String summary) {
		this.userName = userName;
		this.stats = stats;
		this.summary = summary;
	}
	
	public String getUserName() {return userName;}
	public BodyStats getStats() {return stats;}
	public String getSummary() {return summary;}
	
	public String tostring() {
		return "FitnessReport{" + "userName='" + userName + '\'' +", stats=" + stats + ", summary=" + '\'' +'}';
	}

}
