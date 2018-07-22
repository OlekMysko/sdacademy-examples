public class Race {

	void race(Car car, int laps, PetrolStation petrolStation) {

		for (int i = 1; i < 101; i++) {
			car.setCurrentCapacity(car.getCurrentCapacity() - car.getFuelConsumptionPerLap());
			if (car.getCurrentCapacity() < car.getMinFuelValueForPitstop()) {
				petrolStation.refuel(car);
			}
		}
	}
}
