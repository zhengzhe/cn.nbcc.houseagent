package cn.nbcc.houseagent.views;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.eclipse.core.databinding.DataBindingContext;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

import cn.nbcc.houseagent.model.RentItem;

public class ContactorView extends ViewPart implements PropertyChangeListener, ISelectionListener {

	public static final String ID = "cn.nbcc.houseagent.views.ContactorView"; //$NON-NLS-1$
	private Text nameText;
	private Text phoneText;
	private RentItem currentRentItem;
	private WritableValue value;

	public ContactorView() {	
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		{
			Label label = new Label(container, SWT.NONE);
			label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			label.setText("客户姓名:");
		}
		{
			nameText = new Text(container, SWT.BORDER);
			nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		}
		{
			Label label = new Label(container, SWT.NONE);
			label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
			label.setText("联系电话:");
		}
		{
			phoneText = new Text(container, SWT.BORDER);
			phoneText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		}

		createActions();
		initializeToolBar();
		initializeMenu();
		
		getSite().getPage().addSelectionListener(this);
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
		if (sel.getFirstElement() instanceof RentItem	) {
			if (currentRentItem!=null) {
				currentRentItem.removePropertyChangeListener(ContactorView.this);
			}
			currentRentItem = (RentItem) sel.getFirstElement();
			currentRentItem.addPropertyChangeListener(ContactorView.this);
		}
		value.setValue(currentRentItem);
		System.out.println("In Contactor View:"+currentRentItem);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		
	}
	
	protected DataBindingContext initDataBindings() {
		DataBindingContext bindingContext = new DataBindingContext();
		//定义绑定对象
		value = new WritableValue();

		// Create the binding
		{
			IObservableValue target = WidgetProperties.text(SWT.Modify).observe(nameText);
			IObservableValue model = PojoProperties.value(RentItem.class,"contactor.name").observeDetail(value);
			bindingContext.bindValue(target, model);
		}
		{
			IObservableValue target = WidgetProperties.text(SWT.Modify).observe(phoneText);
			IObservableValue model = PojoProperties.value(RentItem.class,"contactor.phone").observeDetail(value);
			bindingContext.bindValue(target, model);
		}
		return bindingContext;
	}

}
