package cn.nbcc.houseagent.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.window.ApplicationWindow;

import cn.nbcc.houseagent.Activator;

public abstract class TaskActionFactory extends Action {
	
//	public abstract void setText(String title);
//	
//	public abstract void setImageDescription(ImageDescriptor imageDescriptor);
	
	public abstract void run();
	
//	 public static TableViewer tv;
     public static  QueryInfo queryInfo=new QueryInfo();
//     public static BuyEntityFactory  db=new BuyEntityFactory ();
//	  private static Action nextPageAction=new NextPageAction();
//	  private static Action firstPageAction=new FirstPageAction();
//	  private static Action lastPageAction=new LastPageAction();
//	  private static Action previousPageAction=new PreviousPageAction();
	

 	public TaskActionFactory(TableViewer tableViewer) {
// 		this.tv = tableViewer;
 		queryInfo.currentPage = 1;
		queryInfo.pageSize = 3;
 	}
 	
 	public TaskActionFactory(String name,ImageDescriptor imageDescriptor) {
 		setImageDescriptor(imageDescriptor);
 		setText(name);
	}
 	
 	
 	public static Action FirstPageAction = new TaskActionFactory("首页",Activator.getImageDescriptor("/icons/first.gif")) {
		
		@Override
		public void run() {
			System.out.println("first page");
		}
	};
	
	public static Action PreviousPageAction = new TaskActionFactory("上页",Activator.getImageDescriptor( "/icons/backward.gif")) {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
//			queryInfo.currentPage = queryInfo.currentPage - 1;
		}
	};

	public static Action NextPageAction = new TaskActionFactory("下页",Activator.getImageDescriptor( "/icons/forward.gif")){
		@Override
		public void run() {
//			queryInfo.currentPage = queryInfo.currentPage + 1;
//			tv.setInput(db.getUsers(queryInfo));
//			setActionsState();
			// TODO Auto-generated method stub
//			super.run();
		}
	};

	public static Action LastPageAction = new TaskActionFactory("末页",Activator.getImageDescriptor( "/icons/last.gif")) {
		
		@Override
		public void run() {
			queryInfo.currentPage = queryInfo.pageCount;
//			tv.setInput(db.getUsers(queryInfo));
			setActionsState();
			
		}
	};

	public static void setActionsState() {
//		if (queryInfo.pageCount == 0) {// 没有记录时
//			firstPageAction.setEnabled(false);
//			previousPageAction.setEnabled(false);
//			nextPageAction.setEnabled(false);
//			lastPageAction.setEnabled(false);
//		} else {
//			// 如果是第一页，则首页、上一页两按钮无效
//			boolean b = (queryInfo.currentPage == 1);
//			firstPageAction.setEnabled(!b);
//			previousPageAction.setEnabled(!b);
//			// 如果是最后一页，则未页、下一页两按钮无效
//			b = (queryInfo.currentPage == queryInfo.pageCount);
//			lastPageAction.setEnabled(!b);
//			nextPageAction.setEnabled(!b);
//		}
	}
	/**
	 * 执行"首页"按钮
	 */
	public void fireFirstAction() {
//		firstPageAction.run();
	}

	public static  Action DeleteAction = new TaskActionFactory("删除",Activator.getImageDescriptor( "/icons/delete.gif")) {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	};
//	extends Action{ extends Action{
//		private ApplicationWindow window;
//		public DeleteAction(ApplicationWindow window) {
//			this.window = window;
//			setText("删除");
//			setImageDescriptor();
//		}
//		@Override
//		public void run() {
//			TableViewer tv = ((MainApp)window).getTableViewer();
//			IStructuredSelection selection = (IStructuredSelection)tv.getSelection();
//			Object record = selection.getFirstElement();
//			if(record==null)
//			{
//				MessageDialog.openWarning(tv.getTable().getShell(), "警告", "您没有选择要删除得记录");
//				return ;
//			}
//			if (MessageDialog.openConfirm(tv.getTable().getShell(), "提醒",
//					"确信要删除改记录吗?")) {
//				Object input = tv.getInput();
//				if (input instanceof HireEntityFactory) {
//					HireEntityFactory hireEntityFactory = (HireEntityFactory) input;
//					hireEntityFactory.removeHireEntity((HireEntity) record);
//					MessageDialog.openConfirm(tv.getTable().getShell(), "提示",
//							"记录成功删除");
//				}
//				if (input instanceof RentEntityFactory) {
//					RentEntityFactory rentEntityFactory = (RentEntityFactory) input;
//					rentEntityFactory.removeRentEntity((RentEntity) record);
//					MessageDialog.openConfirm(tv.getTable().getShell(), "提示",
//							"记录成功删除");
//				}
//				if (input instanceof SellEntityFactory) {
//					SellEntityFactory sellEntityFactory = (SellEntityFactory) input;
//					sellEntityFactory.removeSellEntity((SellEntity) record);
//					MessageDialog.openConfirm(tv.getTable().getShell(), "提示",
//							"记录成功删除");
//				}
//				if (input instanceof BuyEntityFactory) {
//					BuyEntityFactory buyEntityFactory = (BuyEntityFactory) input;
//					buyEntityFactory.removeBuyEntity((BuyEntity) record);
//					MessageDialog.openConfirm(tv.getTable().getShell(), "提示",
//							"记录成功删除");
//				}
//			}
			
//		}
//	}
	public static Action AddAction = new TaskActionFactory("新增",Activator.getImageDescriptor( "/icons/add.gif")) {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	};
//		@Override
//		public void run() {
//			NewRentHouseDialog dialog = new NewRentHouseDialog(this.window.getShell(),window);
//			NewSellHouseDialog dialog1 = new NewSellHouseDialog(this.window.getShell(),window);
//			TableViewer tv = ((MainApp)window).getTableViewer();
//			Object input= tv.getInput();
//
//			if (input instanceof HireEntityFactory) {
//				dialog.setText("新增求租信息");
//				dialog.open();
//				return;
//			}
//			if (input instanceof RentEntityFactory) {
//				dialog.setText("新增出租信息");
//				dialog.open();
//				return;
//			}
//			if (input instanceof SellEntityFactory) {
//				dialog1.setText("新增出售信息");
//				dialog1.open();
//				return;
//			}
//			if(input instanceof BuyEntityFactory){
//				dialog1.setText("新增求购信息");
//				dialog1.open();
//				return;
//			
//			}
//		}
//	}
	
	public static Action ModifyAction = new TaskActionFactory("修改",Activator.getImageDescriptor( "/icons/modify.gif")) {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Modify...");
			
		}
	};
//	extends Action{ extends Action{
//		final private ApplicationWindow window;
//		public ModifyAction(ApplicationWindow window) {
//			this.window = window;
//			setText("修改");
//			setAccelerator(keycode);
//			setImageDescriptor(Activator.getImageDescriptor( "/icons/modify.gif"));
			
//		}
//		public void run() {
//			TableViewer tv = ((MainApp)window).getTableViewer();
//			IStructuredSelection selection = (IStructuredSelection)tv.getSelection();
//			Object record = selection.getFirstElement();
//			if(record==null)
//			{
//				MessageDialog.openWarning(tv.getTable().getShell(), "警告", "您没有选择要修改的记录");
//				return ;
//			}
//			else {
//				Object input = tv.getInput();
//				ModifyBuyHouseDialog dialog3 = new ModifyBuyHouseDialog(this.window.getShell(),window);
//				ModifyRentHouseDialog dialog1 = new ModifyRentHouseDialog(this.window.getShell(),window);
//				ModifySellHouseDialog dialog2 = new ModifySellHouseDialog(this.window.getShell(),window);
//				ModifyHireHouseDialog dialog = new ModifyHireHouseDialog(this.window.getShell(),window);
//				if (input instanceof HireEntityFactory) {
//				dialog.setText("修改求租信息");
//				 dialog.setObject(record);
//				dialog.open();
//				tv.setInput(HireEntityFactory);
//				return;
//			}
//			if (input instanceof RentEntityFactory) {
//				
//				dialog1.setText("修改出租信息");
//				dialog1.setObject(record);
//				dialog1.open();
//				tv.setInput(RentEntityFactory);
//				return;
//			}
//			if (input instanceof SellEntityFactory) {
//				dialog2.setText("修改出售信息");
//				dialog2.setObject(record);
//				dialog2.open();
//				tv.setInput(SellEntityFactory);
//				return;
//			}
//			if(input instanceof BuyEntityFactory){
//				dialog3.setText("修改求购信息");
//		        dialog3.setObject(record);
//				dialog3.open( );
//				tv.setInput(BuyEntityFactory);
//				return;
//			}
	
//		}
//	}
	public static Action  SearchAction = new TaskActionFactory("查询",Activator.getImageDescriptor( "/icons/search.gif")) {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
	};
//	extends Action{ extends Action{
//		final private ApplicationWindow window;
//		public SearchAction(ApplicationWindow window) {
//			this.window = window;
//			setText("查询");
//			setAccelerator(keycode);
//			setImageDescriptor(Activator.getImageDescriptor( "/icons/search.gif"));
//			
//		}
//		public void run() {
//			SearchDialog dialog = new SearchDialog(this.window.getShell(),window);
//			TableViewer tv = ((MainApp)window).getTableViewer();
//			Object input= tv.getInput();
//			
//			if (input instanceof HireEntityFactory) {
//				
//				dialog.open();
//				return;
//			}
//			if (input instanceof RentEntityFactory) {
//				
//				dialog.open();
//				return;
//			}
//			if (input instanceof SellEntityFactory) {
//			
//				dialog.open();
//				return;
//			}
//			if(input instanceof BuyEntityFactory){
//				
//				dialog.open();
//				return;
//			}
//		}
//	}

}
