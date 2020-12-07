package Util.another;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Util.File_Operation.INTERCE_Read_File;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JSON_Privder_X implements INTERCE_JSON_Prvider,INTERCE_JSON_Prvider_HasParson{
	private String jsonString;
	private List<String[]> jsonStringArray;
	private List<Map> jsonStringMap=new ArrayList<>();
	
	public JSON_Privder_X(String jsonString) {
		this.jsonString=jsonString;
		// TODO Auto-generated constructor stub
	}

	
	


	@Override
	public String JSON_Prvider() {
		// TODO Auto-generated method stub
		return jsonString;
	}





	@Override
	public List<String[]> Parson_JSonString_ToArray() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public List<Map> Parson_JSonString_ToMap() {
		// TODO Auto-generated method stub
		return null;
	}



	
	





	




	
}
