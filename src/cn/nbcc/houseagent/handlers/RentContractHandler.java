package cn.nbcc.houseagent.handlers;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.FileLocator;

import cn.nbcc.houseagent.Activator;
import cn.nbcc.houseagent.utils.JRegisteryTool;
import cn.nbcc.houseagent.utils.JRegisteryTool.OfficeVersionEum;
import cn.nbcc.houseagent.utils.OfficeUtils;

public class RentContractHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			 URL urlRelative= Activator.getDefault().getBundle().getEntry("./doc/doc1.doc");		  
			 URL url=FileLocator.toFileURL(urlRelative);  
			 String urlStr = url.toString();
			 String officePath = OfficeUtils.getOfficeUrl();
			 String[] cmd = new	 String[]{officePath+"/winword.exe",urlStr};
			 Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
