package com.lux.view.calculatorUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.lux.view.CalculatorView;

public class CalculatorActionsUI extends Composite{

	private static final String CALCULATE_ON_THE_FLY = "calculate on the fly";
	private static final String CALCULATE = "Calculate";
	
	private static Button checkbox;
	private Button calculateButton;
	private static CalculatorArgumentsUI calculatorArgumentsUI;
	

	public CalculatorActionsUI(Composite parent, int style,GridLayout layout,CalculatorArgumentsUI calculatorArgumentsUI) {
		super(parent, style);
		CalculatorActionsUI.calculatorArgumentsUI=calculatorArgumentsUI;
		setLayout(layout);
		initUI();
		initListeners();
		
	}
	private void initUI(){
		GridData gridDataCheckBox= new GridData();
		gridDataCheckBox.horizontalSpan=2;
		gridDataCheckBox.grabExcessHorizontalSpace=true;
		gridDataCheckBox.grabExcessVerticalSpace=true;
		gridDataCheckBox.horizontalAlignment = GridData.FILL;
		
		checkbox = new Button(this, SWT.CHECK);
		checkbox.setText(CALCULATE_ON_THE_FLY);
		checkbox.setLayoutData(gridDataCheckBox);
		
		GridData gridDataButton= new GridData();
		gridDataButton.grabExcessHorizontalSpace=true;
		gridDataButton.grabExcessVerticalSpace=true;
		gridDataButton.horizontalAlignment = GridData.FILL;
		
		calculateButton = new Button(this, SWT.PUSH);
		calculateButton.setText(CALCULATE);
		calculateButton.setLayoutData(gridDataButton);

	}
	
	private void initListeners() {
	checkbox.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
			if (checkbox.getSelection()) {
				calculateButton.setEnabled(false);
				CalculatorView.setResult(calculatorArgumentsUI.getTextArg1(),calculatorArgumentsUI.getTextArg2(),calculatorArgumentsUI.getCombo());
			} else {
				calculateButton.setEnabled(true);
			}
		}
	});

	calculateButton.addSelectionListener(new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
			CalculatorView.setResult(calculatorArgumentsUI.getTextArg1(),calculatorArgumentsUI.getTextArg2(),calculatorArgumentsUI.getCombo());
		}
	});
	}
	
	public static void onFlychecker(Text textArg1, Text textArg2,Combo combo) {
		if (checkbox.getSelection()) {
			CalculatorView.setResult(calculatorArgumentsUI.getTextArg1(),calculatorArgumentsUI.getTextArg2(),calculatorArgumentsUI.getCombo());
		}
	}
	
	public static Button getCheckbox() {
		return checkbox;
	}
	
}
