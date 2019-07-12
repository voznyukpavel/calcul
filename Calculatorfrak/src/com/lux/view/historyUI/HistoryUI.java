package com.lux.view.historyUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class HistoryUI extends Composite{

	private static Table table;
	private static final String[] TABLE_HEADER = { "first num", "action", "second num", " result " };
	
	public HistoryUI(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout());
		initUI();
	}
	
	private void initUI() {
		table = new Table(this, SWT.BORDER | SWT.V_SCROLL);
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
	
	public static void setTableItem(String [] items) {
		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(items);
	}
	
	public static void resizeColumns() {
		for (int i = 0; i < TABLE_HEADER.length; i++) {
			table.getColumn(i).pack();
		}
	}
}
