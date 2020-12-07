package bootstrap;


import java.io.File;
import java.util.List;

import Util.Compare.Compare_Wps;
import WPS.WPS_Write_INTERCE;
import WPS.WPS_Write_WithString;

public class boostrap2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WPS_Write_INTERCE wps_Write =new WPS_Write_WithString();
		File f=new File("F:/“Ù¿÷/music.xlsx"),f2=new File("F:/“Ù¿÷/musiced.xlsx"),f3=new File("F:/“Ù¿÷/Nomusiced.xlsx");;
		
		Compare_Wps aaa=new Compare_Wps(f,f2);
		List No_match=aaa.ChackIfSame();
		wps_Write.Write(No_match, f3);
	}

}
