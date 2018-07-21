import lombok.Builder;
import lombok.ToString;

@Builder(buildMethodName = "stwórz_pizze")
@ToString
public class PizzaLombok {
	private String dough = "";
	private String sauce = "";
	private String topping = "";
}

