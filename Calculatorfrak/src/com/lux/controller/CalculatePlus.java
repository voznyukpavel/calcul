package com.lux.controller;

public class CalculatePlus implements Calculate {

	@Override
	public double act(double a, double b) {
		return a + b;
	}
}
