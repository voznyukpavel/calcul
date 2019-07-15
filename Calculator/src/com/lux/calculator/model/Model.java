package com.lux.calculator.model;

public class Model {

	private String arg1;
	private String actionTitle;
	private String arg2;
	private boolean onFly;

	public Model(String arg1, String actionTitle, String arg2, boolean onFly) {
		super();
		this.arg1 = arg1;
		this.actionTitle = actionTitle;
		this.arg2 = arg2;
		this.onFly = onFly;
	}

	public String getArg1() {
		return arg1;
	}

	public String getActionTitle() {
		return actionTitle;
	}

	public String getArg2() {
		return arg2;
	}

	public boolean isOnFly() {
		return onFly;
	}

}
