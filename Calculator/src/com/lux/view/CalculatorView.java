package com.lux.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;

import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

import com.lux.controller.Controller;
import com.lux.view.calculatorUI.CalculatorActionsUI;
import com.lux.view.calculatorUI.CalculatorArgumentsUI;
import com.lux.view.calculatorUI.CalculatorResultUI;
import com.lux.view.historyUI.HistoryUI;

public class CalculatorView {

	private static final String CALC = "Calculator";
	private static final String HISTORY = "History";
	
	private Display display;
	private static Shell shell;
	private RowLayout rowlayout;
	private static CalculatorArgumentsUI calculatorArgumentsUI;
	private TabFolder tabfolder;
	private static Controller controller;
	public CalculatorView() {
		super();	
	}

	private void initUICalculator() {
		controller = new Controller();
		display = new Display();
		shell = new Shell(display);
		shell.setText(CALC);
		shell.setLayout(new FillLayout());

		rowlayout = new RowLayout();
		rowlayout.wrap = false;

		tabfolder = new TabFolder(shell, SWT.NONE);
		TabItem tabItem = new TabItem(tabfolder, SWT.NONE);
		tabItem.setText(CALC);

		SashForm sashForm = new SashForm(tabfolder, SWT.VERTICAL);
		tabItem.setControl(sashForm);

		calculatorArgumentsUI=new CalculatorArgumentsUI(sashForm, SWT.NONE,rowlayout);	
		new CalculatorActionsUI(sashForm, SWT.NONE,rowlayout,calculatorArgumentsUI);
		new CalculatorResultUI(sashForm, SWT.NONE,rowlayout);
	}
	
	private void initHistory() {		
		TabItem tabItem1 = new TabItem(tabfolder, SWT.NULL);
		tabItem1.setText(HISTORY);
		
		SashForm sashForm1 = new SashForm(tabfolder, SWT.HORIZONTAL);
		tabItem1.setControl(sashForm1);	
		
		new HistoryUI(sashForm1, SWT.NONE);
	}

	private void openWindow() {
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	public static void setResult(Text textArg1, Text textArg2,Combo combo) {
		String arg1 = textArg1.getText();
		String arg2 = textArg2.getText();
		String actionTitle =combo.getText();
		String errorMessage = controller.isValid(arg1, arg2);
		if (!errorMessage.isEmpty()) {
			showErrorMessage(errorMessage,"Incorect insertion");
			return;
		}
		errorMessage=controller.checkDividingByZero(arg2, actionTitle);
		if (!errorMessage.isEmpty()) {
			showErrorMessage(errorMessage,"Dividing by zero");
			return;
		}
		String value = controller.callCalculate(arg1,arg2,actionTitle);
		CalculatorResultUI.getResultLabelValue().setText(value);
		HistoryUI.setTableItem(new String[] {arg1, actionTitle, arg2, value });
		HistoryUI.resizeColumns();
	}

	private static void showErrorMessage(String invalidvariable,String title) {
		if (!CalculatorActionsUI.getCheckbox().getSelection()) {
			MessageBox dialog = new MessageBox(shell, SWT.ERROR | SWT.OK);
			dialog.setText(title);
			dialog.setMessage(invalidvariable);
			dialog.open();
		} else {
			CalculatorResultUI.resizeOutputLableForError(invalidvariable);
		}
	}

	public void open() {
		initUICalculator();
		initHistory();
		openWindow();
	}

}