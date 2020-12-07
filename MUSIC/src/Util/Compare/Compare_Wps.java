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
	
	
	private File f,f2;//f2Ϊ��
	public Compare_Wps(File f, File f2) {
		
		this.f = f;
		this.f2 = f2;
	}
	/*
	 * ���߱Ƚ������ļ���ȡ������Ĭ���Ҳ����������
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
	 * ���wps�����������Ƿ�ģ����ͬ  ����  abcd ��  acd����ģ����ͬ��
	 */
	public List ChackIfSame() {
		List<String> x1=getData(f,0);
		List<String> x2=getData(f2,8);
		List<String> x3=new ArrayList();//�洢��δ���صĸ���
		System.out.println("x1�õ��ĳ�ʼ��С"+x1.size()+"x2�õ��ĳ�ʼ��С"+x2.size());//xx1�Ѿ����غ���
		String xx1;
		String xx2;
		int count =0,counted =0;  //��Գɹ�������Ŀ
		loop:
		for (int i=0;i<x1.size();i++) {
			xx1=x1.get(i);
		//	System.out.println("��ʼ���"+xx1+"-----���"+i);//xx1�Ѿ����غ���
			for(int j=0;j<x2.size();j++) {
				xx2=x2.get(j);
				if(compare_INTERCE.Compare_If_Contine(xx1, xx2)  ) {
//					System.out.println(xx1);//xx1�Ѿ����غ���
					x2.remove(j);//��ȥ�Ѿ���Եģ�ʣ�µĶ���û���ڸ赥�е�
					counted++;
					//System.out.println(xx1+"��Խ��������ҵ�"+"-----���"+i);//xx1�Ѿ����غ���		
					continue loop;//����Ѿ��ҵ��ˣ��Ͳ���������
					
				}
			
			}
			count++;
			x3.add(xx1);
//			System.out.println(xx1+"��Խ�����δ�ҵ�"+"-----���"+i);//xx1�Ѿ����غ���		
//			System.out.println("-----------------------");//xx1�Ѿ����غ���
		}
		System.out.println("�������صĸ��������ҵ���"+counted+"��ƥ����");//xx1�Ѿ����غ���
		System.out.println("�赥�л�δ��Եĸ�����ĿΪ(���ǻ�δ���صĸ�����ʣ)"+count);//xx1�Ѿ����غ���
		System.out.println("��������ƥ���������л�ʣ��"+x2.size()+"��û�б���Ե�");//xx1�Ѿ����غ��� 
		writeleft(x2,"F:/����/Dowan_left.xlsx");
		writeleft(x3,"F:/����/NeedToDown.xlsx");
		return x1;
	}
	/*
	 * �ṩxlsx���ļ�·����׼ȷ��ȡĳ�л��е�����
	 * 
	 */
	public List<String> getData(File f,int cellnum) {
		List<String> element=new ArrayList();
		XSSFWorkbook x1=(XSSFWorkbook) wps_Read.Read(f);  //��ȡ�����ļ�
		XSSFSheet sheet=x1.getSheetAt(0); 	//XSSFSheet sheet = x1.getSheet("Sheet1");//==getSheetAt(int index);��ȡsheet
		//int rowcount = sheet.getLastRowNum();  row.getLastCellNum();ȡ����Ч������&ȡ��һ�е���Ч��Ԫ�����    
		int rowcount = sheet.getLastRowNum();
		XSSFRow row ;
		XSSFCell cell;
		
		for(int i=0;i<rowcount;i++) {
			
			
			try {
				row= sheet.getRow(i);
				cell= row.getCell(cellnum);
				element.add(cell.getStringCellValue());
			}catch(Exception e) {
				System.out.println("cellΪ��");//xx1�Ѿ����غ���
			}
				
			
			
		}
		System.out.println(f.toString()+"�Ѿ�װ�����");//xx1�Ѿ����غ���
		return element;
		
	}
	
	/*
	 * �ṩһ�������һ��xlsx·����������д��ȥ
	 */
	public void writeleft(List x2,String fpath) {
		wps_Write.Write(x2, new File(fpath));
	}
	



	
	
	

}
