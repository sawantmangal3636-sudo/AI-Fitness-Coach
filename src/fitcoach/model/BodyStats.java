package fitcoach.model;
import  java.time.LocalDate;

public record  BodyStats(double weightKg, double heightMeters, LocalDate measuredOn) {
	public double bmi() {
		return weightKg /(heightMeters * heightMeters);
	}

}
