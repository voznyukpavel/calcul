package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.lux.calculation.CalculateMinus;

class CalculateMinusTest {
	private final CalculateMinus calculateminus = new CalculateMinus();

	@Test
	void minus() {
		assertEquals(0, calculateminus.act(1, 1));
	}
	@Test
	void minus1() {
		assertEquals(2, calculateminus.act(4, 2));
	}
	@Test
	void minus2() {
		assertEquals(101000, calculateminus.act(100000, -1000));
	}
}
