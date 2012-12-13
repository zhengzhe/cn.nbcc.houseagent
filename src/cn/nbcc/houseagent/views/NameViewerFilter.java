package cn.nbcc.houseagent.views;

import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import cn.nbcc.houseagent.model.RentItem;
import cn.nbcc.houseagent.utils.StringMatcher;

public class NameViewerFilter extends ViewerFilter {

	private final StructuredViewer viewer;
	private String pattern = "";
	private StringMatcher matcher;
	

	public NameViewerFilter(StructuredViewer viewer) {
		this.viewer = viewer;
	}
	
	public String getPattern() {
		return pattern;
	}
	
	public void setPattern(String newPattern) {
		boolean filtering = matcher!=null;
		if (newPattern!=null&&newPattern.trim().length()>0) {
			pattern = newPattern;
			matcher = new StringMatcher(pattern,true,false);
			if (!filtering) {
				viewer.addFilter(this);
			}else {
				viewer.refresh();
			}
		}else {
			pattern = "";
			matcher = null;
			if (filtering) {
				viewer.removeFilter(this);
			}
		}
	}
	
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return matcher.match(((RentItem)element).getHouseSource().getCommunity());
	}

}
