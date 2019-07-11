package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.lux.util.TextChecker;

class TextCheckerTest {

	@Test
	void testcheckTextFildNumbersVsLatersInEnd() {
		String input = "454jkjk";
		boolean requiredOutput = false;
		assertEquals(requiredOutput, TextChecker.checker(input));
	}

	@Test
	void testcheckTextFildNumbersVsLatersInTheCenter()  {
		String input = "454jkjk745";
		boolean requiredOutput = false;
		assertEquals(requiredOutput, TextChecker.checker(input));
	}

	@Test void testcheckTextFildNumbersVsLatersInStart() {
		String input = "jkjk745";
		boolean requiredOutput = false;
		assertEquals(requiredOutput, TextChecker.checker(input));
	}

	@Test void testcheckTextFild1OnlyLaters() {
		String input = "jkjk";
		boolean requiredOutput = false;
		assertEquals(requiredOutput, TextChecker.checker(input));
	}

	@Test void testcheckTextFildLatersVsNumbersInTheCenter() {
		String input = "jkjk745jh";
		boolean requiredOutput = false;
		assertEquals(requiredOutput, TextChecker.checker(input));
	}

	@Test void testcheckTextFildOnlyNumbers(){
		String input = "745";
		boolean requiredOutput = true;
		assertEquals(requiredOutput, TextChecker.checker(input));
	}

	@Test void testcheckTextFildEmpty() {
		String input = "";
		boolean requiredOutput = false;
		assertEquals(requiredOutput, TextChecker.checker(input));
	}

	@Test void testcheckTextFildOnePoint() {
		String input = ".";
		boolean requiredOutput = false;
		assertEquals(requiredOutput, TextChecker.checker(input));
	}

	@Test void testcheckTextFildTwoPoints(){
		String input = "..";
		boolean requiredOutput = false;
		assertEquals(requiredOutput, TextChecker.checker(input));
	}

	@Test void testcheckTextFildTwoMinus(){
		String input = "--858";
		boolean requiredOutput = false;
		assertEquals(requiredOutput, TextChecker.checker(input));
	}

	@Test void testcheckTextFildNumbersVsD() {
		String input = "858D";
		boolean requiredOutput = false;
		assertEquals(requiredOutput, TextChecker.checker(input));
	}

}
