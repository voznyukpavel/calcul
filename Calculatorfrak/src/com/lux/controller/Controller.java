package com.lux.controller;


import com.lux.util.ActionUtils;
import com.lux.util.TextChecker;

public class Controller {

	public String isValid(String arg1, String arg2) {
		boolean result1 = TextChecker.checker(arg1);
		boolean result2 = TextChecker.checker(arg2);
		if (!result1 && !result2) {
			return "In the both arguments arguments" + System.lineSeparator() + " are`nt valid: "
					+ "\n\t the first fild: " + arg1 + "\n\t the second fild: " + arg2;
		} else if (!result1) {
			return "In the first argument\n is`nt valid: " + arg1;
		} else if (!result2) {
			return "In the second argument\n is`nt valid:" + arg2;
		}
		return "";
	}

	public String checkDividingByZero(String text, String actionTitle) {
		if (actionTitle.equals(Action.DIV.getTitle()) && ActionUtils.getDouble(text) == 0) {
			return "Divding by zero is forbidden";
		}
		return "";
	}

	public String callCalculate(String arg1, String arg2,String actionTitle) {
		Action action = ActionUtils.getActionByTitle(actionTitle);
		return action.calcExecute(ActionUtils.getDouble(arg1), ActionUtils.getDouble(arg2))
				+ "";
	}
}
