package com.lux.calculation;

public class ActionChoser {

	private final static int PLUS = 0;
	private final static int MINUS = 1;
	private final static int MULTY = 2;

	public static double action(double first, double second, int index) {
		Calculate calc;
		switch (index) {
		case PLUS:
			calc = new CalculatePlus();
			break;
		case MINUS:
			calc = new CalculateMinus();
			break;
		case MULTY:
			calc = new CalculateMulty();
			break;
		default:
			calc = new CalculateDiv();
			break;
		}
		return calc.act(first, second);

	}
}
