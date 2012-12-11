package cn.nbcc.houseagent.utils;

import java.util.HashMap;

import ca.beq.util.win32.registry.RegistryKey;
import ca.beq.util.win32.registry.RegistryValue;
import ca.beq.util.win32.registry.RootKey;


public class JRegisteryTool {
	
	public static enum OfficeVersionEum {
		OFFICE2000,OFFICEXP,OFFICE2003,OFFICE2007,OFFICE2010,OFFICE2011,OFFICE2012,OFFICE2013
	}
	private static HashMap<Integer, String> officeVersion = new HashMap<Integer, String>();
	static{
		officeVersion.put(getVersionKey(OfficeVersionEum.OFFICE2000),"9.0");
		officeVersion.put(getVersionKey(OfficeVersionEum.OFFICEXP),"10.0");
		officeVersion.put(getVersionKey(OfficeVersionEum.OFFICE2003),"11.0");
		officeVersion.put(getVersionKey(OfficeVersionEum.OFFICE2007), "12.0");
		officeVersion.put(getVersionKey(OfficeVersionEum.OFFICE2010), "14.0");//西方人避讳13，office只提供14
	}
	public static int getVersionKey(OfficeVersionEum version)
	{
		return version.ordinal();
	}
	
	public static String getRegitryInstallRootString(OfficeVersionEum version)
	{
		StringBuilder builder = new StringBuilder("SOFTWARE\\Microsoft\\Office\\");
		builder.append(officeVersion.get(getVersionKey(version)));
		builder.append("\\Word\\InstallRoot");
		return builder.toString();
	}
	
	public static String getInstallRoot(OfficeVersionEum version) {
		RegistryKey r = new RegistryKey(RootKey.HKEY_LOCAL_MACHINE, getRegitryInstallRootString(version));
		String result="";
		if (r.exists()) {
			try {
				if(r.hasValue("Path"))
					result = r.getValue("Path").getStringValue();
			} catch (Exception e) {
			
			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(getInstallRoot(OfficeVersionEum.OFFICE2013));
		System.out.println(OfficeUtils.getOfficeUrl());
//		  getOffice2003Path(); 
	}
}
