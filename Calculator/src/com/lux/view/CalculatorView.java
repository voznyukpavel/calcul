package com.lux.view;

import com.lux.calculation.ActionChoser;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import org.eclipse.swt.SWT;

import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.RowData;

public class CalculatorView {

	private static final byte ASCII_CODE_ZERO = 48;
	private static final byte ASCII_CODE_NINE = 57;
	private static final byte ASCII_CODE_DOT = 46;
	private static final byte ASCII_CODE_MINUS = 45;

	private static final String CALC = "Calculator";
	private static final String CALCULATE = "Calculate";
	private static final String RESULT = "Result : ";
	private static final String HISTORY = "History";
	private static final String CALCULATE_ON_THE_FLY = "calculate on the fly";
	private static final String[] ACTIONS = { "+", "-", "*", "/" };

	private Display display;
	private Shell shell;
	private GridLayout gridlayout;
	private RowLayout rowlayout;
	private Composite composite1, composite2, composite3;
	private TabFolder tabfolder;
	private Text text, text1;
	private Button checkbox, calculateButton;
	private Label resultlabel, resultlabel1;
	private Table table;
	private Combo combo;

	public void initUI() {
		display = new Display();
		shell = new Shell(display);
		shell.setSize(350, 320);
		shell.setText(CALC);

		gridlayout = new GridLayout();
		rowlayout = new RowLayout();

		gridlayout.numColumns = 1;
		shell.setLayout(gridlayout);

		rowlayout = new RowLayout();
		rowlayout.wrap = false;

		tabfolder = new TabFolder(shell, SWT.NULL);
		tabfolder.setLayoutData(new GridData(300, 200));
		TabItem tabItem = new TabItem(tabfolder, SWT.NULL);
		tabItem.setText(CALC);

		SashForm sashForm = new SashForm(tabfolder, SWT.VERTICAL);
		tabItem.setControl(sashForm);

		composite1 = new Composite(sashForm, SWT.NONE);
		composite1.setLayout(rowlayout);
		composite2 = new Composite(sashForm, SWT.NONE);
		composite2.setLayout(rowlayout);
		composite3 = new Composite(sashForm, SWT.NONE);
		composite3.setLayout(rowlayout);

		text = new Text(composite1, SWT.BORDER | SWT.RIGHT);
		text.setLayoutData(new RowData(110, 20));

		combo = new Combo(composite1, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setItems(ACTIONS);
		combo.setText(ACTIONS[0]);

		text1 = new Text(composite1, SWT.BORDER | SWT.RIGHT);
		text1.setLayoutData(new RowData(110, 20));

		checkbox = new Button(composite2, SWT.CHECK);
		checkbox.setLayoutData(new RowData(150, 35));
		checkbox.setText(CALCULATE_ON_THE_FLY);

		resultlabel = new Label(composite3, SWT.NULL);
		resultlabel.setText(RESULT);

		resultlabel1 = new Label(composite3, SWT.BORDER | SWT.RIGHT);
		resultlabel1.setLayoutData(new RowData(240, 20));

		calculateButton = new Button(composite2, SWT.PUSH);
		calculateButton.setText(CALCULATE);
		calculateButton.setLayoutData(new RowData(140, 35));

		checkbox.addSelectionListener(checkBoxSelectionAdapter);

		TabItem tabItem1 = new TabItem(tabfolder, SWT.NULL);
		tabItem1.setText(HISTORY);

		SashForm sashForm1 = new SashForm(tabfolder, SWT.VERTICAL);
		tabItem1.setControl(sashForm1);

		table = new Table(sashForm1, SWT.FULL_SELECTION | SWT.BORDER | SWT.SCROLL_LINE);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn column = new TableColumn(table, SWT.CENTER);

		column.setWidth(295);
		column.setText("                                         " + HISTORY);

		calculateButton.addSelectionListener(calculateButtonAdapter);

		text.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				checker(text);
			}
		});
		text1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				checker(text1);
			}
		});
		combo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				onFlychecker();
			}
		});
		shell.setVisible(true);
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		display.dispose();
	}

	private void checker(Text text) {
		try {
			Double.parseDouble(text.getText());

		} catch (NumberFormatException ex) {
			checkTextFild(text);
			onFlychecker();
		}
		try {
			Double.parseDouble(text1.getText());
			onFlychecker();

		} catch (NumberFormatException ex) {
			checkTextFild(text1);
		}
	}

	private void checkTextFild(Text text) {
		char[] value = text.getText().toCharArray();
		char[] temp = new char[value.length];
		int count = 0;
		boolean flag = false;
		for (int i = 0; i < value.length; i++) {
			if (!(value[i] < ASCII_CODE_ZERO || value[i] > ASCII_CODE_NINE)) {
				temp[count] = value[i];
				count++;
			} else if (value[i] == ASCII_CODE_DOT) {
				for (int j = 0; j < value.length; j++) {
					if (!flag && value[j] == ASCII_CODE_DOT) {
						flag = true;
						temp[count] = value[j];
						count++;
						break;
					}
				}
			} else if (value[0] == ASCII_CODE_MINUS) {
				temp[0] = ASCII_CODE_MINUS;
				count++;
			} else {
				continue;
			}
		}
		text.setText(new String(temp));
		text.setSelection(text.getText().length());
		onFlychecker();

	}

	private void onFlychecker() {
		if (checkbox.getSelection()) {

			resultlabel1
					.setText(ActionChoser.action(getDouble(text), getDouble(text1), combo.getSelectionIndex()) + "");
		}
	}

	private double getDouble(Text text) {
		double data = 0;
		try {
			data = Double.parseDouble(text.getText());

		} catch (NumberFormatException ex) {
			data = 0;
		}
		return data;
	}

	private SelectionAdapter calculateButtonAdapter = new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
			resultlabel1
					.setText(ActionChoser.action(getDouble(text), getDouble(text1), combo.getSelectionIndex()) + "");
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[] {
					ActionChoser.action(getDouble(text), getDouble(text1), combo.getSelectionIndex()) + "" });

		}
	};

	private SelectionAdapter checkBoxSelectionAdapter = new SelectionAdapter() {

		public void widgetSelected(SelectionEvent e) {
			if (checkbox.getSelection()) {
				calculateButton.setEnabled(false);
				resultlabel1.setText(
						ActionChoser.action(getDouble(text), getDouble(text1), combo.getSelectionIndex()) + "");
			} else {
				calculateButton.setEnabled(true);

			}
		}
	};

}
