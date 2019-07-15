package com.lux.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

import com.lux.calculator.logic.Controller;
import com.lux.calculator.model.Model;

public class CalculatorView {

	private static final int WINDOW_HEIGHT = 300;
	private static final int WINDOW_WIDTH = 500;
	private static final String CALC = "Calculator";
	private static final String HISTORY = "History";

	private Display display;
	private Shell shell;

	private CalculatorPanel calculatorPanel;
	private HistoryPanel historyPanel;

	private TabFolder tabFolder;
	private Controller controller;

	public CalculatorView() {
		super();
	}

	private void initUICalculator() {
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText(CALC);
		Composite calcCompoiste = new Composite(tabFolder, SWT.NONE);
		tabItem.setControl(calcCompoiste);
		calculatorPanel = new CalculatorPanel(calcCompoiste, this);
	}

	private void initHistory() {
		TabItem tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText(HISTORY);

		Composite historyComposite = new Composite(tabFolder, SWT.NONE);
		tabItem.setControl(historyComposite);

		historyPanel = new HistoryPanel(historyComposite);
	}

	private void openWindow() {
		shell.pack();
		shell.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	public void setResult(Model model) {
		String arg1 = model.getArg1();
		String arg2 = model.getArg2();
		String actionTitle = model.getActionTitle();
		String errorMessage = controller.isValid(arg1, arg2);
		if (!errorMessage.isEmpty()) {
			showErrorMessage(errorMessage, "Incorect insertion", model.isOnFly());
			return;
		}
		errorMessage = controller.checkDividingByZero(arg2, actionTitle);
		if (!errorMessage.isEmpty()) {
			showErrorMessage(errorMessage, "Dividing by zero", model.isOnFly());
			return;
		}
		String value = controller.callCalculate(arg1, arg2, actionTitle);
		calculatorPanel.setResultValue(value);
		historyPanel.addTableItem(new String[] { arg1, actionTitle, arg2, value });

	}

	private void showErrorMessage(String invalidvariable, String title, boolean onFly) {
		if (!onFly) {
			MessageBox dialog = new MessageBox(shell, SWT.ERROR | SWT.OK);
			dialog.setText(title);
			dialog.setMessage(invalidvariable);
			dialog.open();
		} else {
			calculatorPanel.setResultValue(invalidvariable);
		}
	}

	public void open() {
		controller = new Controller();
		
		initShell();
		
		tabFolder = new TabFolder(shell, SWT.NONE);

		initUICalculator();
		initHistory();
		
		openWindow();
	}

	private void initShell() {
		display = new Display();
		shell = new Shell(display);
		shell.setText(CALC);
		shell.setLayout(new FillLayout());
	}

}