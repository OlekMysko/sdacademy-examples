import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
class Car {

	@Setter
	@Getter
	int currentFuelLevel;

	@Getter
	final int maxFuelLevel;

	@Setter
	final FuelType fuelType;

	@Setter
	@Getter
	int cleanValue;

	@Setter
	@Getter
	int TireWearStatus;

}

