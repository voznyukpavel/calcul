package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lux.controller.CalculateMulty;

class CalculateMultyTest {

	private static CalculateMulty calculatemulty;

	@BeforeAll
	static void init() {
		calculatemulty = new CalculateMulty();
		
	}
	@DisplayName("multy 1 vs 1")
	@Test
	void multy() {
		assertEquals(1, calculatemulty.act(1, 1));
	}
	@DisplayName("groupAssertions")
	@Test
	void groupAssertions() {
	    int[] numbers = {0, 1, 2, 3, -4};
	    assertAll("numbers",
	        () -> assertEquals(numbers[0],  calculatemulty.act(0, 1)),
	        () -> assertEquals(numbers[1],  calculatemulty.act(1, 1)),
	        () -> assertEquals(numbers[2],  calculatemulty.act(1, 2)),
	        () -> assertEquals(numbers[3],  calculatemulty.act(2, 1.5)),
	        () -> assertEquals(numbers[4],  calculatemulty.act(-2, 2))
	        
	    );
	}
}
