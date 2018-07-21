public class Pizzeria {
	public static void main(String[] args) {
		Pizza pizza = Pizza.newBuilder()
			.withDough("cross")
			.withSauce("spicy")
			.withTopping("chicken")
			.build();
		System.out.println(pizza);

		PizzaLombok pizza2 = PizzaLombok.builder()
			.dough("gruby")
			.sauce("czosnek")
			.topping("salami")
			.stwórz_pizze();
		System.out.println(pizza2);
	}
}
