package com.lux.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class HistoryPanel {

	private static final String[] TABLE_HEADER = { "first num", "action", "second num", " result " };

	private Shell shell;
	private Table table;

	public HistoryPanel(Composite parent) {
		shell = parent.getShell();
		parent.setLayout(new GridLayout(1, true));
		initUI(parent);
	}

	private void initUI(Composite parent) {

		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = true;
		gridData.verticalAlignment = GridData.FILL;
		gridData.horizontalAlignment = GridData.FILL;

		table = new Table(parent, SWT.BORDER | SWT.V_SCROLL);
		table.setLayoutData(gridData);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		for (int i = 0; i < TABLE_HEADER.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(TABLE_HEADER[i]);
		}
		for (int i = 0; i < TABLE_HEADER.length; i++) {
			table.getColumn(i).pack();
		}

		GridData gridDataClean = new GridData();
		gridDataClean.widthHint = 80;
		gridDataClean.heightHint = 30;
		gridDataClean.horizontalAlignment = GridData.END;

		Button cleanButton = new Button(parent, SWT.PUSH);
		cleanButton.setText("Clean");
		cleanButton.setLayoutData(gridDataClean);
		cleanButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				clearHistory();
			}
		});

	}

	public  void addTableItem(String[] items) {
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(items);
		resizeColumns();
	}

	private  void resizeColumns() {
		for (int i = 0; i < TABLE_HEADER.length; i++) {
			table.getColumn(i).pack();
		}
	}

	private void clearHistory() {
		if (table.getItems().length > 0 && confirmClear()) {
			table.removeAll();
		}
	}

	private boolean confirmClear() {
		MessageBox dialog = new MessageBox(shell, SWT.ICON_WARNING | SWT.OK | SWT.CANCEL);
		dialog.setText("Clean");
		dialog.setMessage("All data will be deleted. Are you shure?");
		int buttonID = dialog.open();
		return buttonID == SWT.OK;
	}

}
