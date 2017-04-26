package files;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class CreadorLog {
	
	Logger logger = Logger.getLogger("MyLog");
	FileHandler fh;
	
	public void crearArchivoLog(){
		try{
			fh = new FileHandler("C:/Users/User/Desktop/archivo.log");
			logger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			
			logger.info("");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void guardarInformacion(StringBuilder sb){
		try{
			logger.info(sb.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarArchivo(){
		try {
			fh.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
}
