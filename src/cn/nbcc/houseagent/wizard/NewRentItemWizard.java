package cn.nbcc.houseagent.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import cn.nbcc.houseagent.model.RentItem;

public class NewRentItemWizard extends Wizard implements INewWizard {
	
	private RentItemWizardPage1 page1;
	private RentItemWizardPage2 page2;

	public NewRentItemWizard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		
		page1 = new RentItemWizardPage1(selection);
		addPage(page1);
		
		page2 = new RentItemWizardPage2(selection);
		addPage(page2);
	}

	@Override
	public boolean performFinish() {
		
		try {
			getContainer().run(true, true, new IRunnableWithProgress() {
				
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException,
						InterruptedException {
					doFinish(monitor);
					
				}
			});
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			return false;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	protected void doFinish(IProgressMonitor monitor) {
		// TASK :完成新建向导处理
		
	}

}
