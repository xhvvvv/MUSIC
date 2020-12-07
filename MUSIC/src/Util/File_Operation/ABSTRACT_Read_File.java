package Util.File_Operation;

import java.io.File;
/*
 * 担心INTERCE_Read_File会有很多方法，所以这里使用了接口适配器
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
