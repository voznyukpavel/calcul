package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.junit.jupiter.api.Test;

import com.lux.view.CalculatorView;

class CalculatorViewTest {
	private final CalculatorView calculatorview = new CalculatorView();

	@Test
	void testcheckTextFildNumbersVsLatersInEnd() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = CalculatorView.class.getDeclaredMethod("checkTextFild",(char[].class));
		method.setAccessible(true);
		char[] output = (char[]) method.invoke(calculatorview, "454jkjk".toCharArray());
		assertEquals(output,"454".toCharArray());
	}

	void testcheckTextFildNumbersVsLatersInTheCenter() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = CalculatorView.class.getDeclaredMethod("checkTextFild", Text.class);
		method.setAccessible(true);
		Text arg1 = new Text(new Shell(), 0);
		arg1.setText("454jkjk455");
		String output = (String) method.invoke(calculatorview, arg1);
		assertEquals(output, "454");
	}

	void testcheckTextFildNumbersVsLatersInStart() throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = CalculatorView.class.getDeclaredMethod("checkTextFild", Text.class);
		method.setAccessible(true);
		Text arg1 = new Text(new Shell(), 0);
		arg1.setText("jkjk455");
		String output = (String) method.invoke(calculatorview, arg1);
		assertEquals(output, "454");
	}

	@Test
	void testcheckTextFild1OnlyLaters() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = CalculatorView.class.getDeclaredMethod("checkTextFild", Text.class);
		method.setAccessible(true);
		Text arg1 = new Text(new Shell(), 0);
		arg1.setText("jkjk");
		String output = (String) method.invoke(calculatorview, arg1);
		assertEquals(output, "");

	}
	
	@Test
	void testcheckTextFildLatersVsNumbersInTheCenter() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = CalculatorView.class.getDeclaredMethod("checkTextFild", Text.class);
		method.setAccessible(true);
		Text arg1 = new Text(new Shell(), 0);
		arg1.setText("jk88jk");
		String output = (String) method.invoke(calculatorview, arg1);
		assertEquals(output, "88");

	}

	@Test
	void testcheckTextFildOnlyNumbers() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = CalculatorView.class.getDeclaredMethod("checkTextFild", Text.class);
		method.setAccessible(true);
		Text arg1 = new Text(new Shell(), 0);
		arg1.setText("3");
		String output = (String) method.invoke(calculatorview, arg1);
		assertEquals(output, "3");

	}

	@Test
	void testcheckTextFildEmpty() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = CalculatorView.class.getDeclaredMethod("checkTextFild", Text.class);
		method.setAccessible(true);
		Text arg1 = new Text(new Shell(), 0);
		arg1.setText("");
		String output = (String) method.invoke(calculatorview, arg1);
		assertEquals(output, "");

	}

	@Test
	void testcheckTextFildOnePoint() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = CalculatorView.class.getDeclaredMethod("checkTextFild", Text.class);
		method.setAccessible(true);
		Text arg1 = new Text(new Shell(), 0);
		arg1.setText(".");
		String output = (String) method.invoke(calculatorview, arg1);
		assertEquals(output, ".");

	}

	@Test
	void testcheckTextFildTwoPoints() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = CalculatorView.class.getDeclaredMethod("checkTextFild", Text.class);
		method.setAccessible(true);
		Text arg1 = new Text(new Shell(), 0);
		arg1.setText("..");
		String output = (String) method.invoke(calculatorview, arg1);
		assertEquals(output, ".");

	}

	@Test
	void testcheckTextFildTwoMinus() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Method method = CalculatorView.class.getDeclaredMethod("checkTextFild", Text.class);
		method.setAccessible(true);
		Text arg1 = new Text(new Shell(), 0);
		arg1.setText("--");
		String output = (String) method.invoke(calculatorview, arg1);
		assertEquals(output, "-");

	}

}
