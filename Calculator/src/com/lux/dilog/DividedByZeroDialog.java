package com.lux.dilog;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

import com.lux.util.GetDataAndAction;
import com.lux.calculation.Action;

public class DividedByZeroDialog {

	public DividedByZeroDialog(Shell shell,String text,String action) {
		checkDividingByZero(shell,text, action);		
	}
	
	private void checkDividingByZero(Shell shell,String text,String action) {
		if (GetDataAndAction.getDouble(text)==0 && action.equals(Action.DIV.getTitle())) {
			System.out.println(GetDataAndAction.getDouble(text));
			MessageBox dialog = new MessageBox(shell, SWT.ERROR | SWT.OK);
			dialog.setText("Incorect insertion");
			dialog.setMessage("Divding by zero is forbidden");
			dialog.open();
		}
	}
}
