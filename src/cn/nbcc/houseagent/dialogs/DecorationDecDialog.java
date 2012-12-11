package cn.nbcc.houseagent.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;

public class DecorationDecDialog extends TitleAreaDialog {
	private Text text;

	/**
	 * Create the dialog.
	 * @param parentShell
	 */
	public DecorationDecDialog(Shell parentShell) {
		super(parentShell);
	}

	/**
	 * Create contents of the dialog.
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("户型描述信息");
		setTitle("户型信息");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(10, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		Label label_8 = new Label(container, SWT.NONE);
		label_8.setText("房产类型");
//		new Label(container, SWT.NONE);
		
		Combo combo_7 = new Combo(container, SWT.NONE);
		combo_7.setItems(new String[] {"高层", "小高层", "低层", "别墅"});
		combo_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		combo_7.select(0);
//		new Label(container, SWT.NONE);
		
		Label label = new Label(container, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label.setText("朝向");
		
		text = new Text(container, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 6, 1));
		
		Combo combo = new Combo(container, SWT.NONE);
		combo.setItems(new String[] {"1", "2", "3", "4", "5", "6"});
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_combo.widthHint = 38;
		combo.setLayoutData(gd_combo);
		combo.select(2);
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_1.setText("室");
		
		Combo combo_1 = new Combo(container, SWT.NONE);
		combo_1.setItems(new String[] {"1", "2", "3", "4", "5", "6"});
		GridData gd_combo_1 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_combo_1.widthHint = 37;
		combo_1.setLayoutData(gd_combo_1);
		combo_1.select(1);
		
		Label label_2 = new Label(container, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_2.setText("厅");
		
		Combo combo_2 = new Combo(container, SWT.NONE);
		combo_2.setItems(new String[] {"1", "2", "3", "4", "5", "6"});
		GridData gd_combo_2 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_combo_2.widthHint = 40;
		combo_2.setLayoutData(gd_combo_2);
		combo_2.select(1);
		
		Label label_3 = new Label(container, SWT.NONE);
		label_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_3.setText("卫");
		
		Combo combo_3 = new Combo(container, SWT.NONE);
		combo_3.setItems(new String[] {"1", "2", "3", "4", "5", "6"});
		GridData gd_combo_3 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_combo_3.widthHint = 42;
		combo_3.setLayoutData(gd_combo_3);
		combo_3.select(1);
		
		Label label_4 = new Label(container, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_4.setText("阳台");
		
		Combo combo_4 = new Combo(container, SWT.NONE);
		combo_4.setItems(new String[] {"1", "2", "3", "4", "5", "6"});
		GridData gd_combo_4 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_combo_4.widthHint = 32;
		combo_4.setLayoutData(gd_combo_4);
		combo_4.select(0);
		
		Label label_5 = new Label(container, SWT.NONE);
		label_5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_5.setText("车库");
		
		Combo combo_5 = new Combo(container, SWT.NONE);
		combo_5.setItems(new String[] {"1", "2", "3", "4", "5", "6"});
		combo_5.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		combo_5.select(1);
		
		Label label_6 = new Label(container, SWT.NONE);
		label_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_6.setText("梯");
		
		Combo combo_6 = new Combo(container, SWT.NONE);
		combo_6.setItems(new String[] {"1", "2", "3", "4", "5", "6"});
		combo_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		combo_6.select(2);
		
		Label label_7 = new Label(container, SWT.NONE);
		label_7.setText("户");
		label_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		

		return area;
	}

	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(383, 321);
	}

}
