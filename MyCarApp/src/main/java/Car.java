import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class Car {

	@Getter
	private final double fullCapacity;

	@Getter
	@Setter
	private double currentCapacity;

	@Getter
	private final FuelType fuelType;

	@Getter
	private final double fuelConsumptionPerLap;

	@Getter
	@Setter
	private double currentCarDirty;

	@Getter
	@Setter
	private double currentWheelUsage;

	@Getter
	private double minFuelValueForPitstop = 5;


}
