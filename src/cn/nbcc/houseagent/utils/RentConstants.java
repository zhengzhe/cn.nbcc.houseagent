package cn.nbcc.houseagent.utils;

import java.util.HashMap;

public class RentConstants {
	public enum EumDecStyle {
		
		DEC_STYLE_MODEN("现代简约"),  	//装修风格现代简约风
		DEC_STYLE_CLLASIC("古典"), 	//装修风格古典风
		DEC_STYLE_MUSHUP("混搭"),		//混搭风格
		DEC_STYLE_EURO("欧式"),   		//欧式风格
		DEC_STYLE_COUNTRY("田园");		//田园风格
		
		private String name;
		private EumDecStyle(String name) {
			this.name = name;
		}
		@Override
		public String toString() {
			return name;
		}

	}
	public static double DEFAULT_CHARGE = 2000.0;		//默认租金
	public static int DEFAULT_RENT_DUEDATE = 1 ;		//默认租金截止时间为一个月
	public static int SOLE_TANANT = 1;	    				//整租
	public static int SPELL_RENT	  = 1<<1;					//拼租
	public static int BED_RENT = 1<<2;						//床位
	public static int UNOCCUPANCY = 1<<3;				//未租
	public static int OCCUPANCY	= 1<<4;						//已租
	public static int FROM_COMPANY = 1<<5;			//来自公司
	public static int FROM_USER = 1<<6;						//来自登记人
	public static int FROM_WEB =1<<7	;						//来自网络
	public static int FROM_OTHER=1<<8;					//来自其他
	
	
	
	
	public static HashMap<Integer, String> NAME_MAP = new HashMap<Integer, String>();
	public static int[] StatusTypes = new int[]{UNOCCUPANCY,OCCUPANCY};
	public static int[] StyleTypes = new int[]{SOLE_TANANT,SPELL_RENT,BED_RENT};
	public static int[] SourceTypes = new int[]{FROM_USER,FROM_COMPANY,FROM_WEB,FROM_OTHER};
	static {
		NAME_MAP.put(FROM_COMPANY, "来自公司");
		NAME_MAP.put(FROM_USER, "来自登记人");
		NAME_MAP.put(FROM_WEB, "来自网络");
		NAME_MAP.put(SOLE_TANANT, "整租");
		NAME_MAP.put(SPELL_RENT,"拼租");
		NAME_MAP.put(BED_RENT,"床位");
		NAME_MAP.put(UNOCCUPANCY, "未租");
		NAME_MAP.put(OCCUPANCY, "已租");
	}
}
