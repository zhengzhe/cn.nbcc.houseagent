package cn.nbcc.houseagent.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchWindow;

public class TestAction extends Action {

	private IWorkbenchWindow window;
	public static final String ID = "cn.nbcc.houseagent.actions.test";

	public TestAction(IWorkbenchWindow window) {
		setText("按揭计算");
		setId(ID);
		setActionDefinitionId("cn.nbcc.houseagent.commands.calc");
		setImageDescriptor(ImageDescriptor.createFromFile(TestAction.class, "/icons/calc.gif"));
		this.window = window;
	}

	@Override
	public void run() {
		
		
	}
	

}
