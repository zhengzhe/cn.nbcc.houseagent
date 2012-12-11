package cn.nbcc.houseagent;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import cn.nbcc.houseagent.views.ContactorView;
import cn.nbcc.houseagent.views.HouseView;
import cn.nbcc.houseagent.views.RentItemView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		layout.setFixed(false);
		layout.addView(RentItemView.ID, IPageLayout.LEFT, 0.6f, IPageLayout.ID_EDITOR_AREA);
		layout.addView(ContactorView.ID, IPageLayout.BOTTOM, 0.79f, RentItemView.ID);
		layout.addView(HouseView.ID, IPageLayout.RIGHT, 0.2f, IPageLayout.ID_EDITOR_AREA);
	}

}
