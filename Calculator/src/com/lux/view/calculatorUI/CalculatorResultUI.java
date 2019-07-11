package com.lux.view.calculatorUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class CalculatorResultUI  extends Composite{

	private static final String RESULT = "Result : ";
	
	private Label resultLabelTitle;
	private static Label resultLabelValue;

	
	public CalculatorResultUI(Composite parent, int style,GridLayout layout) {
		super(parent, style);
		setLayout(layout);
		initUI();
	}
	
	private void initUI() {
		resultLabelTitle = new Label(this, SWT.NULL);
		resultLabelTitle.setText(RESULT);
		
		GridData gridDataResult= new GridData();
		gridDataResult.horizontalSpan=2;
		
		
		RowLayout rowLayoutResultValue =new RowLayout();
		RowData rowDataResultValue= new RowData(250,70);
		Composite resultValue= new Composite(this,SWT.NONE);
		
		resultValue.setLayoutData(gridDataResult);
		resultValue.setLayout(rowLayoutResultValue);
		
		resultLabelValue = new Label(resultValue, SWT.BORDER | SWT.RIGHT);
		resultLabelValue.setLayoutData(rowDataResultValue);
	}

	
	public static Label getResultLabelValue() {
		return resultLabelValue;
	}
	
	public static void resizeOutputLableForError(String invalidvariable) {
		resultLabelValue.setAlignment(SWT.LEFT);
		resultLabelValue.setText(invalidvariable);
	}
}
