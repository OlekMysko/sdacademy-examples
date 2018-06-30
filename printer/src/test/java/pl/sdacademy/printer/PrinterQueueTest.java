package pl.sdacademy.printer;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.assertThat;


public class PrinterQueueTest {

	@DisplayName("should print text")
	@Test
	public void test00() {
		//given
		Printer printer = new Printer();
		Document document = new Document(false);
		//when

		printer.print(document);
		//then
		assertThat(document.isPrinted()).isTrue();
	}
}
