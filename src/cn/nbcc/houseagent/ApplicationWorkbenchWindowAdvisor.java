package cn.nbcc.houseagent;

import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuDetectEvent;
import org.eclipse.swt.events.MenuDetectListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolTip;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {


	private IWorkbenchWindowConfigurer configurer;
	
	private TrayItem trayItem;
	private Image trayImage;
	private IWorkbenchWindow window;



	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public ActionBarAdvisor createActionBarAdvisor(
			IActionBarConfigurer configurer) {
		return new ApplicationActionBarAdvisor(configurer);
	}

	public void preWindowOpen() {
		configurer = getWindowConfigurer();
		
		configurer.setInitialSize(new Point(400, 300));
		configurer.setTitle("房产中介管理软件");
		configurer.setShowCoolBar(true); 

	}

	@Override
	public void postWindowOpen() {
		// TODO Auto-generated method stub
//		configurer.getWindow().getShell().setMaximized(true);
		super.postWindowOpen();
		window = configurer.getWindow();
		trayItem = initTaskItem(window);
	    // Some OS might not support tray items
	    if (trayItem != null) {
	      minimizeBehavior();
	      // Create exit and about action on the icon
	      hookPopupMenu();
	    }

		
	}

	private void minimizeBehavior() {
		window.getShell().addShellListener(new ShellAdapter() {
		      // If the window is minimized hide the window
		      public void shellIconified(ShellEvent e) {
		        window.getShell().setVisible(false);
		      }
		    });
		    // If user double-clicks on the tray icons the application will be
		    // visible again
		    trayItem.addSelectionListener(new SelectionAdapter() {
		      @Override
		      public void widgetSelected(SelectionEvent e) {
		        Shell shell = window.getShell();
		        if (!shell.isVisible()) {
		          window.getShell().setMinimized(false);
		          shell.setVisible(true);
		        }
		      }
		    });

		
	}

	private void hookPopupMenu() {
		trayItem.addMenuDetectListener(new MenuDetectListener() {
		      @Override
		      public void menuDetected(MenuDetectEvent e) {
		        Menu menu = new Menu(window.getShell(), SWT.POP_UP);
		        // Creates a new menu item that terminates the program
		        MenuItem exit = new MenuItem(menu, SWT.NONE);
		        exit.setText("退出!");
		        exit.addSelectionListener(new SelectionAdapter() {
		          @Override
		          public void widgetSelected(SelectionEvent e) {
		            window.getWorkbench().close();
		          }
		        });
		        // We need to make the menu visible
		        menu.setVisible(true);
		      }
		    });
	}

	private TrayItem initTaskItem(final IWorkbenchWindow window) {
		final Tray tray = window.getShell().getDisplay().getSystemTray();
	    final TrayItem trayItem = new TrayItem(tray, SWT.NONE);
	    trayImage = Activator.getImageDescriptor("/icons/house.gif")
	        .createImage();
	    trayItem.setImage(trayImage);
	    trayItem.setToolTipText("房产中介管理系统");
	    
	    Timer timer = new Timer();
	    timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				window.getShell().getDisplay().asyncExec(new Runnable() {
					
					@Override
					public void run() {
						ToolTip tip = new ToolTip(window.getShell(), SWT.BALLOON|SWT.ICON_INFORMATION);
						
						tip.setMessage("江北区怡江春色69#601室租金到期");
						tip.setText("出租信息");
						trayItem.setToolTip(tip);
						tip.setVisible(true);
					}
				});
			}
		}, 0, 30*1000);
	    
	    return trayItem;
	}

	
	
}
