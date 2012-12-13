package cn.nbcc.houseagent.views;

import static cn.nbcc.houseagent.utils.RentConstants.NAME_MAP;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import cn.nbcc.houseagent.Activator;
import cn.nbcc.houseagent.model.RentItem;
import cn.nbcc.houseagent.model.RentItemManager;
import cn.nbcc.houseagent.utils.DateUtils;
import cn.nbcc.houseagent.wizard.NewRentItemWizard;


public class RentItemView extends ViewPart implements PropertyChangeListener{
//	private DataBindingContext m_bindingContext;
	public RentItemView() {
	}
	public static final String ID = "cn.nbcc.houseagent.rentitemview";

	private TableViewer viewer;
	
	private final String COLUMN_NAMES[]={"编号","所属地区","小区名称","物业名称","租用方式","租金(月)","当前租用状态","登记人","来源","开始时间","到期时间"};

	protected RentItem currentSelectItem;

	private Table table;

	protected NameViewerFilter nameFilter;

	/**
	 * The content provider class is responsible for providing objects to the
	 * view. It can wrap existing objects in adapters or simply return objects
	 * as-is. These objects may be sensitive to the current input of the view,
	 * or ignore it and always show the same content (like Task List, for
	 * example).
	 */
	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

		public Object[] getElements(Object parent) {
			if (parent instanceof RentItem[]) {
				return (RentItem[]) parent;
			}
	        return new Object[0];
		}
	}

	class ViewLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			if (obj instanceof RentItem) {
				RentItem rentItem = (RentItem) obj;
				switch (index) {
				case 0:
					return rentItem.getId();
				case 1:
					return rentItem.getHouseSource().getDistrict();
				case 2:
					return rentItem.getHouseSource().getCommunity();
				case 3:
					return rentItem.getHouseSource().getPmc().getName();
				case 4:
					return NAME_MAP.get(rentItem.getRentStyle());
				case 5:
				{
					DecimalFormat twoDigits = new DecimalFormat("0.00");
					return 	twoDigits.format(rentItem.getRentCharge());
				}
				case 6:
					return NAME_MAP.get(rentItem.getRentStatus());
//				case 7:
//					return rentItem.getContactors();
				case 7:
					return rentItem.getRegister().getName();
				case 8:
					return NAME_MAP.get(rentItem.getSource());
				case 9:
					return DateUtils.getDateString(rentItem.getStartDate());
				case 10:
					return DateUtils.getDateString(rentItem.getDueDate());
				default:
					return "null";
				}
			}
			return "null";
		}

		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}

		public Image getImage(Object obj) {
//			return PlatformUI.getWorkbench().getSharedImages().getImage(
//					ISharedImages.IMG_OBJ_ELEMENT);
				return null;
		}
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(2, false));
		viewer = new TableViewer(parent, SWT.FULL_SELECTION | SWT.MULTI);
		table = viewer.getTable();
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		
		for (int i = 0; i < COLUMN_NAMES.length; i++) {
			TableColumn tableColumn = new TableColumn(table, SWT.NONE);
			tableColumn.setWidth(100);
			tableColumn.setText(COLUMN_NAMES[i]);
			tableColumn.setMoveable(true);
		}
		
		
		
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {
				
				TableViewer viewer = (TableViewer) event.getViewer();
		        IStructuredSelection thisSelection = (IStructuredSelection) event
		            .getSelection();
		        if (currentSelectItem!=null) {
					currentSelectItem.removePropertyChangeListener(RentItemView.this);
				}
		        currentSelectItem = (RentItem)thisSelection.getFirstElement();
		        currentSelectItem.addPropertyChangeListener(RentItemView.this);
		        
		        openWizard(viewer,thisSelection);
				
			}
		});
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Object element = ((IStructuredSelection)event.getSelection()).getFirstElement();
				
		        if (currentSelectItem!=null) {
					currentSelectItem.removePropertyChangeListener(RentItemView.this);
				}
		        currentSelectItem = (RentItem)element;
		        currentSelectItem.addPropertyChangeListener(RentItemView.this);
				
				
				if (element instanceof RentItem) {
					RentItem rentItem = (RentItem) element;
					System.out.println("In veiwer:"+rentItem);
				}
				
			}
		});
		
		hookPopMenu();  

		
		getViewSite().setSelectionProvider(viewer);
		
		
		
		viewer.setInput(RentItemManager.getManager().getRentItems());
	}

	private void hookPopMenu() {
		MenuManager menuManager = new MenuManager();
		nameFilter = new NameViewerFilter(viewer);
		
		IAction filterAction = new Action("筛选出租信息"){
			@Override
			public void run() {
				InputDialog dialog = new InputDialog(table.getShell(), "出租信息过滤",
						"输入 名称过滤模式"+
						"(*=任何字符串,?=任何字符)"+
						System.getProperty("line.seperator")+
						"或一个空字符串表示没有过滤",nameFilter.getPattern(),null);
				if (dialog.open()==InputDialog.OK) {
					nameFilter.setPattern(dialog.getValue().trim());
				}
			}
		};
		filterAction.setImageDescriptor(Activator.getImageDescriptor("/icons/filter.gif"));
		
		
		IAction deleteAction = new Action("删除"){
			public void run() {
				boolean isConfirm = MessageDialog.openConfirm(table.getShell(), "确定信息","真的要删除信息吗?");
				if (isConfirm) {
					if (viewer.getSelection() instanceof IStructuredSelection) {
						IStructuredSelection selection = (IStructuredSelection)viewer.getSelection();
						if (selection instanceof RentItem) {
							RentItem deletedItem = (RentItem) selection;
							RentItemManager.getManager().remove(deletedItem);
							viewer.remove(viewer.getSelection());
						}
					}
				}
			};
		};
		deleteAction.setImageDescriptor(Activator.getImageDescriptor("/icons/delete.gif"));
		
		IAction addAction = new Action("新增"){
			public void run() {
				
			}
		};
		addAction.setImageDescriptor(Activator.getImageDescriptor("/icons/add.gif"));
		IAction modifyAction = new Action("修改"){
			public void run() {
				
			}
		};
		modifyAction.setImageDescriptor(Activator.getImageDescriptor("/icons/modify.gif"));
		
		menuManager.add(addAction);
		menuManager.add(modifyAction);
		menuManager.add(deleteAction);
		menuManager.add(filterAction);
		menuManager.add(new Action(""){
			@Override
			public void run() {
				super.run();
			}
		});
		
		
		Menu menu = menuManager.createContextMenu(table);
		table.setMenu(menu);
	}

	protected void openWizard(TableViewer viewer2, IStructuredSelection selection) {
		
		NewRentItemWizard wizard = new NewRentItemWizard();
		wizard.init(PlatformUI.getWorkbench(),selection);
		WizardDialog dialog = new WizardDialog(viewer2.getTable().getShell(), wizard);
		dialog.open();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		viewer.refresh(currentSelectItem);
	}
}