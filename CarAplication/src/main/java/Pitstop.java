public class Pitstop {

	public Pitstop(Race race,GasStation shell, Vulcanizer wulkanizator, CarMyjka myjka) {


	}

	void pitstop(Car car, GasStation gasStation, Vulcanizer wulkanizator, CarMyjka myjka) {

		if (fuelCheck(car)){
			gasStation.fillTofull(car);
		}
		if (wheelCheck(car)){
			wulkanizator.changeTires(car);
		}
		if (cleanCheck(car)){
			myjka.cleanTheCar(car);
		}
	}


	boolean fuelCheck(Car car) {
		return car.getCurrentFuelLevel()<race.
	}

	 boolean wheelCheck(Car car) {
	}

	boolean cleanCheck(Car car) {
	}
}
