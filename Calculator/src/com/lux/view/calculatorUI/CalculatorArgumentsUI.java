package com.lux.view.calculatorUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.lux.controller.Action;
import com.lux.util.ActionUtils;

public class CalculatorArgumentsUI extends Composite{
	
	private Text textArg1,textArg2;
	private Combo combo;
	
	public CalculatorArgumentsUI(Composite parent, int style,RowLayout layout) {
		super(parent, style);
		layout= new RowLayout();
		layout.wrap = false;
		setLayout(layout);
		initUI();
		initListeners();
	}
	
	private void initUI() {
		
		RowData rowdata = new RowData();
		rowdata.width = 110;
		rowdata.height = 20;
		
		textArg1 = new Text(this, SWT.BORDER | SWT.RIGHT);
		textArg1.setLayoutData(rowdata);
		
		combo = new Combo(this, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setItems(ActionUtils.getActionsTitles());
		combo.setText(Action.ADD.getTitle());
		
		textArg2 = new Text(this, SWT.BORDER | SWT.RIGHT);
		textArg2.setLayoutData(rowdata);

	}
		
	private void initListeners(){
		textArg1.addModifyListener(listener);
		textArg2.addModifyListener(listener);
		combo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				CalculatorActionsUI.onFlychecker(textArg1,textArg2,combo);
			}
		});
	}
	
	ModifyListener listener = new ModifyListener() {
		@Override
		public void modifyText(ModifyEvent e) {
			CalculatorActionsUI.onFlychecker(textArg1,textArg2,combo);
		}
	};
	
	public Text getTextArg1() {
		return textArg1;
	}
	public void setTextArg1(Text textArg1) {
		this.textArg1 = textArg1;
	}
	public Text getTextArg2() {
		return textArg2;
	}
	public void setTextArg2(Text textArg2) {
		this.textArg2 = textArg2;
	}
	public Combo getCombo() {
		return combo;
	}
	public void setCombo(Combo combo) {
		this.combo = combo;
	}

}
