package pl.sdacademy.hr;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HrManagerTest {

	private HrManager hrManager;

	@BeforeEach
	void setup() {
		hrManager = new HrManager();
	}

	@DisplayName("should create non-null new allEmployees when is given first name, last name and date of birth ")
	@Test
	void test0() {
		//given
		String firstName = "Adam";
		String lastName = "Miauczyński";
		String dateOfBirth = "01-12-1960";

		//when
		Employee employee = hrManager.create(firstName, lastName, dateOfBirth);

		//then
		assertThat(employee).isNotNull();
	}

	@DisplayName("should create a new allEmployees with ALL fields: first name, last name and date of birth ")
	@Test
	void test1() {
		//given
		String firstName = "Adam";
		String lastName = "Miauczyński";
		String dateOfBirth = "01-12-1960";

		//when
		Employee employee = hrManager.create(firstName, lastName, dateOfBirth);

		//then
		assertThat(employee.getFirstName()).isEqualTo(firstName);
		assertThat(employee.getLastName()).isEqualTo(lastName);
		assertThat(employee.getDateOfBirth()).isEqualTo(dateOfBirth);
	}

	@DisplayName("Should check if new Employee is added to the database")
	@Test
	void test2() {
		//given
		String firstName = "Adam";
		String lastName = "Miauczyński";
		String dateOfBirth = "01-12-1960";
		Employee newEmployee = hrManager.create(firstName, lastName, dateOfBirth);
		//when
		List<Employee> allEmployees = hrManager.findAll();

		//then
		assertThat(allEmployees).containsOnly(newEmployee);
	}

	@DisplayName("Should check if two new Employees are added to the database")
	@Test
	void test3() {
		//given

		Employee adam = hrManager.create("Adam", "Miauczyński", "01-12-1960");
		Employee jurgen = hrManager.create("Jurgen", "Muller", "13-12-1666");
		//when
		List<Employee> allEmployees = hrManager.findAll();

		//then
		assertThat(allEmployees).containsOnly(adam, jurgen);
	}

	@DisplayName("Should find single employee with given last name")
	@Test
	void test4() {
		//given
		Employee adam = hrManager.create("Adam", "Miauczyński", "01-12-1960");
		Employee jurgen = hrManager.create("Jurgen", "Muller", "13-12-1666");

		//when
		List<Employee> foundEmployees = hrManager.searchByLastName("Miauczyński");

		//then
		assertThat(foundEmployees).containsOnly(adam);
	}

	@DisplayName("Should find every employee with given last name")
	@Test
	void test5() {
		//given
		Employee adam = hrManager.create("Adam", "Miauczyński", "01-12-1960");
		Employee stefan = hrManager.create("Stefan", "Miauczyński", "01-12-1960");
		Employee jurgen = hrManager.create("Jurgen", "Muller", "13-12-1666");
		//when

		List<Employee> foundEmployees = hrManager.searchByLastName("Miauczyński");
		//then
		assertThat(foundEmployees).containsOnly(adam, stefan);
	}

	@DisplayName("Should find no employee when there is no employee with given last name")
	@Test
	void test6() {
		//given
		Employee adam = hrManager.create("Adam", "Miauczyński", "01-12-1960");
		Employee stefan = hrManager.create("Stefan", "Miauczyński", "01-12-1960");
		Employee jurgen = hrManager.create("Jurgen", "Muller", "13-12-1666");
		//when

		List<Employee> foundEmployees = hrManager.searchByLastName("Nowak");
		//then
		assertThat(foundEmployees).isEmpty();
	}

	@DisplayName("Should find two employees when their first name matches given search phrase")
	@Test
	void test7() {
		//given
		Employee adam = hrManager.create("Adam", "Miauczyński", "01-12-1960");
		Employee jurgenMuller = hrManager.create("Jurgen", "Muller", "13-12-1666");
		Employee jurgenBlitz = hrManager.create("Jurgen", "Blitz", "13-12-1999");

		//when
		List<Employee> foundEmployees = hrManager.searchByPhrase("Jurgen");

		//then
		assertThat(foundEmployees).containsOnly(jurgenMuller, jurgenBlitz);
	}

	@DisplayName("Should find two employees when their last name matches given search phrase")
	@Test
	void test8() {
		//given
		Employee adam = hrManager.create("Adam", "Miauczyński", "01-12-1960");
		Employee stefan = hrManager.create("Stefan", "Miauczyński", "13-12-1666");
		Employee jurgenBlitz = hrManager.create("Jurgen", "Blitz", "13-12-1999");

		//when
		List<Employee> foundEmployees = hrManager.searchByPhrase("Miauczyński");

		//then
		assertThat(foundEmployees).containsOnly(adam,stefan);
	}
	@DisplayName("Should find two employees when their date of birth matches given search phrase")
	@Test
	void test9() {
		//given
		Employee adam = hrManager.create("Adam", "Miauczyński", "01-12-1960");
		Employee stefan = hrManager.create("Stefan", "Miauczyński", "13-12-1666");
		Employee jurgenBlitz = hrManager.create("Jurgen", "Blitz", "13-12-1666");

		//when
		List<Employee> foundEmployees = hrManager.searchByPhrase("13-12-1666");

		//then
		assertThat(foundEmployees).containsOnly(jurgenBlitz,stefan);
	}

}