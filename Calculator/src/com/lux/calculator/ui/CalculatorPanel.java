package com.lux.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.lux.calculator.logic.Action;
import com.lux.calculator.model.Model;

public class CalculatorPanel {

	private static final String CALCULATE_ON_THE_FLY = "calculate on the fly";
	private static final String CALCULATE = "Calculate";
	private static final String RESULT = "Result:";

	private CalculatorView calculatorView;
	private Text textArg1, textArg2;
	private Combo combo;
	private Button checkbox;
	private Button calculateButton;
	private StyledText resultText;

	public CalculatorPanel(Composite parent, CalculatorView calculatorView) {
		parent.setLayout(new GridLayout(3, true));
		this.calculatorView = calculatorView;
		initUI(parent);
		initListeners();
	}

	private void initUI(Composite parent) {

		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = false;
		gridData.horizontalAlignment = GridData.FILL;

		textArg1 = new Text(parent, SWT.BORDER | SWT.RIGHT);
		textArg1.setLayoutData(gridData);

		combo = new Combo(parent, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setItems(new String[] { Action.ADD.getTitle(), Action.SUB.getTitle(), Action.MULT.getTitle(),
				Action.DIV.getTitle() });
		combo.setText(Action.ADD.getTitle());
		combo.setLayoutData(gridData);

		textArg2 = new Text(parent, SWT.BORDER | SWT.RIGHT);
		textArg2.setLayoutData(gridData);

		GridData gridDataCheckBox = new GridData();
		gridDataCheckBox.horizontalSpan = 2;

		checkbox = new Button(parent, SWT.CHECK);
		checkbox.setText(CALCULATE_ON_THE_FLY);
		checkbox.setLayoutData(gridDataCheckBox);

		calculateButton = new Button(parent, SWT.PUSH);
		calculateButton.setText(CALCULATE);
		calculateButton.setLayoutData(new GridData(SWT.END, SWT.CENTER, false, false));

		initResultComposite(parent);

	}

	private void initResultComposite(Composite parent) {
		Composite resultComposite = new Composite(parent, SWT.NONE);
		resultComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		resultComposite.setLayout(gridLayout);

		GridData gridDataLabel = new GridData();
		gridDataLabel.verticalAlignment = SWT.BEGINNING;
		gridDataLabel.horizontalAlignment = SWT.BEGINNING;

		Label resultLabelTitle = new Label(resultComposite, SWT.NULL);
		resultLabelTitle.setText(RESULT);
		resultLabelTitle.setLayoutData(gridDataLabel);

		GridData gridDataResult = new GridData();
		gridDataResult.grabExcessHorizontalSpace = true;
		gridDataResult.grabExcessVerticalSpace = true;
		gridDataResult.verticalAlignment = GridData.FILL;
		gridDataResult.horizontalAlignment = GridData.FILL;

		resultText = new StyledText(resultComposite, SWT.BOLD | SWT.BORDER | SWT.RIGHT);
		resultText.setOrientation(SWT.RIGHT);
		resultText.setEditable(false);
		resultText.setLayoutData(gridDataResult);
	}

	private void onFlychecker() {
		if (checkbox.getSelection()) {
			calculatorView.setResult(getModel());
		}
	}

	private class CalculateButtonSelectionListener extends SelectionAdapter {
		public void widgetSelected(SelectionEvent e) {
			calculatorView.setResult(getModel());
		}
	}

	private class CheckBoxButtonSelectionListener extends SelectionAdapter {
		public void widgetSelected(SelectionEvent e) {
			calculateButton.setEnabled(!checkbox.getSelection());
			onFlychecker();
		}
	}

	private void initListeners() {
		TextModifyListener textModifyListener = new TextModifyListener();
		textArg1.addModifyListener(textModifyListener);
		textArg2.addModifyListener(textModifyListener);
		combo.addSelectionListener(new CheckBoxSelectionListener());
		checkbox.addSelectionListener(new CheckBoxButtonSelectionListener());
		calculateButton.addSelectionListener(new CalculateButtonSelectionListener());
	}

	private class TextModifyListener implements ModifyListener {
		@Override
		public void modifyText(ModifyEvent e) {
			onFlychecker();
		}
	}

	private class CheckBoxSelectionListener extends SelectionAdapter {
		@Override
		public void widgetSelected(SelectionEvent e) {
			onFlychecker();
		}
	}

	public void setResultValue(String value) {
		resultText.setText(value);
	}

	private Model getModel() {
		return new Model(textArg1.getText(), combo.getText(), textArg2.getText(), checkbox.getSelection());
	}

}