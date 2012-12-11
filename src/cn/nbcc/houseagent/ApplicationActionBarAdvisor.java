package cn.nbcc.houseagent;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import cn.nbcc.houseagent.actions.TaskActionFactory;
import cn.nbcc.houseagent.actions.TestAction;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	private Action testAction;

	// Actions - important to allocate these only in makeActions, and then use
	// them
	// in the fill methods. This ensures that the actions aren't recreated
	// when fillActionBars is called with FILL_PROXY.

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}
	
	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		
//		WorkbenchWindow activeWorkbenchWindow = (WorkbenchWindow) PlatformUI.getWorkbench().getActiveWorkbenchWindow(); 
//		IToolBarManager toolBarManager = (IToolBarManager)activeWorkbenchWindow.getCoolBarManager();
//		System.out.println(coolBar.getStyle());
		GroupMarker group = new GroupMarker("TaskGroup");
		coolBar.add(group);
		
		
		ToolBarManager toolbar = 
		      new ToolBarManager(coolBar.getStyle() | SWT.RIGHT); 
		coolBar.add(toolbar); 
		
		toolbar.add(createActionContributionItem(TaskActionFactory.FirstPageAction));
		
		toolbar.add(createActionContributionItem(TaskActionFactory.PreviousPageAction));

		toolbar.add(createActionContributionItem(TaskActionFactory.NextPageAction));

		toolbar.add(createActionContributionItem(TaskActionFactory.LastPageAction));

		toolbar.add(new GroupMarker("ToolsGroup"));
		
		final ToolBarManager toolsManager = new ToolBarManager(coolBar.getStyle() | SWT.RIGHT);
		coolBar.add(toolsManager);

		toolsManager.add(createActionContributionItem(testAction));
		
		toolbar.add(new GroupMarker("ActionGroup"));

		final ToolBarManager tableControlToolManager = new ToolBarManager(coolBar.getStyle() | SWT.RIGHT);
		coolBar.add(tableControlToolManager);

		tableControlToolManager.add(createActionContributionItem(TaskActionFactory.AddAction));

		tableControlToolManager.add(createActionContributionItem(TaskActionFactory.DeleteAction));

		tableControlToolManager.add(createActionContributionItem(TaskActionFactory.ModifyAction));

//		tableControlToolManager.add(createActionContributionItem(testAction));

//		tableControlToolManager.add(new Separator());

//		tableControlToolManager.add(createActionContributionItem(testAction));
//
//		tableControlToolManager.add(createActionContributionItem(testAction));
//		
//		tableControlToolManager.add(createActionContributionItem(testAction));
//		
//		tableControlToolManager.add(createActionContributionItem(testAction));
		
		
		
//		super.fillCoolBar(coolBar);
	}
	
	public ActionContributionItem createActionContributionItem(IAction action) {
		ActionContributionItem aci = new ActionContributionItem(action);
		aci.setMode(ActionContributionItem.MODE_FORCE_TEXT);// 显示图像+文字
		return aci;
	}

	@Override
	protected void makeActions(IWorkbenchWindow window) {
		testAction = new TestAction(window);
		register(testAction);
		super.makeActions(window);
	}

}
