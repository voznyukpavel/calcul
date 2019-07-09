package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

import com.lux.util.TextChecker;

class CalculatorViewTest {
	private final TextChecker textchecker = new TextChecker();

	@Test
	void testcheckTextFildNumbersVsLatersInEnd() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild", (char[].class));
		method.setAccessible(true);

		String input = "454jkjk";
		String requiredOutput = "454";

		String output = (String) method.invoke(textchecker, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	void testcheckTextFildNumbersVsLatersInTheCenter() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild", (char[].class));
		method.setAccessible(true);

		String input = "45tyty45";
		String requiredOutput = "4545";


		String output = (String) method.invoke(textchecker, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	void testcheckTextFildNumbersVsLatersInStart() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="jkjk454";
		String requiredOutput="454";
		

		String output = (String) method.invoke(textchecker, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	@Test
	void testcheckTextFild1OnlyLaters() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="jkjk";
		String requiredOutput="";
		

		String output = (String) method.invoke(textchecker, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	@Test
	void testcheckTextFildLatersVsNumbersInTheCenter() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="jkjk454klk";
		String requiredOutput="454";
		

		String output = (String) method.invoke(textchecker, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	@Test
	void testcheckTextFildOnlyNumbers() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="454";
		String requiredOutput="454";
		

		String output = (String) method.invoke(textchecker, input.toCharArray());
		assertEquals(output, requiredOutput);

	}

	@Test
	void testcheckTextFildEmpty() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="";
		String requiredOutput="";
		

		String output = (String) method.invoke(textchecker, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	@Test
	void testcheckTextFildOnePoint() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="jkjk454";
		String requiredOutput="454";
		

		String output = (String) method.invoke(textchecker, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	@Test
	void testcheckTextFildTwoPoints() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="..";
		String requiredOutput=".";
		
		String output = (String) method.invoke(textchecker, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

	@Test
	void testcheckTextFildTwoMinus() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="--jkjk454";
		String requiredOutput="-454";
		
		String output = (String) method.invoke(textchecker, input.toCharArray());
		assertEquals(output, requiredOutput);
	}
	
	@Test
	void testcheckTextFildNumbersVsD() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = TextChecker.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);	
	
		String input="454.2D";
		String requiredOutput="454.2";
		
		String output = (String) method.invoke(textchecker, input.toCharArray());
		assertEquals(output, requiredOutput);
	}

}
