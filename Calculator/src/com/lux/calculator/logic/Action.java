package com.lux.calculator.logic;

public enum Action {

	ADD("+", new CalculatePlus()), 
	SUB("-", new CalculateMinus()), 
	MULT("*", new CalculateMulty()),
	DIV("/", new CalculateDiv());

	private String titile;
	private Calculate calc;

	private Action(String title, Calculate calc) {
		this.titile = title;
		this.calc = calc;
	}

	public String getTitle() {
		return titile;
	}

	public Calculate getAction() {
		return calc;
	}

	public static Action getActionByTitle(String title) {
		Action[] actions = values();
		for (int i = 0; i < actions.length; i++) {
			Action action = actions[i];
			if (action.getTitle().equals(title)) {
				return action;
			}
		}
		throw new RuntimeException("Action Exception");
	}

	public double calcExecute(double arg1, double arg2) {
		return calc.act(arg1, arg2);
	}

}
