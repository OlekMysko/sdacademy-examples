import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class Pitstop {

	@NonNull
	GasStation gasStation;
	@NonNull
	Vulcanizer wulkanizator;
	@NonNull
	CarMyjka myjka;

	int fuelThreshold = 15;
	int cleanThreshold = 10;
	int tiresThreshold = 90;




	boolean fuelCheck(Car car){
		return car.getCurrentFuelLevel()<fuelThreshold;
	}

	boolean wheelCheck(Car car) {
		return car.getTireWearStatus()>tiresThreshold;
	}

	boolean cleanCheck(Car car) {
		return car.getCleanValue()>cleanThreshold;
	}

	public void pitstop(Car car) {
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
}
