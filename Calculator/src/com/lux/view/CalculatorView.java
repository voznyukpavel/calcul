package com.lux.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import com.lux.calculation.Action;
import com.lux.util.GetDataAndAction;
import com.lux.util.TextChecker;

public class CalculatorView {

	private static final String CALC = "Calculator";
	private static final String CALCULATE = "Calculate";
	private static final String RESULT = "Result : ";
	private static final String HISTORY = "History";
	private static final String CALCULATE_ON_THE_FLY = "calculate on the fly";

	private Display display;
	private Shell shell;
	private GridLayout gridlayout;
	private RowLayout rowlayout;
	private Composite composite1, composite2, composite3;
	private TabFolder tabfolder;
	private Text textArg1, textArg2;
	private Button checkbox, calculateButton;
	private Label resultLabelTitle, resultLabelValue;
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

		textArg1 = new Text(composite1, SWT.BORDER | SWT.RIGHT);
		textArg1.setLayoutData(new RowData(110, 20));

		combo = new Combo(composite1, SWT.DROP_DOWN | SWT.READ_ONLY);

		combo.setItems(GetDataAndAction.getActionsTitles());
		combo.setText(Action.ADD.getTitle());

		textArg2 = new Text(composite1, SWT.BORDER | SWT.RIGHT);
		textArg2.setLayoutData(new RowData(110, 20));

		checkbox = new Button(composite2, SWT.CHECK);
		checkbox.setLayoutData(new RowData(150, 35));
		checkbox.setText(CALCULATE_ON_THE_FLY);

		resultLabelTitle = new Label(composite3, SWT.NULL);
		resultLabelTitle.setText(RESULT);

		resultLabelValue = new Label(composite3, SWT.BORDER | SWT.RIGHT);
		resultLabelValue.setLayoutData(new RowData(240, 20));

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

		textArg1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				checker(textArg1);
			}
		});

		textArg2.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {

				checker(textArg2);
			}
		});

		combo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				onFlychecker();
			}
		});

	}

	private boolean checker(Text text) {

		String textValue = text.getText();
		char[] value = textValue.toCharArray();
		String checked = TextChecker.checkTextFild(value);
		text.setText(checked);
		text.setSelection(text.getText().length());
		onFlychecker();
		return true;
	}

	private void onFlychecker() {
		if (checkbox.getSelection()) {
			resultLabelValue.setText(callCalculate());
		}
	}

	private String callCalculate() {
		Action action = GetDataAndAction.getActionByTitle(combo.getText());
		return action.calcExecute(GetDataAndAction.getDouble(textArg1.getText()),
				GetDataAndAction.getDouble(textArg2.getText())) + "";
	}

	private SelectionAdapter calculateButtonAdapter = new SelectionAdapter() {
		public void widgetSelected(SelectionEvent e) {
			String value = callCalculate();
			resultLabelValue.setText(value);
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[] { value });
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