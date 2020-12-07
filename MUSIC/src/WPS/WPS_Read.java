package WPS;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class WPS_Read implements WPS_Read_INTERCE {
	

	
	
	@Override
	public XSSFWorkbook  Read(File f)  {
		
		try {
			return new XSSFWorkbook(new FileInputStream(f));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("CLASSµÄWPS_Read"+e);
			
			return null;
		}
		// TODO Auto-generated method stub

	}
	
	
}
