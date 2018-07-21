import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class GasStationTest {

	Car tadeuszCar;
	GasStation shell;
	CarMyjka myjka;
	Vulcanizer wulkanizator;
	@BeforeEach
	void setUp() {
	tadeuszCar = new Car(65,FuelType.PB);
	shell = new GasStation();
	myjka = new CarMyjka();
	wulkanizator = new Vulcanizer();

	}

	@DisplayName("Should calculate the cost for filling the car's tank to full and check is it full")
	@Test
	void test00() {

		//given
		tadeuszCar.setCurrentFuelLevel(10);
		shell.setPrice4Liter(5.0);
		//when
		double valueToPay = shell.fillTofull(tadeuszCar);
		//then
		assertThat(valueToPay).isEqualTo(275);
		assertThat(tadeuszCar.getCurrentFuelLevel()).isEqualTo(100);
	}

	@DisplayName("Should calculate the cost for filling the car's tank to given Value and check is the current " +
		"fuel level correct")
	@Test
	void test01() {

		//given
		tadeuszCar.setCurrentFuelLevel(10);
		shell.setPrice4Liter(5.0);
		int fillValue = 20;
		//when
		double valueToPay = shell.fill(tadeuszCar,fillValue);
		//then
		assertThat(valueToPay).isEqualTo(fillValue*shell.getPrice4Liter());
		assertThat(tadeuszCar.getCurrentFuelLevel()).isEqualTo(30);
	}

	@DisplayName("Should let to choose the fuel and choose and calculate the right fuel price")
	@Test
	void test02() {

		//given
		tadeuszCar.setCurrentFuelLevel(10);
		shell.setPrice4Liter(tadeuszCar.fuelType.getPrice4Liter());
		int fillValue = 20;
		//when
		double valueToPay = shell.fill(tadeuszCar,fillValue);
		//then
		assertThat(valueToPay).isEqualTo(fillValue*shell.getPrice4Liter());
		assertThat(tadeuszCar.getCurrentFuelLevel()).isEqualTo(30);
	}
	@DisplayName("Should let to clean car")
	@Test
	void test03() {

		//given
		tadeuszCar.setCleanValue(20);
		//when
		double valueToPay= myjka.cleanTheCar(tadeuszCar);
		//then
		assertThat(valueToPay).isEqualTo(myjka.getCleaningPrice());
		assertThat(tadeuszCar.getCleanValue()).isEqualTo(100);
	}

	@DisplayName("Should let to change tires")
	@Test
	void test04() {

		//given
		tadeuszCar.setTireWearStatus(80);
		//when
		double valueToPay= wulkanizator.changeTires(tadeuszCar);
		//then
		assertThat(valueToPay).isEqualTo(wulkanizator.getChangingTiresPrice());
		assertThat(tadeuszCar.getTireWearStatus()).isEqualTo(0);
	}

	@DisplayName("Should let to ride 100 laps race and check fuel status & tire status & filth status ")
	@Test
	void test05() {

		//given
		Race race = new Race();
		int lapsNumber = 100;
		//when
		race.race(lapsNumber,tadeuszCar,shell,wulkanizator,myjka);
		//then
		assertThat(race.check(tadeuszCar)).isTrue();

	}
	@DisplayName("Should let to ride 100 laps race and if needed get pitstop")
	@Test
	void test06() {

		//given
		Pitstop pitstop = new Pitstop(shell,wulkanizator,myjka);
		Race race = new Race();
		int lapsNumber = 100;
		//when
		race.race(lapsNumber,tadeuszCar);
		//then
		assertThat(race.check(tadeuszCar)).isTrue();

	}

}
