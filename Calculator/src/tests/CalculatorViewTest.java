package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import com.lux.util.TextChecker;

class CalculatorViewTest {

	@Test
	void testcheckTextFildNumbersVsLatersInEnd() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild", (char[].class));
		method.setAccessible(true);

		String input = "454jkjk";
		boolean  requiredOutput = false;

		boolean output = (boolean) method.invoke(null, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	void testcheckTextFildNumbersVsLatersInTheCenter() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild", (char[].class));
		method.setAccessible(true);

		String input = "45tyty45";
		boolean  requiredOutput = false;


		boolean output = (boolean) method.invoke(null, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	void testcheckTextFildNumbersVsLatersInStart() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="jkjk454";
		boolean  requiredOutput = false;


		boolean output = (boolean) method.invoke(null, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	@Test
	void testcheckTextFild1OnlyLaters() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="jkjk";
		boolean  requiredOutput = false;

		boolean output = (boolean) method.invoke(null, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	@Test
	void testcheckTextFildLatersVsNumbersInTheCenter() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="jkjk454klk";
		boolean  requiredOutput = false;


		boolean output = (boolean) method.invoke(null, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	@Test
	void testcheckTextFildOnlyNumbers() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="454";
		boolean  requiredOutput = true;


		boolean output = (boolean) method.invoke(null, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	@Test
	void testcheckTextFildEmpty() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="";
		boolean  requiredOutput = false;


		boolean output = (boolean) method.invoke(null, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	@Test
	void testcheckTextFildOnePoint() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="jkjk454";
		boolean  requiredOutput = false;
		

		boolean output = (boolean) method.invoke(null, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	@Test
	void testcheckTextFildTwoPoints() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="..";
		boolean  requiredOutput = false;
		

		boolean output = (boolean) method.invoke(null, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	@Test
	void testcheckTextFildTwoMinus() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="jkj--k454";
		boolean  requiredOutput = false;
		

		boolean output = (boolean) method.invoke(null, input.toCharArray());
		assertEquals(output, requiredOutput);
	}
	
	@Test
	void testcheckTextFildNumbersVsD() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="454.2D";
		boolean  requiredOutput = false;
		

		boolean output = (boolean) method.invoke(null, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

}
