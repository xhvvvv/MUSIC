package Util.File_Operation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import Util.another.INTERCE_JSON_Prvider;
/*
 * ��ȡ�ļ����õ��ļ�������String����ʵ�ֽӿ�INTERCE_JSON_Prvider���ṩjson�ַ���
 */
public class Read_File_X1 extends ABSTRACT_Read_File implements INTERCE_JSON_Prvider{
	
	

	public Read_File_X1(String file) {
		super(file);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String JSON_Prvider() {
		
		return  Red_File();
		
	}
	@Override
	public String Red_File() {
		// TODO Auto-generated method stub
		 StringBuilder sb = new StringBuilder();
		 
		try (FileInputStream fis = new FileInputStream(f);
				InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
				BufferedReader raf = new BufferedReader(isr)){
			
			
			String s = null;
			
			// ��ȡ�ļ����ݣ��������ӡ
			while((s = raf.readLine()) != null) {
				sb.append(s);
			
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		

		return sb.toString();
	}
	

}
