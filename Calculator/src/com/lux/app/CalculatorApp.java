package com.lux.app;

import com.lux.view.CalculatorView;

public class CalculatorApp {

	private static CalculatorView calculatorview;

	public static void main(String[] args) {
		calculatorview=new CalculatorView();
		calculatorview.initUI();
		calculatorview.drawWindow();
	}
}