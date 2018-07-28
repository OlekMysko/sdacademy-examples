public class Race {

	void race(Car car, int laps, PetrolStation petrolStation) {

		for (int i = 0; i < laps; i++) {
			usage(car);
			if (car.getCurrentCapacity() < car.getMinFuelValueForPitstop()) {
				petrolStation.refuel(car);
			}
			if (car.getCurrentWheelUsage() > car.getMaxWheelUsage()) {
				petrolStation.changeWheel(car);
				if (car.getCurrentCarDirty() > car.getMaxCarDirty()) {
					petrolStation.clean(car);
				}
			}
		}
	}

	void usage(Car car) {
		car.setCurrentCapacity(car.getCurrentCapacity() - car.getFuelConsumptionPerLap());
		car.setCurrentWheelUsage(car.getCurrentWheelUsage() + car.getWheelUsagePerLap());
		car.setCurrentCarDirty(car.getCurrentCarDirty() + car.getDirtyRisePerLap());


	}
}
