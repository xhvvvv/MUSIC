package Util.Compare;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import Util.Compare.compare.Compare_INTERCE;
import Util.Compare.compare.Compare_SongsName;
import WPS.WPS_Read;
import WPS.WPS_Read_INTERCE;
import WPS.WPS_Write_INTERCE;
import WPS.WPS_Write_WithString;
/*
 * 
 */
public class Compare_Wps  {
	
	
	private File f,f2;//f2为主
	public Compare_Wps(File f, File f2) {
		
		this.f = f;
		this.f2 = f2;
	}
	/*
	 * 工具比较器和文件获取器，有默认项，也可重新设置
	 */
	private Compare_INTERCE compare_INTERCE=new Compare_SongsName();
	private WPS_Read_INTERCE wps_Read =new WPS_Read();
	private  WPS_Write_INTERCE wps_Write=new WPS_Write_WithString();
	
	public void setCompare_INTERCE(Compare_INTERCE compare_INTERCE) {
		this.compare_INTERCE = compare_INTERCE;
	}


	public void setWps_Read(WPS_Read_INTERCE wps_Read) {
		this.wps_Read = wps_Read;
	}
	public void setWps_Read(WPS_Write_INTERCE wps_Write) {
		this.wps_Write = wps_Write;
	}
	
	
	
	
	/*
	 * 检查wps两个列数据是否模糊相同  比如  abcd 和  acd就是模糊相同的
	 */
	public List ChackIfSame() {
		List<String> x1=getData(f,0);
		List<String> x2=getData(f2,8);
		List<String> x3=new ArrayList();//存储还未下载的歌曲
		System.out.println("x1得到的初始大小"+x1.size()+"x2得到的初始大小"+x2.size());//xx1已经下载好了
		String xx1;
		String xx2;
		int count =0,counted =0;  //配对成功歌曲数目
		loop:
		for (int i=0;i<x1.size();i++) {
			xx1=x1.get(i);
		//	System.out.println("开始配对"+xx1+"-----序号"+i);//xx1已经下载好了
			for(int j=0;j<x2.size();j++) {
				xx2=x2.get(j);
				if(compare_INTERCE.Compare_If_Contine(xx1, xx2)  ) {
//					System.out.println(xx1);//xx1已经下载好了
					x2.remove(j);//除去已经配对的，剩下的都是没有在歌单中的
					counted++;
					//System.out.println(xx1+"配对结束，已找到"+"-----序号"+i);//xx1已经下载好了		
					continue loop;//如果已经找到了，就不必再找了
					
				}
			
			}
			count++;
			x3.add(xx1);
//			System.out.println(xx1+"配对结束，未找到"+"-----序号"+i);//xx1已经下载好了		
//			System.out.println("-----------------------");//xx1已经下载好了
		}
		System.out.println("在已下载的歌曲库中找到了"+counted+"个匹配项");//xx1已经下载好了
		System.out.println("歌单中还未配对的歌曲数目为(就是还未下载的歌曲还剩)"+count);//xx1已经下载好了
		System.out.println("歌曲经过匹配后歌曲库中还剩下"+x2.size()+"个没有被配对的");//xx1已经下载好了 
		writeleft(x2,"F:/音乐/Dowan_left.xlsx");
		writeleft(x3,"F:/音乐/NeedToDown.xlsx");
		return x1;
	}
	/*
	 * 提供xlsx的文件路径，准确读取某行或列的数据
	 * 
	 */
	public List<String> getData(File f,int cellnum) {
		List<String> element=new ArrayList();
		XSSFWorkbook x1=(XSSFWorkbook) wps_Read.Read(f);  //获取工作文件
		XSSFSheet sheet=x1.getSheetAt(0); 	//XSSFSheet sheet = x1.getSheet("Sheet1");//==getSheetAt(int index);获取sheet
		//int rowcount = sheet.getLastRowNum();  row.getLastCellNum();取得有效的行数&取得一行的有效单元格个数    
		int rowcount = sheet.getLastRowNum();
		XSSFRow row ;
		XSSFCell cell;
		
		for(int i=0;i<rowcount;i++) {
			
			
			try {
				row= sheet.getRow(i);
				cell= row.getCell(cellnum);
				element.add(cell.getStringCellValue());
			}catch(Exception e) {
				System.out.println("cell为空");//xx1已经下载好了
			}
				
			
			
		}
		System.out.println(f.toString()+"已经装载完毕");//xx1已经下载好了
		return element;
		
	}
	
	/*
	 * 提供一个数组和一个xlsx路径，将数组写进去
	 */
	public void writeleft(List x2,String fpath) {
		wps_Write.Write(x2, new File(fpath));
	}
	



	
	
	

}
