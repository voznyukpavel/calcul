package com.lux.listeners.data;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ListenersData {
	private Combo combo;
	private Text text;
	private Text text1;
	
	public ListenersData(Combo combo, Text text, Text text1, Label resultlabel1) {

		this.combo = combo;
		this.text = text;
		this.text1 = text1;
		this.resultlabel1 = resultlabel1;
	}

	private Label resultlabel1;

	public Combo getCombo() {
		return combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public Text getText1() {
		return text1;
	}

	public void setText1(Text text1) {
		this.text1 = text1;
	}

	public Label getResultlabel1() {
		return resultlabel1;
	}

	public void setResultlabel1(Label resultlabel1) {
		this.resultlabel1 = resultlabel1;
	}
}
