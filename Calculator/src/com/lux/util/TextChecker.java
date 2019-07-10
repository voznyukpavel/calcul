package com.lux.util;

public class TextChecker {
	private TextChecker() {
		
	}
	private static final byte ASCII_CODE_DOT = 46;
	private static final byte ASCII_CODE_MINUS = 45;

	public static boolean checker(String text) {
		String textValue = text;
		char[] value = textValue.toCharArray();
		return TextChecker.checkTextFild(value);
	}

	public static boolean checkTextFild(char[] value) {
		boolean process = false;
		boolean dotPresent = false;
		for (int i = 0; i < value.length; i++) {		
			process = false;
			if ((i==0&&value[i] == ASCII_CODE_MINUS)) {
					process = true;
			} else
				if (Character.isDigit(value[i])) {
				process = true;
			} else if (value[i] == ASCII_CODE_DOT) {
				if (!dotPresent) {
					dotPresent = true;
					process = true;
				}
			}
		}
		return process;
	}

}
