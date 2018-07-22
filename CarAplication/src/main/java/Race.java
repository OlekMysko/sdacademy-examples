import lombok.Getter;

class Race {

	@Getter
	int fuelLostValue=1;
	@Getter
	int tiresWearIncreaseValue=15;
	@Getter
	int dirtRiseValue=10;



	void race(int lapsNumber, Car car,Pitstop pitstop) {

		for (int i=0;i<lapsNumber;i++){
			threshold(car);
			if (check(car,pitstop)){
				pitstop.pitstop(car);
			};
		}
	}



	void threshold(Car car) {
		car.setCurrentFuelLevel(car.getCurrentFuelLevel()-fuelLostValue);
		car.setTireWearStatus(car.getTireWearStatus()+tiresWearIncreaseValue);
		car.setCleanValue(car.getCleanValue()+dirtRiseValue);
	}

	boolean check(Car car,Pitstop pitstop) {
		return pitstop.fuelCheck(car) ||
			pitstop.wheelCheck(car) ||
			pitstop.cleanCheck(car);
	}



}