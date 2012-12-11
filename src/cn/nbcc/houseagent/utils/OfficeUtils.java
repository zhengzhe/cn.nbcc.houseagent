package cn.nbcc.houseagent.utils;

import cn.nbcc.houseagent.utils.JRegisteryTool.OfficeVersionEum;

public class OfficeUtils {
	
	private static String officePath = "";
	
	static{
		for (OfficeVersionEum version : OfficeVersionEum.values()) {
			if (!JRegisteryTool.getInstallRoot(version).isEmpty()) {
				officePath = JRegisteryTool.getInstallRoot(version);
				break;
			}
		}
	}
	
	public static String getOfficeUrl()
	{
		return officePath;
	}

}
