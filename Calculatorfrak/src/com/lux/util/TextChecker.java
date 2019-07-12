package com.lux.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextChecker {
	private TextChecker() {

	}

	private static final String DOUBLE_REGULAR_EXPRESSION = "[-]?[0-9]+(\\.[0-9]+)?";
	private static final String DOUBLE_REGULAR_EXPRESSION2 = "[-]?[0-9]+(\\.)?";

	public static boolean checker(String text) {
		if (checkTextFild(text, DOUBLE_REGULAR_EXPRESSION2) || checkTextFild(text, DOUBLE_REGULAR_EXPRESSION)) {
			return true;
		} else if (text.length() == 1 && text == "-") {
			return true;
		}
		return false;
	}

	public static boolean checkTextFild(String value, String expresion) {
		Pattern p = Pattern.compile(expresion);
		Matcher m = p.matcher(value);
		if (m.find() && m.group().equals(value))
			return true;
		else
			return false;
	}

	/*
	 * private static final byte ASCII_CODE_DOT = 46; private static final byte
	 * ASCII_CODE_MINUS = 45;
	 */

	/*
	 * public static boolean checker(String text) { // String textValue = text;
	 * //char[] value = textValue.toCharArray(); return
	 * TextChecker.checkTextFild(text); }
	 */

	/*
	 * public static boolean checkTextFild(char[] value) { boolean process = false;
	 * boolean dotPresent = false; for (int i = 0; i < value.length; i++) { process
	 * = false; if ((i==0&&value[i] == ASCII_CODE_MINUS)) { process = true; } else
	 * if (Character.isDigit(value[i])) { process = true; } else if (value[i] ==
	 * ASCII_CODE_DOT) { if (!dotPresent) { dotPresent = true; process = true; } } }
	 * return process; }
	 */
}
