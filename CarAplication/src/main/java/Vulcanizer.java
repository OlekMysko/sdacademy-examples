import lombok.Getter;

public class Vulcanizer {

	@Getter
	double changingTiresPrice =1000;


	public double changeTires(Car car) {
		car.setTireWearStatus(0);
		return changingTiresPrice;
	}
}
