package cn.nbcc.houseagent.model.events;

import java.util.EventObject;

import cn.nbcc.houseagent.model.RentItem;
import cn.nbcc.houseagent.model.RentItemManager;

/**
 * @author dell
 *
 *Update:下午02:38:30
 */
/**
 * @author zhengzhe
 *
 *Update:下午02:38:31
 */
public class RentItemManagerEvent extends EventObject {

	private final RentItem[] added;
	private final RentItem[] removed;
	private final RentItem[] modified;
	private static final long serialVersionUID = 2765027064988823264L;
	
	
	public RentItem[] getAdded() {
		return added;
	}


	public RentItem[] getRemoved() {
		return removed;
	}


	public RentItem[] getModified() {
		return modified;
	}
	
	/**
	 * 租房条目管理器事件
	 * @param source
	 * @param itemAdded
	 * @param itemRemoved
	 * @param itemModified
	 * author:zheng zhe
	 * Update:2012-12-3
	 */
	public RentItemManagerEvent(RentItemManager source,RentItem[] itemAdded,RentItem[]  itemRemoved,RentItem[] itemModified) {
		super(source);
		added  = itemAdded;
		removed = itemRemoved;
		modified = itemModified;
	}

}
