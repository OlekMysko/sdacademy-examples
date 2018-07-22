import lombok.Getter;
import lombok.Setter;

class GasStation {

	@Setter
	@Getter
	double price4Liter;

	double fillTofull(Car car) {

		double payment = (car.getMaxFuelLevel()-car.getCurrentFuelLevel())*price4Liter;
		car.setCurrentFuelLevel(100);
		return payment;
	}


	double fill(Car car, int fillValue) {

		double payment = fillValue*price4Liter;

		if ((car.getCurrentFuelLevel()+fillValue)>car.getMaxFuelLevel())
		{
			car.setCurrentFuelLevel(car.getMaxFuelLevel());
		}
		else	{
			car.setCurrentFuelLevel(car.getCurrentFuelLevel()+fillValue);
		}
		return payment;
	}

}