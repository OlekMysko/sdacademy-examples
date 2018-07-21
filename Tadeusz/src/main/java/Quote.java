import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Quote {
	private static final BigDecimal stawkaVat = BigDecimal.valueOf(1.23);

	public static void start() {
		List<BigDecimal> quoteWithoutVAT = new ArrayList<>();
		List<BigDecimal> quoteWithVAT = new ArrayList<>();
		int a = 0;
		while (true) {
			BigDecimal ammount = BigDecimal.valueOf(a);
			quoteWithoutVAT.add(ammount);
			quoteWithVAT.add(ammount.multiply(stawkaVat).setScale(2, RoundingMode.HALF_UP));
			quoteWithVAT.stream().forEach(System.out::println);
			a++;
		}
	}
}
