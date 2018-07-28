import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class PetrolStationTest {

	Car car = new Car(60, FuelType.PB, 10,1,8);
	PetrolStation shell = new PetrolStation();
	Map<FuelType, Double> fuelPrice = new HashMap<>();
	Race race = new Race();
	@BeforeEach
	void setUp() {
		fuelPrice.put(FuelType.PB, 5.08);
		fuelPrice.put(FuelType.OIL, 5.02);
		fuelPrice.put(FuelType.ELECTRICITY, 1.03);
		shell.setFuelPrice(fuelPrice);

	}

	@DisplayName("should race how much should user pay for refuel and should allow to chose fuel")
	@Test
	void test00() {
		//given
		car.setCurrentCapacity(5.5);
		//when
		double payment = shell.refuel(car);
		//then
		org.assertj.core.api.Assertions.assertThat(payment).isEqualTo((car.getFullCapacity() - 5.5) * shell
			.getFuelPrice().get(car.getFuelType()));
	}

	@DisplayName("should race how much should user pay for fill ")
	@Test
	void test01() {
		//given
		int fillValue = 20;
		car.setCurrentCapacity(5.5);
		//when
		double payment = shell.fill(car, fillValue);
		//then
		Assertions.assertThat(payment).isEqualTo(fillValue * shell.getFuelPrice().get(car.getFuelType()));
	}

	@DisplayName("should race how much should user pay for clean")
	@Test
	void test02() {
		//given
		car.setCurrentCarDirty(20);
		//when
		double payment = shell.clean(car);

		//then
		Assertions.assertThat(payment).isEqualTo(20);
	}

	@DisplayName("should race how much should user pay for clean")
	@Test
	void test03() {
		//given
		car.setCurrentWheelUsage(80);
		//when
		double payment = shell.changeWheel(car);

		//then
		Assertions.assertThat(payment).isEqualTo(1000);
	}

	@DisplayName("qqq")
	@Test
	void test04() {
		//given

		//when
		race.race(car,100,shell);
		//then
		Assertions.assertThat(race.equals(true));
	}
}
