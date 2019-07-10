package com.lux.view;

import org.eclipse.swt.SWT;

import org.eclipse.swt.custom.SashForm;

import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FillLayout;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.lux.calculation.Action;
import com.lux.dilog.DividedByZeroDialog;
import com.lux.util.GetDataAndAction;
import com.lux.util.TextChecker;

public class CalculatorView {

	private static final String CALC = "Calculator";
	private static final String CALCULATE = "Calculate";
	private static final String RESULT = "Result : ";
	private static final String HISTORY = "History";
	private static final String CALCULATE_ON_THE_FLY = "calculate on the fly";
	private static final String[] TABLE_HEADER = { "first num", "action", "second num", " result " };

	private Display display;
	private Shell shell;
	private RowLayout rowlayout;
	private Composite arguments, actions, result;
	private TabFolder tabfolder;
	private Text textArg1, textArg2;
	private Button checkbox, calculateButton;
	private Label resultLabelTitle, resultLabelValue;
	private Table table;
	private Combo combo;

	public void initUICalculator() {
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

		arguments = new Composite(sashForm, SWT.NONE);
		arguments.setLayout(rowlayout);
		actions = new Composite(sashForm, SWT.NONE);
		actions.setLayout(rowlayout);
		result = new Composite(sashForm, SWT.NONE);
		result.setLayout(rowlayout);

		RowData rowdata = new RowData();
		rowdata.width = 110;
		rowdata.height = 20;

		textArg1 = new Text(arguments, SWT.BORDER | SWT.RIGHT);

		textArg1.setLayoutData(rowdata);

		combo = new Combo(arguments, SWT.DROP_DOWN | SWT.READ_ONLY);

		combo.setItems(GetDataAndAction.getActionsTitles());
		combo.setText(Action.ADD.getTitle());

		textArg2 = new Text(arguments, SWT.BORDER | SWT.RIGHT);

		textArg2.setLayoutData(rowdata);

		checkbox = new Button(actions, SWT.CHECK);
		checkbox.setLayoutData(new RowData(150, 70));
		checkbox.setText(CALCULATE_ON_THE_FLY);

		resultLabelTitle = new Label(result, SWT.NULL);
		resultLabelTitle.setText(RESULT);

		resultLabelValue = new Label(result, SWT.BORDER | SWT.RIGHT);
		resultLabelValue.setLayoutData(new RowData(240, 20));

		calculateButton = new Button(actions, SWT.PUSH);
		calculateButton.setText(CALCULATE);
		calculateButton.setLayoutData(new RowData(140, 35));

		checkbox.addSelectionListener(checkBoxSelectionAdapter);

		calculateButton.addSelectionListener(calculateButtonAdapter);

		textArg1.addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				onFlychecker();
			}

			public void keyPressed(KeyEvent e) {
				if (!checker(textArg1.getText() + String.valueOf(e.character)) && e.keyCode != SWT.BS
						&& e.keyCode != SWT.ARROW_LEFT && e.keyCode != SWT.ARROW_RIGHT) {
					e.doit = false;
				}
				textArg1.getCaretPosition();
				onFlychecker();
			}

		});

		textArg2.addKeyListener(new KeyAdapter() {

			public void keyReleased(KeyEvent e) {
				new DividedByZeroDialog(shell, textArg2.getText(), combo.getText());
				onFlychecker();
			}

			public void keyPressed(KeyEvent e) {
				if (!checker(textArg2.getText() + String.valueOf(e.character)) && e.keyCode != SWT.BS
						&& e.keyCode != SWT.ARROW_LEFT && e.keyCode != SWT.ARROW_RIGHT) {
					e.doit = false;
				}
				textArg2.getCaretPosition();
			}
		});

		combo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				new DividedByZeroDialog(shell, textArg2.getText(), combo.getText());
				onFlychecker();
			}
		});
	}

	private boolean checker(String text) {
		String textValue = text;
		char[] value = textValue.toCharArray();
		return TextChecker.checkTextFild(value);
	}

	private void onFlychecker() {
		if (checkbox.getSelection()) {
			setResult();
		}
	}

	private void setResult() {
		String value = callCalculate();
		resultLabelValue.setText(value);
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(new String[] {textArg1.getText(),combo.getText() ,textArg2.getText() ,value });
		 resizeColumns();
	}
	private void resizeColumns() {
		for (int i = 0; i < TABLE_HEADER.length; i++) {			
			table.getColumn(i).pack();
		}
	}

	private String callCalculate() {
		Action action = GetDataAndAction.getActionByTitle(combo.getText());
		return action.calcExecute(GetDataAndAction.getDouble(textArg1.getText()),
				GetDataAndAction.getDouble(textArg2.getText())) + "";
	}

	private SelectionAdapter calculateButtonAdapter = new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
			new DividedByZeroDialog(shell, textArg2.getText(), combo.getText());
			setResult();
		}
	};

	private SelectionAdapter checkBoxSelectionAdapter = new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
			if (checkbox.getSelection()) {
				calculateButton.setEnabled(false);
				resultLabelValue.setText(callCalculate());
			} else {
				calculateButton.setEnabled(true);
			}
		}
	};

	public void initHistory() {
		TabItem tabItem1 = new TabItem(tabfolder, SWT.NULL);
		tabItem1.setText(HISTORY);
		SashForm sashForm1 = new SashForm(tabfolder, SWT.HORIZONTAL);
		tabItem1.setControl(sashForm1);
	    table = new Table(sashForm1, SWT.BORDER | SWT.V_SCROLL);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		for (int i = 0; i < TABLE_HEADER.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(TABLE_HEADER[i]);		
		}

		for (int i = 0; i < TABLE_HEADER.length; i++) {
			table.getColumn(i).pack();
		}

	}

	public void drawWindow() {
		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}
}