package com.lux.calculator.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

public class UIUtils {

	public static void showDialogMessage(Shell parentShell, String invalidvariable, String title) {
		MessageBox dialog = new MessageBox(parentShell, SWT.ERROR | SWT.OK);
		dialog.setText(title);
		dialog.setMessage(invalidvariable);
		dialog.open();
	}

}
