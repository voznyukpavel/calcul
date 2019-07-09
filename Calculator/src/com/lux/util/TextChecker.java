package com.lux.util;

import org.eclipse.swt.widgets.Text;

public class TextChecker {

	private static final byte ASCII_CODE_DOT = 46;
	private static final byte ASCII_CODE_MINUS = 45;


	public static String checkTextFild(char[] value) {
		char[] temp = new char[value.length];
		int count = 0;
		boolean dotPresent = false;
		for (int i = 0; i < value.length; i++) {
			if (i == 0 && value[i] == ASCII_CODE_MINUS) {
				temp[count] = ASCII_CODE_MINUS;
				count++;
			} else if (Character.isDigit(value[i])) {
				temp[count] = value[i];
				count++;
			} else if (value[i] == ASCII_CODE_DOT) {
				if (!dotPresent) {
					dotPresent = true;
					temp[count] = value[i];
					count++;
				}
			}
		}
		temp = deleteEmtyElements(temp, count);
		return String.valueOf(temp);
	}

	private static char[] deleteEmtyElements(char[] temp, int count) {
		char[] newArray = new char[count];
		int counter = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0) {
				newArray[counter++] = temp[i];
			}
		}
		return newArray;
	}
}
