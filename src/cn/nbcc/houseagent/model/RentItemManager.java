package cn.nbcc.houseagent.model;

/***********************************************************************
 * Module:  RentItemManager.java
 * Author:  zheng zhe
 * Purpose: Defines the Class RentItemManager
 ***********************************************************************/

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

import cn.nbcc.houseagent.model.HouseDescriptor.HouseDecAspects;
import cn.nbcc.houseagent.utils.RentConstants;
import cn.nbcc.houseagent.utils.RentConstants.EumDecStyle;

/**
 * 租房条目管理器
 * 
 * @pdOid 054bc6a4-4f7d-4b08-b4e0-a7d5bdda359e
 */
public class RentItemManager extends ModelObject {
	/**
	 * 管理器
	 * 
	 * @pdOid ad1a90f4-8342-42a6-8087-b1eb471abe2b
	 */
	private static RentItemManager manger;
	/**
	 * 租房条目
	 * 
	 * @pdOid d8fd0da2-fe1d-416e-a836-1559c6c95c19
	 */
	private RentItem[] rentItems;

	/** @pdOid 916d691d-e18a-4ba6-9df4-74e000e7a050 */
	private IRentItemManagerListener listeners;

	/**
	 * 添加租房条目管理器的监听者
	 * 
	 * @param listener
	 * @pdOid 587fb977-2fdf-41e5-b4d1-7ff37d3f2440
	 */
	public void addRentItemManagerListener(IRentItemManagerListener listener) {
		// TODO: implement
	}

	/**
	 * 移除出租条目监听
	 * 
	 * @param IRentItemListener
	 *            出租条目监听器
	 * @pdOid e57b6522-43ec-4921-b045-053f54cc4863
	 */
	public void removeRentItemManagerListener(
			IRentItemManagerListener IRentItemListener) {
		// TODO: implement
	}

	/** @pdOid 8e837977-2f74-4a7b-844f-cf9d0f9cdc40 */
	public void fireRentItemChanged() {
		// TODO: implement
	}

	/** @pdOid 8d5c09a6-3833-4ad8-aa9e-a15f8bbd4e2c */
	public static RentItemManager getManager() {
		// TODO: implement
		if (manger == null) {
			manger = new RentItemManager();
		}
		return manger;
	}

	public RentItem[] getRentItems() {
		Contactor contactor1 = new Contactor("001","张三", "13857857920");
		Contactor contactor2 = new Contactor("002","李四", "13857857920");
		User user = new User("郑哲");
		GregorianCalendar date = new GregorianCalendar(2012, 12, 31);
		Date dueDate = date.getTime();
		HashMap<HouseDecAspects, Integer> hDecInt = new HashMap<HouseDecAspects, Integer>();
		
		hDecInt.put(HouseDecAspects.NUM_HALL,Integer.valueOf(2));
		hDecInt.put(HouseDecAspects.NUM_BALCONY, Integer.valueOf(2));
		hDecInt.put(HouseDecAspects.NUM_ROOM, Integer.valueOf(3));
		hDecInt.put(HouseDecAspects.NUM_TOILET, Integer.valueOf(2));
		hDecInt.put(HouseDecAspects.NUM_ELEVATOR, Integer.valueOf(2));
		hDecInt.put(HouseDecAspects.NUM_HOUSE_HOLD, 3);
		
		HouseDescriptor hDec = new HouseDescriptor(hDecInt,null);
		
		Pmc pmc = new Pmc("中建物业");
		pmc.setBuildYear(2004);
		
		HouseSource hSource = new HouseSource("鄞州","春江花城", pmc,"宁波鄞州高教园区学府路9号","13/17");
		HouseSource hSource1 = new HouseSource("鄞州","盛世华府", pmc,"宁波鄞州高教学院学府路9号","独栋");
		hSource.setHouseDescriptor(hDec);
		
		hDec.setGarden(true);
		hDec.setNumOfGarage(1);
		hSource.setHouseDescriptor(hDec);
		
		
		DecorationDescriptor  dDec = new DecorationDescriptor();
		dDec.setDecFee(50000000);
		dDec.setDecStyle(EumDecStyle.DEC_STYLE_EURO);
		dDec.setYear(2010);
		hSource.setDecorationDescriptor(dDec);
		
		
		
//		hSource.setFloor("13/17");
		RentItem[] rentItems = { 
				new RentItem("001", hSource	, 1200.12, RentConstants.SOLE_TANANT,	RentConstants.UNOCCUPANCY, contactor1, dueDate, RentConstants.FROM_COMPANY,user, ""), 
				new RentItem("002", hSource, 2023.123, RentConstants.SPELL_RENT, RentConstants.OCCUPANCY, contactor2, dueDate,RentConstants.FROM_USER, user, "及时练习"),
			    new RentItem("003",new HouseSource("江东","学府苑", new Pmc("雅戈尔物业")),1000.00,contactor1,user)};
		return rentItems;
	}

}