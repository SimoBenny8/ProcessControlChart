package pcc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;

public class ProcessControlChart {
	
	
	private static ArrayList<String> id;
	private static final Logger logger = Logger.getLogger(ProcessControlChart.class.getName());
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		String progName = "BAHIR";
		String pathBahir = "bahir";
		String pathFlink = "bahir-flink";
		String pathName = "C:/Users/"+ OsUtils.getUserName()+"/Documents/";
		Process p = null;

		
		if(OsUtils.isWindows()) {
			//GIT required
			p = Runtime.getRuntime().exec("cmd /c cd "+ pathName +"&& git clone https://github.com/apache/bahir-flink"+"&& git clone https://github.com/apache/bahir");
		}
		else {
			logger.log(Level.WARNING,"Windows Required");
		}
		if(p != null) {
			
			p.waitFor();
			p.destroy();
		}
		try {
			id = (ArrayList<String>) RetrieveTicketsID.getIdCommit(progName);
		} catch (JSONException|IOException e) {
			
			e.printStackTrace();
		} 
		
		
		for(int i=0; i<id.size(); i++) {
			try {
				IdCommit.commitString(id.get(i), pathName + pathBahir, pathBahir , i);
				IdCommit.commitString(id.get(i), pathName + pathFlink, pathFlink ,i);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	

}
