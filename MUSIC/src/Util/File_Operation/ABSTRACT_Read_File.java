package Util.File_Operation;

import java.io.File;
/*
 * ����INTERCE_Read_File���кܶ෽������������ʹ���˽ӿ�������
 */
public abstract class ABSTRACT_Read_File implements INTERCE_Read_File{
	public File f;
	public  ABSTRACT_Read_File(String file) {
		this.f=new File(file);
	}
	public String Red_File() {
		return null;
	}
	
}
