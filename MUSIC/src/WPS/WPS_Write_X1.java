package WPS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WPS_Write_X1  implements WPS_Write_INTERCE {
	private List<Map> ObjerctList;
	private File f;
	public WPS_Write_X1(List<Map> ObjerctList,File f) {
			this.f=f;
			this.ObjerctList =ObjerctList;
		
	}
	
	public void Write() {
		// TODO Auto-generated method stub
		try{

			XSSFWorkbook wb = new XSSFWorkbook();  //�ļ������
			XSSFSheet sheet = wb.createSheet(); //���������
//			sheet.setDefaultRowHeight((short) 512);
			
			XSSFRow row;
			XSSFCell cell;
			String a;
			Map<String ,String> map=new HashMap();
			 System.out.println("ObjerctList.size()"+ObjerctList.size());
			 Iterator map1it;
			 Map.Entry<String, String>  entry;
			for(int i=0;i<ObjerctList.size();i++) {
				/*
				 * �õ��б��
				 */
				 row = (XSSFRow) sheet .createRow(i); //�����������湤����ĵ�1�У�������0��ʼ������0��65535֮����κ�һ��
				 map=ObjerctList.get(i);
				 
				 
					 /*
					  * �õ��еĵڼ��б��
					  */
				 map1it=map.entrySet().iterator();
				int j=0;
				 while(map1it.hasNext()){
					 
					 entry= (Entry<String, String>) map1it.next();
					 
					 cell = row.createCell(j++); //�������������еĵ�Ԫ�񣬲�����0��ʼ������0��255֮����κ�һ��
					 a=entry.getValue();//System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue()); 
					 cell.setCellValue(a);//����Ϣ������
				 }
				    
				     
				     
				    
				    
				    
					 
					 
					
				 
				 
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
	public void Write(List list, File f) {
		// TODO Auto-generated method stub
		
	}
}
