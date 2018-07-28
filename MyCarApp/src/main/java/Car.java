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
	private final double wheelUsagePerLap;

	@Getter
	private final double dirtyRisePerLap;

	@Getter
	@Setter
	private double currentCarDirty;

	@Getter
	@Setter
	private double currentWheelUsage;

	@Getter
	private double minFuelValueForPitstop = 5;

	@Getter
	private double maxCarDirty = 95;

	@Getter
	private double maxWheelUsage = 5;


}
