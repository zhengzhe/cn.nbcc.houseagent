package cn.nbcc.houseagent.wizard;

import java.util.Date;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.internal.databinding.conversion.StringToDateConverter;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.nebula.widgets.datechooser.DateChooserCombo;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import cn.nbcc.houseagent.model.RentItem;
import cn.nbcc.houseagent.utils.RentConstants;

import com.ibm.icu.util.GregorianCalendar;
import com.swtdesigner.ResourceManager;
import org.eclipse.core.databinding.beans.BeansObservables;

/**
 * @author dell
 *
 */
public class RentItemWizardPage1 extends WizardPage {
	private Label addressLabel;			
	private Text addressText;								//地址
	private Button areaBrowserButton;
	private Label communityLabel;
	private Text communityText;										//小区名称
	private Button desButton;								//房型描述按钮
	private Label commentLabel;							
	private Label commentLabel2;
	private Text commentText;								//备注1
	private Text commentText2;							//备注2
	private Label contactLabel;
	private Text contactText;								//联系人
	private Combo districtCombo;
	private Label districtLabel;
	private Label floorLabel;
	private Text floorText;										//楼层
	private Label idLabel;
	private Text idText;
	private Label phoneLabel;
	private Text phoneText;									//电话
	private Label registerLabel;
	private Text registerText;		//登记人
	private Label rentLimitLabel;
	private Text rentLimitText;	//租金额度
	private Combo rentStyleCombo;
	private Label rentStyleLabel;
	private Combo sourceCombo;
	private Label sourceLabel;
	private Combo statusCombo;
	private Label statusLabel;		//状态
	private Label houseDecLabel;
	private Text houseDecText;			//房屋信息描述
	private DateChooserCombo vDateTimeCombo;
	private Label vDTLabel;
	private RentItem rentItem;

	/**
	 * Create the wizard.
	 */
	public RentItemWizardPage1() {
		super("wizardPage");
		setImageDescriptor(ResourceManager.getPluginImageDescriptor("cn.nbcc.houseagent", "icons/new_wiz.gif"));
		setTitle("出租信息");
		setDescription("房产出租基本信息");
	}

	/**
	 * @wbp.parser.constructor
	 */
	public RentItemWizardPage1(IStructuredSelection selection) {
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
		group.setText("房产基本信息");
		group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		group.setBounds(0, 0, 70, 84);
		group.setLayout(new GridLayout(5, false));
		
		idLabel = new Label(group, SWT.NONE);
		idLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		idLabel.setSize(16, 17);
		idLabel.setText("ID:");
		
		idText = new Text(group, SWT.BORDER);
		idText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		idText.setSize(532, 23);
		idText.setEditable(false);
		
		statusLabel = new Label(group, SWT.NONE);
		statusLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		statusLabel.setText("当前状态");
		
		statusCombo = new Combo(group, SWT.READ_ONLY);
		for (int i = 0; i < RentConstants.StatusTypes.length; i++) {
			
			statusCombo.add(RentConstants.NAME_MAP.get(RentConstants.StatusTypes[i]), i);
			
		}
//		statusCombo.setItems(new String[] {"已租", "未租"});
		statusCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		statusCombo.select(0);
		
		districtLabel = new Label(group, SWT.NONE);
		districtLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		districtLabel.setSize(24, 17);
		districtLabel.setText("地区");
		
		districtCombo = new Combo(group, SWT.NONE);
		districtCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		districtCombo.setSize(532, 25);
		districtCombo.setItems(new String[] {"江东", "江北", "海曙", "鄞州", "北仑", "象山", "舟山"});
		districtCombo.select(0);
		
		communityLabel = new Label(group, SWT.NONE);
		communityLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		communityLabel.setText("小区名称:");
		
		communityText = new Text(group, SWT.BORDER);
		communityText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		areaBrowserButton = new Button(group, SWT.NONE);
		GridData gd_areaNameBrowserButton = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_areaNameBrowserButton.widthHint = 66;
		areaBrowserButton.setLayoutData(gd_areaNameBrowserButton);
		areaBrowserButton.setText("浏览");
		
		addressLabel = new Label(group, SWT.NONE);
		addressLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		addressLabel.setSize(27, 17);
		addressLabel.setText("详细地址:");
		
		addressText = new Text(group, SWT.BORDER);
		addressText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		addressText.setSize(532, 23);
		
		floorLabel = new Label(group, SWT.NONE);
		floorLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		floorLabel.setText("所属楼层:");
		
		floorText = new Text(group, SWT.BORDER);
		floorText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		houseDecLabel = new Label(group, SWT.NONE);
		houseDecLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		houseDecLabel.setText("房屋情况:");
		
		houseDecText = new Text(group, SWT.BORDER);
		houseDecText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		desButton = new Button(group, SWT.NONE);
		desButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		desButton.setText("描述");
		
		rentLimitLabel = new Label(group, SWT.NONE);
		rentLimitLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		rentLimitLabel.setText("租金(月):");
		
		rentLimitText = new Text(group, SWT.BORDER);
		rentLimitText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		rentStyleLabel = new Label(group, SWT.NONE);
		rentStyleLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		rentStyleLabel.setText("出租方式");
		
		rentStyleCombo = new Combo(group, SWT.NONE);
		for (int i = 0; i < RentConstants.StyleTypes.length; i++) {
			rentStyleCombo.add(RentConstants.NAME_MAP.get(RentConstants.StyleTypes[i]), i);
		}
		rentStyleCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		rentStyleCombo.select(0);
		rentStyleCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Combo combo = (Combo)e.getSource();
				rentItem.setRentStyle(RentConstants.StyleTypes[combo.getSelectionIndex()]);
			}
		});
		
		commentLabel = new Label(group, SWT.NONE);
		commentLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		commentLabel.setText("备注:");
		
		commentText = new Text(group, SWT.BORDER | SWT.MULTI);
		GridData gd_commentText = new GridData(SWT.FILL, SWT.TOP, true, false, 4, 1);
		gd_commentText.heightHint = 50;
		commentText.setLayoutData(gd_commentText);
	
		Group group_1 = new Group(container, SWT.NONE);
		group_1.setText("联系人信息");
		group_1.setLayout(new GridLayout(2, false));
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, true, 1, 1));
		
		contactLabel = new Label(group_1, SWT.NONE);
		contactLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		contactLabel.setText("联系人:");
		
		contactText = new Text(group_1, SWT.BORDER);
		contactText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		phoneLabel = new Label(group_1, SWT.NONE);
		phoneLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		phoneLabel.setText("联系电话:");
		
		phoneText = new Text(group_1, SWT.BORDER);
		phoneText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		commentLabel2 = new Label(group_1, SWT.NONE);
		commentLabel2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		commentLabel2.setText("备注");
		
		commentText2 = new Text(group_1, SWT.BORDER | SWT.MULTI);
		commentText2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Group group_2 = new Group(container, SWT.NONE);
		group_2.setText("登记人信息");
		group_2.setLayout(new GridLayout(4, false));
		group_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		registerLabel = new Label(group_2, SWT.NONE);
		registerLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		registerLabel.setText("登记人");
		
		registerText = new Text(group_2, SWT.BORDER);
		registerText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		sourceLabel = new Label(group_2, SWT.NONE);
		sourceLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		sourceLabel.setText("信息来源");
		
		sourceCombo = new Combo(group_2, SWT.NONE);
		sourceCombo.setItems(new String[] {"个人", "公司", "网络"});
		sourceCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		sourceCombo.select(0);
		
		vDTLabel = new Label(group_2, SWT.NONE);
		vDTLabel.setText("有效时间");
		
		vDateTimeCombo = new DateChooserCombo(group_2, SWT.NONE);
		vDateTimeCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		vDateTimeCombo.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (e.getSource() instanceof DateChooserCombo) {
					DateChooserCombo dChooserCombo = (DateChooserCombo) e.getSource();
					rentItem.setDueDate(dChooserCombo.getValue());
					System.out.println(dChooserCombo.getValue());
				}
				
			}
			
		});
		 initDataBindings();
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//
		IObservableValue idTextObserveTextObserveWidget = SWTObservables.observeText(idText, SWT.Modify);
		IObservableValue rentItemIdObserveValue = BeansObservables.observeValue(rentItem, "id");
		bindingContext.bindValue(idTextObserveTextObserveWidget, rentItemIdObserveValue, null, null);
		//
		IObservableValue areaTextObserveTextObserveWidget = SWTObservables.observeText(communityText, SWT.Modify);
		IObservableValue rentItemHouseSourcepmcObserveValue = BeansObservables.observeValue(rentItem, "houseSource.community");
		bindingContext.bindValue(areaTextObserveTextObserveWidget, rentItemHouseSourcepmcObserveValue, null, null);
		//
		IObservableValue rentLimitTextObserveTextObserveWidget = SWTObservables.observeText(rentLimitText, SWT.Modify);
		IObservableValue rentItemRentChargeObserveValue = BeansObservables.observeValue(rentItem, "rentCharge");
		bindingContext.bindValue(rentLimitTextObserveTextObserveWidget, rentItemRentChargeObserveValue, null, null);
		//
		IObservableValue rentStyleComboObserveSingleSelectionIndexObserveWidget = SWTObservables.observeSingleSelectionIndex(rentStyleCombo);
		IObservableValue rentItemRentStyleObserveValue = BeansObservables.observeValue(rentItem, "rentStyle");
		bindingContext.bindValue(rentStyleComboObserveSingleSelectionIndexObserveWidget, rentItemRentStyleObserveValue, null, null);
		//
		IObservableValue commentTextObserveTextObserveWidget = SWTObservables.observeText(commentText, SWT.Modify);
		IObservableValue rentItemCommentObserveValue = BeansObservables.observeValue(rentItem, "comment");
		bindingContext.bindValue(commentTextObserveTextObserveWidget, rentItemCommentObserveValue, null, null);
		//
		IObservableValue contactTextObserveTextObserveWidget = SWTObservables.observeText(contactText, SWT.Modify);
		IObservableValue rentItemFirstContactornameObserveValue = BeansObservables.observeValue(rentItem, "contactor.name");
		bindingContext.bindValue(contactTextObserveTextObserveWidget, rentItemFirstContactornameObserveValue, null, null);
		//
		IObservableValue phoneTextObserveTextObserveWidget = SWTObservables.observeText(phoneText, SWT.Modify);
		IObservableValue rentItemFirstContactorphoneObserveValue = BeansObservables.observeValue(rentItem, "contactor.phone");
		bindingContext.bindValue(phoneTextObserveTextObserveWidget, rentItemFirstContactorphoneObserveValue, null, null);
		//
		IObservableValue registerTextObserveTextObserveWidget = SWTObservables.observeText(registerText, SWT.Modify);
		IObservableValue rentItemRegisternameObserveValue = PojoObservables.observeValue(rentItem, "register.name");
		bindingContext.bindValue(registerTextObserveTextObserveWidget, rentItemRegisternameObserveValue, null, null);
		//
		IObservableValue sourceComboObserveSingleSelectionIndexObserveWidget = SWTObservables.observeSingleSelectionIndex(sourceCombo);
		IObservableValue rentItemSourceObserveValue = BeansObservables.observeValue(rentItem, "source");
		bindingContext.bindValue(sourceComboObserveSingleSelectionIndexObserveWidget, rentItemSourceObserveValue, null, null);
		//
		IObservableValue vDateTimeComboTextObserveValue = PojoObservables.observeValue(vDateTimeCombo, "value");
		IObservableValue rentItemStartDateObserveValue = BeansObservables.observeValue(rentItem, "startDate");
//		UpdateValueStrategy strategy1 = new UpdateValueStrategy();
		bindingContext.bindValue(vDateTimeComboTextObserveValue, rentItemStartDateObserveValue, null, null);
		//
		IObservableValue addressTextObserveTextObserveWidget = SWTObservables.observeText(addressText, SWT.Modify);
		IObservableValue rentItemHouseSourceaddressObserveValue = BeansObservables.observeValue(rentItem, "houseSource.address");
		bindingContext.bindValue(addressTextObserveTextObserveWidget, rentItemHouseSourceaddressObserveValue, null, null);
		//
		IObservableValue floorTextObserveTextObserveWidget = SWTObservables.observeText(floorText, SWT.Modify);
		IObservableValue rentItemHouseSourcefloorObserveValue = BeansObservables.observeValue(rentItem, "houseSource.floor");
		bindingContext.bindValue(floorTextObserveTextObserveWidget, rentItemHouseSourcefloorObserveValue, null, null);
		//
		IObservableValue houseDecTextObserveTextObserveWidget = SWTObservables.observeText(houseDecText, SWT.Modify);
		IObservableValue rentItemHouseSourcehouseDescriptorhouseDescriptionObserveValue = BeansObservables.observeValue(rentItem, "houseSource.houseDescriptor.houseDescription");
		bindingContext.bindValue(houseDecTextObserveTextObserveWidget, rentItemHouseSourcehouseDescriptorhouseDescriptionObserveValue, null, null);
		//
		return bindingContext;
	}
}
