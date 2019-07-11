package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lux.controller.CalculateDiv;

class CalculateDivTest {

	private static CalculateDiv calculateDiv;

	@BeforeAll
	static void init() {
		calculateDiv = new CalculateDiv();
	}

	@DisplayName("multy 1 vs 1")
	@Test
	void divByZero() {
		assertEquals(Double.NaN, calculateDiv.act(1, 0));
	}

	@DisplayName("groupAssertions")
	@Test
	void groupAssertions() {
		double[] numbers = { 0, 1, 0.5, 3, -4 };
		assertAll("numbers", () -> assertEquals(numbers[0], calculateDiv.act(0, 1)),
				() -> assertEquals(numbers[1], calculateDiv.act(1, 1)),
				() -> assertEquals(numbers[2], calculateDiv.act(1, 2)),
				() -> assertEquals(numbers[3], calculateDiv.act(4.5, 1.5)),
				() -> assertEquals(numbers[4], calculateDiv.act(-8, 2))

		);
	}

}
