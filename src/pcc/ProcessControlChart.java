package pcc;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

public class ProcessControlChart {
	
	
	private static ArrayList<String> id;
	
	public static void main(String[] args) {
		
		String progName = "BAHIR";
		String project1 = "C:\\Users\\Simone Benedetti\\Documents\\Programmazione JAVA\\Bahir";
		String project2 = "C:\\Users\\Simone Benedetti\\Documents\\Programmazione JAVA\\Bahir-website";
		String project3 = "C:\\Users\\Simone Benedetti\\Documents\\Programmazione JAVA\\Flink";
		
		try {
			id = (ArrayList<String>) RetrieveTicketsID.getIdCommit(progName);
		} catch (JSONException|IOException e) {
			
			e.printStackTrace();
		} 
		
		
		for(int i=0; i<id.size(); i++) {
			try {
				IdCommit.commitString(id.get(i), project1, "bahir" , i);
				IdCommit.commitString(id.get(i), project2,"bahir-website", i);
				IdCommit.commitString(id.get(i), project3, "flink",i);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
		
	}
	

}
