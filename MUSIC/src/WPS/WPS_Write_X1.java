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

			XSSFWorkbook wb = new XSSFWorkbook();  //文件表对象
			XSSFSheet sheet = wb.createSheet(); //工作表对象
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
				 * 得到行表格
				 */
				 row = (XSSFRow) sheet .createRow(i); //创建属于上面工作表的第1行，参数从0开始可以是0～65535之间的任何一个
				 map=ObjerctList.get(i);
				 
				 
					 /*
					  * 得到行的第几列表格
					  */
				 map1it=map.entrySet().iterator();
				int j=0;
				 while(map1it.hasNext()){
					 
					 entry= (Entry<String, String>) map1it.next();
					 
					 cell = row.createCell(j++); //创建属于上面行的单元格，参数从0开始可以是0～255之间的任何一个
					 a=entry.getValue();//System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue()); 
					 cell.setCellValue(a);//将信息填进表格
				 }
				    
				     
				     
				    
				    
				    
					 
					 
					
				 
				 
			}
			System.out.println("--------------------测试---------------------------");
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
