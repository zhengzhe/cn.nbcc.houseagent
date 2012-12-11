package cn.nbcc.houseagent.views;

import java.beans.PropertyChangeListener;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

import cn.nbcc.houseagent.dialogs.FlatDecDialog;
import cn.nbcc.houseagent.model.RentItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;

public class HouseView extends ViewPart implements ISelectionListener,PropertyChangeListener{

	public static final String ID = "cn.nbcc.houseagent.views.HouseView"; //$NON-NLS-1$
	private Text text;
	private Text addressText;
	private Text yearText;
	private Text houseDecText;
	private Text dDecYearText;
	private Text dDecFeeText;
	private Text dDecStyleText;
	private Text infrastructureText;
	private RentItem currentRentItem;

	private WritableValue value;
	private Text hDecComment;
	private Text text_2;
	private Text elevatorDecText;
	private Text floorText;
	private Button garageChkBtn;
	private Button bicycleShedChkBtn;
	private Button gardenChkBtn;
	private Button poolChkBtn;

	public HouseView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		final Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(1, false));
		{
			Group group = new Group(container, SWT.NONE);
			group.setText("房源基本信息");
			group.setLayout(new GridLayout(2, false));
			group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
			
			Label label = new Label(group, SWT.NONE);
			label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			label.setText("小区名称:");
			
			text = new Text(group, SWT.BORDER);
			text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_1 = new Label(group, SWT.NONE);
			label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			label_1.setText("详细地址:");
			
			addressText = new Text(group, SWT.BORDER);
			addressText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_3 = new Label(group, SWT.NONE);
			label_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			label_3.setText("楼层:");
			
			floorText = new Text(group, SWT.BORDER);
			floorText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
			
			Label label_2 = new Label(group, SWT.NONE);
			label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			label_2.setText("建成年份:");
			
			yearText = new Text(group, SWT.BORDER);
			yearText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		}
		
		Group group_1 = new Group(container, SWT.NONE);
		group_1.setText("户型信息");
		group_1.setLayout(new GridLayout(3, false));
		group_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		
		Label label_3_1 = new Label(group_1, SWT.NONE);
		label_3_1.setText("户型信息:");
		
		houseDecText = new Text(group_1, SWT.BORDER);
		houseDecText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button buildButton = new Button(group_1, SWT.NONE);
		GridData gd_button_4 = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_button_4.widthHint = 54;
		buildButton.setLayoutData(gd_button_4);
		buildButton.setText("构建");
		buildButton.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				FlatDecDialog dialog = new FlatDecDialog(container.getShell());
				dialog.open();
			}
			
		});
		
		Label label_7 = new Label(group_1, SWT.NONE);
		label_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_7.setText("电梯情况:");
		
		elevatorDecText = new Text(group_1, SWT.BORDER);
		elevatorDecText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		
		
		Label label_4 = new Label(group_1, SWT.NONE);
		label_4.setText("配置信息");
		
		Composite composite = new Composite(group_1, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.HORIZONTAL));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		
		garageChkBtn = new Button(composite, SWT.CHECK);
		garageChkBtn.setText("车库");
		
		bicycleShedChkBtn = new Button(composite, SWT.CHECK);
		bicycleShedChkBtn.setText("车棚");
		
		gardenChkBtn = new Button(composite, SWT.CHECK);
		gardenChkBtn.setText("花园");
		
		poolChkBtn = new Button(composite, SWT.CHECK);
		poolChkBtn.setText("泳池");
		
		Label label_5 = new Label(group_1, SWT.NONE);
		label_5.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		label_5.setText("其他信息");
		
		hDecComment = new Text(group_1, SWT.BORDER | SWT.MULTI);
		GridData gd_hDecComment = new GridData(SWT.FILL, SWT.TOP, true, false, 2, 1);
		gd_hDecComment.heightHint = 61;
		hDecComment.setLayoutData(gd_hDecComment);
		{
			Group group = new Group(container, SWT.NONE);
			group.setText("装修基本信息");
			group.setLayout(new GridLayout(3, false));
			group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
			
			Label label = new Label(group, SWT.NONE);
			label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			label.setText("装修年份:");
			
			dDecYearText = new Text(group, SWT.BORDER);
			dDecYearText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			
			Label label_1 = new Label(group, SWT.NONE);
			label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			label_1.setText("装修费用:");
			
			dDecFeeText = new Text(group, SWT.BORDER);
			dDecFeeText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			
			Label label_2 = new Label(group, SWT.NONE);
			label_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			label_2.setText("装修风格:");
			
			dDecStyleText = new Text(group, SWT.BORDER);
			dDecStyleText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
			Label label_3 = new Label(group, SWT.NONE);
			label_3.setLayoutData(new GridData(SWT.RIGHT, SWT.FILL, false, true, 1, 1));
			label_3.setText("基本设施:");
			
			infrastructureText = new Text(group, SWT.BORDER);
			GridData gd_infrastructureText = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
			gd_infrastructureText.heightHint = 79;
			infrastructureText.setLayoutData(gd_infrastructureText);
			
			Button buildButton2 = new Button(group, SWT.NONE);
			GridData gd_button_5 = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
			gd_button_5.widthHint = 57;
			buildButton2.setLayoutData(gd_button_5);
			buildButton2.setText("构建");
			buildButton2.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetDefaultSelected(SelectionEvent e) {
					// TODO Auto-generated method stub
					super.widgetDefaultSelected(e);
				}
			});
		}

		createActions();
		initializeToolBar();
		initializeMenu();
		
		getSite().getPage().addSelectionListener(this);
		currentRentItem = new RentItem();
		initDataBindings();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		IStructuredSelection sel = (IStructuredSelection)selection;
		if (sel.getFirstElement() instanceof RentItem) {
			if (currentRentItem!=null) {
				currentRentItem.removePropertyChangeListener(HouseView.this);
			}
			currentRentItem = (RentItem) sel.getFirstElement();
			currentRentItem.addPropertyChangeListener(HouseView.this);
			
		}
//		m_bindingContext = initDataBindings();
		System.out.println("in HouseView:"+currentRentItem);
		value.setValue(currentRentItem);
	}
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//定义绑定对象
		value = new WritableValue();

		// Create the binding
		{
			IObservableValue target = WidgetProperties.text(SWT.Modify).observe(text);
			IObservableValue model = PojoProperties.value(RentItem.class,"houseSource.community").observeDetail(value);
			bindingContext.bindValue(target, model);
		}
		{
			IObservableValue target = SWTObservables	.observeText(addressText, SWT.Modify);
			IObservableValue model = PojoProperties.value(RentItem.class,"houseSource.address").observeDetail(value);
			bindingContext.bindValue(target,	model, null, null);
		}
		{
			IObservableValue target = SWTObservables.observeText(floorText, SWT.Modify);
			IObservableValue model = PojoProperties.value(RentItem.class, "houseSource.floor").observeDetail(value);
			bindingContext.bindValue(target, model,null,null);
		}
		{
			IObservableValue target = SWTObservables.observeText(yearText, SWT.Modify);
			IObservableValue model = PojoProperties.value(RentItem.class, "houseSource.pmc.buildYear").observeDetail(value);
			bindingContext.bindValue(target, model,null,null);
		}
		{
			IObservableValue target = SWTObservables.observeText(houseDecText, SWT.Modify);
			IObservableValue model = PojoProperties.value(RentItem.class, "houseSource.houseDescriptor.houseDescription").observeDetail(value);
			bindingContext.bindValue(target, model,null,null);
		}
		{
			IObservableValue target = SWTObservables.observeText(elevatorDecText, SWT.Modify);
			IObservableValue model = PojoProperties.value(RentItem.class, "houseSource.houseDescriptor.eleDesciption").observeDetail(value);
			bindingContext.bindValue(target, model,null,null);
		}
		
		
		{
			IObservableValue target = SWTObservables.observeText(dDecStyleText, SWT.Modify);
			IObservableValue model = PojoProperties.value(RentItem.class, "houseSource.decorationDescriptor.decStyle").observeDetail(value);
			bindingContext.bindValue(target, model,null,null);
		}
		
		{
			IObservableValue target = SWTObservables.observeText(dDecYearText, SWT.Modify);
			IObservableValue model = PojoProperties.value(RentItem.class, "houseSource.decorationDescriptor.year").observeDetail(value);
			bindingContext.bindValue(target, model,null,null);
		}
		{
			IObservableValue target = SWTObservables.observeText(dDecFeeText, SWT.Modify);
			IObservableValue model = PojoProperties.value(RentItem.class, "houseSource.decorationDescriptor.decFee").observeDetail(value);
			bindingContext.bindValue(target, model,null,null);
		}
		{
			IObservableValue bicycleShedChkBtnObserveSelectionObserveWidget = SWTObservables.observeSelection(bicycleShedChkBtn);
			IObservableValue currentRentItemHouseSourcehouseDescriptorpengObserveValue = PojoProperties.value(RentItem.class, "houseSource.houseDescriptor.peng").observeDetail(value);
			bindingContext.bindValue(bicycleShedChkBtnObserveSelectionObserveWidget, currentRentItemHouseSourcehouseDescriptorpengObserveValue, null, null);
		}
		{
			IObservableValue gardenChkBtnObserveSelectionObserveWidget = SWTObservables.observeSelection(gardenChkBtn);
			IObservableValue currentRentItemHouseSourcehouseDescriptorgardenObserveValue = PojoProperties.value(RentItem.class, "houseSource.houseDescriptor.garden").observeDetail(value);
			bindingContext.bindValue(gardenChkBtnObserveSelectionObserveWidget, currentRentItemHouseSourcehouseDescriptorgardenObserveValue, null, null);
		}
		//
		{
			IObservableValue poolChkBtnObserveSelectionObserveWidget = SWTObservables.observeSelection(poolChkBtn);
			IObservableValue currentRentItemHouseSourcehouseDescriptorpoolObserveValue = PojoProperties.value(RentItem.class, "houseSource.houseDescriptor.pool").observe(value);
			bindingContext.bindValue(poolChkBtnObserveSelectionObserveWidget, currentRentItemHouseSourcehouseDescriptorpoolObserveValue, null, null);
		}
		return bindingContext;
	}

	@Override
	public void propertyChange(java.beans.PropertyChangeEvent evt) {
		
	}
}
