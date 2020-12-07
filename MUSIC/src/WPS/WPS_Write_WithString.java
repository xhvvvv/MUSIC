package WPS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WPS_Write_WithString implements WPS_Write_INTERCE {
	
	@Override
	public void Write(List list,File f) {
		// TODO Auto-generated method stub
		try{

			XSSFWorkbook wb = new XSSFWorkbook();  //�ļ������
			XSSFSheet sheet = wb.createSheet(); //���������
//			sheet.setDefaultRowHeight((short) 512);
			
			XSSFRow row;
			XSSFCell cell;
			String a;

			for(int i=0;i<list.size();i++) {
				/*
				 * �õ��б��
				 */
				 row = (XSSFRow) sheet .createRow(i); //�����������湤����ĵ�1�У�������0��ʼ������0��65535֮����κ�һ��
					 /*
					  * �õ��еĵڼ��б��
					  */
					 cell = row.createCell(0); //�������������еĵ�Ԫ�񣬲�����0��ʼ������0��255֮����κ�һ��
					
					 cell.setCellValue((String)list.get(i));//����Ϣ������
				 			 
			}
			
			System.out.println("--------------------����---------------------------");
			FileOutputStream ETFile = new FileOutputStream(f);
			 wb .write(ETFile);
			 wb.close();
			 ETFile.close();
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}

	@Override
	public void Write() {
		// TODO Auto-generated method stub
		
	}

}
