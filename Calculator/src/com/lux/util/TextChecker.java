package com.lux.util;


public class TextChecker {

	private static final byte ASCII_CODE_DOT = 46;
	private static final byte ASCII_CODE_MINUS = 45;

    private TextChecker() {
    	
    }
	public static boolean checkTextFild(char[] value) {

		boolean process=false;
		boolean dotPresent = false;
		boolean minusPresent=false;
		for (int i = 0; i < value.length; i++) {		
			process=false;
			if ((value[i] == ASCII_CODE_MINUS)) {			
				if (!minusPresent) {
					minusPresent = true;
					process=true;
				}else {
					return false;
				}
			} else if (Character.isDigit(value[i])) {
				System.out.println("2ty");
				process=true;
			} else if (value[i] == ASCII_CODE_DOT) {
				if (!dotPresent) {
					System.out.println("3ty");
					dotPresent = true;
					process=true;
				}
			} 
		}
		return process;
	}

}
