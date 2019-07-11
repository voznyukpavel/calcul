package com.lux.view.calculatorUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class CalculatorResultUI  extends Composite{

	private static final String RESULT = "Result : ";
	
	private Label resultLabelTitle;
	private static Label resultLabelValue;
	
	public CalculatorResultUI(Composite parent, int style,RowLayout layout) {
		super(parent, style);
		layout= new RowLayout();
		layout.wrap = false;
		setLayout(layout);
		initUI();
	}
	
	private void initUI() {
		resultLabelTitle = new Label(this, SWT.NULL);
		resultLabelTitle.setText(RESULT);

		resultLabelValue = new Label(this, SWT.BORDER | SWT.RIGHT);
		resultLabelValue.setLayoutData(new RowData(240, 20));
	}

	
	public static Label getResultLabelValue() {
		return resultLabelValue;
	}
	
	public static void resizeOutputLableForError(String invalidvariable) {
		resultLabelValue.setAlignment(SWT.LEFT);
		resultLabelValue.setLayoutData(new RowData(240, 60));
		resultLabelValue.setText(invalidvariable);
		resultLabelValue.pack();
	}
}
