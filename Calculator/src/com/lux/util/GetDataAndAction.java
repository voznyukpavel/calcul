package com.lux.util;


import com.lux.calculation.Action;

public class GetDataAndAction {
	
	public static Action getActionByTitle(String title) {
		Action[] actions = Action.values();
		for (int i = 0; i < actions.length; i++) {
			Action action = actions[i];
			if (action.getTitle().equals(title)) {
				return action;
			}
		}
		throw new RuntimeException("Action Exception");
	}
	
	public static String[] getActionsTitles() {
		Action[] actions = Action.values();
		String[] result = new String[actions.length];
		for (int i = 0; i < actions.length; i++) {
			Action action = actions[i];
			result[i] = action.getTitle();
		}
		return result;
	}
	

	public static double getDouble(String text) {
		double data = 0;
		try {
			data = Double.parseDouble(text);
		} catch (NumberFormatException ex) {
			data = 0;
		}
		return data;
	}

	
}
