package cn.nbcc.houseagent.wizard;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.nebula.widgets.datechooser.DateChooserCombo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cn.nbcc.houseagent.model.RentItem;

public class RentItemWizardPage2 extends WizardPage {
	private Text PMCText;
	private Text PMCFeeText;
	private Text landPlanText;
	private Text pcIdText;
	private Text decFeeText;
	private Text infrastructureText;
	private RentItem rentItem;

	/**
	 * Create the wizard.
	 */
	public RentItemWizardPage2() {
		super("wizardPage");
		setTitle("房产相关信息");
		setDescription("描述房产的相关信息");
	}

	/**
	 * @wbp.parser.constructor
	 */
	public RentItemWizardPage2(IStructuredSelection selection) {
		this();
		if (!selection.isEmpty()) {
			if (selection.getFirstElement() instanceof RentItem) {
				rentItem = (RentItem) selection.getFirstElement();
			}
		}
		
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		Group group = new Group(container, SWT.NONE);
		group.setText("房产详细信息");
		group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		group.setLayout(new GridLayout(6, false));
		
		Label PMCLabel = new Label(group, SWT.NONE);
		PMCLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		PMCLabel.setText("物业名称");
		
		PMCText = new Text(group, SWT.BORDER);
		PMCText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 5, 1));
		
		Label PMCFee = new Label(group, SWT.NONE);
		PMCFee.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		PMCFee.setText("物业费");
		
		PMCFeeText = new Text(group, SWT.BORDER);
		PMCFeeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label payLabel = new Label(group, SWT.NONE);
		payLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		payLabel.setText("付费方式:");
		
		Combo payCombos = new Combo(group, SWT.NONE);
		payCombos.setItems(new String[] {"按年", "按季度", "按月"});
		payCombos.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		payCombos.select(0);
		
		Label landPlanLabel = new Label(group, SWT.NONE);
		landPlanLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		landPlanLabel.setText("土地性质");
		
		landPlanText = new Text(group, SWT.BORDER);
		landPlanText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_2.setText("产权类型");
		
		Combo pcTypeCombo = new Combo(group, SWT.NONE);
		pcTypeCombo.setItems(new String[] {"房产证和土地证", "产权证", "购房合同、购房证明书、发票", "预售合同和收据", "两证"});
		pcTypeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		pcTypeCombo.select(0);
		
		Label label = new Label(group, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label.setText("产权证号");
		
		pcIdText = new Text(group, SWT.BORDER);
		pcIdText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group group_1 = new Group(container, SWT.NONE);
		group_1.setText("装修详细信息");
		group_1.setLayout(new GridLayout(5, false));
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_1 = new Label(group_1, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_1.setText("装修年份");
		
		DateChooserCombo dateChooserCombo = new DateChooserCombo(group_1, SWT.NONE);
		
		Label label_3 = new Label(group_1, SWT.NONE);
		label_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_3.setText("装修费用");
		
		decFeeText = new Text(group_1, SWT.BORDER);
		decFeeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		Label label_4 = new Label(group_1, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		label_4.setText("基本设施:");
		
		infrastructureText = new Text(group_1, SWT.BORDER);
		GridData gd_infrastructureText = new GridData(SWT.FILL, SWT.TOP, true, false, 3, 1);
		gd_infrastructureText.heightHint = 50;
		infrastructureText.setLayoutData(gd_infrastructureText);
		
		Button addButton = new Button(group_1, SWT.NONE);
		GridData gd_addButton = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_addButton.widthHint = 48;
		addButton.setLayoutData(gd_addButton);
		addButton.setText("添加");
	}

}
