import lombok.Getter;
import lombok.Setter;

import java.util.Map;

public class PetrolStation {
	@Getter
	@Setter
	Map<FuelType, Double> fuelPrice;


	public double refuel(Car car) {
		double valueToPay = (car.getFullCapacity() - car.getCurrentCapacity()) * fuelPrice.get(car.getFuelType
			());
		car.setCurrentCapacity(car.getFullCapacity());
		return valueToPay;
	}


	double fill(Car car, int fillValue) {
		double valueToPay = fillValue * fuelPrice.get(car.getFuelType());
		if (car.getFullCapacity() < car.getCurrentCapacity() + fillValue) {
			car.setCurrentCapacity(car.getCurrentCapacity() + fillValue);
		}
		else {
			car.setCurrentCapacity(car.getFullCapacity());
		}

		return valueToPay;
	}

	double clean(Car car) {
		double valueToPayForClean = 20;
		car.setCurrentCarDirty(0);
		return valueToPayForClean;
	}

	double changeWheel(Car car) {
		double valueToPayForChangeWheel = 1000;
		car.setCurrentWheelUsage(0);
		return valueToPayForChangeWheel;
	}
}

