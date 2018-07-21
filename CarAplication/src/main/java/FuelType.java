import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
enum FuelType {
	PB(5),
	Oil(4),
	Electricety(1);

	@Getter
	private final double price4Liter;

}