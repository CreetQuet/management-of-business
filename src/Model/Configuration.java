package Model;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Properties;

public class Configuration {
	
	private String configDirectoryFile = "config.ini";
	
	public void createConfigurationFile(){
		
		try {
			Properties config = new Properties();
			File file = new File(configDirectoryFile);
            // Si el archivo no existe es creado
            if (!file.exists()) {
    			config.put("name_db", "shoptest");
    			config.put("pwd_db", "");
    			config.put("user_db", "root");
    			config.put("port_db", "3306");
    			config.put("ip_db", "127.0.0.1");
    			config.put("useVat", "true");
    			config.put("vatPercentage", "16");
    			config.store(new FileWriter(configDirectoryFile),"Configuration DB");  
            }
        } catch (Exception e) {
                    e.printStackTrace();
        }
    }
	
	public HashMap<String, String> getConfiguration() {
		
		HashMap<String, String> data = new HashMap<String, String>();
		try {
			FileReader reader = new FileReader(configDirectoryFile);  
		      
			Properties p=new Properties();  
			p.load(reader);
			
			data.put("ip", p.getProperty("ip_db"));
			data.put("port", p.getProperty("port_db"));
			data.put("user", p.getProperty("user_db"));
			data.put("pwd", p.getProperty("pwd_db"));
			data.put("db", p.getProperty("name_db"));
			data.put("vat", p.getProperty("useVat"));
			data.put("vatPercent", p.getProperty("vatPercentage"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	
	
}
