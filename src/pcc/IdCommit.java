package pcc;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;


public class IdCommit {
	
	private static final Logger logger = Logger.getLogger(IdCommit.class.getName());
	private static final String ERRORSTR = "Exception found";
	
	private IdCommit() {
	    throw new IllegalStateException("Utility class");
	}
	
	public static void commitString(String wordToSearch, String project,String fileName, int i) throws IOException {
		
		String s;
        Process p;
        String outname = fileName + "TotalCommit.txt";
        
        	
         p = Runtime.getRuntime().exec("cmd /c cd "+project+"&& git log --grep="+wordToSearch+" --date=iso-strict --name-status --stat HEAD --abbrev-commit");
         BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
         if(i != 0) {
        	 try(FileWriter result = new FileWriter(outname,true)){
            	
            	while ((s = br.readLine()) != null) {
                	result.write(s);
                	result.append("\n");
                }	
                p.waitFor();
                p.destroy();
                
        	 }catch (Exception e) {
            	logger.log(Level.WARNING,ERRORSTR);
            	p.destroy();
        	 }
         }else {
        	 try(FileWriter result = new FileWriter(outname)){
             	
             	while ((s = br.readLine()) != null) {
                 	result.write(s);
                 	result.append("\n");
                 }	
                 p.waitFor();
                 p.destroy();
                 
             }catch (Exception e) {
             	logger.log(Level.WARNING,ERRORSTR);
             	p.destroy();
             }
         }
         
            
        
    }
		
	

	

}


