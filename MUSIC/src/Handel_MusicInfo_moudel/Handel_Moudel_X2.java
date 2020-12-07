package Handel_MusicInfo_moudel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Parson.INTERCE_Parson;
import Parson.INTERCE_Parson_ToArray;
import Parson.INTERCE_Parson_ToMap;
import Util.another.INTERCE_JSON_Prvider;
import Util.another.INTERCE_JSON_Prvider_HasParson;
import WPS.WPS_Write_INTERCE;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/*
 * 感觉是个建造者
 */
public class Handel_Moudel_X2 extends ABSTRACT_Handel_Moudel implements INTERCE_JSON_Prvider_HasParson {
	String jsonString=null;
	
	
	
	public Handel_Moudel_X2(String jsonString) {
		this.jsonString=jsonString;
		
	}
	@Override
	public List<Map> getMusicInfo() {
		// TODO Auto-generated method stub
		
		
		return Parson_JSonString_ToMap();
		
	}
	
	/*
	 * 过虑过一些不需要的json
	 */
	
	@Override
	public List<String[]> Parson_JSonString_ToArray() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Map> Parson_JSonString_ToMap() {
		// TODO Auto-generated method stub
		JSONArray jsonarray=ParsonArray(jsonString);
		List<Map> jsonStringMap=new ArrayList();
		/*
		 * 区别分析
		 */
		JSONObject subObject;
		JSONArray jsonarray_contine_nextjsonarray;
		for(int i=0;i<jsonarray.size();i++){
			String every_song;
			Map<String ,String> map=new HashMap();
            System.out.println("---------------");
            subObject=(JSONObject)jsonarray.get(i);//JSONObject   jsonObject  =  jsonArray.getJSONObject(i) ; 
            
            //有一个歌手数组在JSONObject，将它提取出来
            jsonarray_contine_nextjsonarray=(JSONArray)subObject.get("singer");
            System.out.println("songname="+subObject.get("songname"));
            System.out.println("albumdesc="+subObject.get("albumdesc"));
            map.put("Song_Name", (String)subObject.get("songname"));//音乐名称，有版本
            map.put("Song_SpecificName",(String)subObject.get("albumdesc"));//音乐备注
            map.put("Song_SongOrigName",(String)subObject.get("songorig"));//音乐名
            
            
           
            subObject=(JSONObject) jsonarray_contine_nextjsonarray.get(0);
            System.out.println("name="+ subObject.get("name"));
            map.put("Singer_Name",(String)subObject.get("name"));
            jsonStringMap.add(map);
        }
		return jsonStringMap;
	}
	private JSONArray ParsonArray(String jsonString) {
		// TODO Auto-generated method stub
		JSONObject json_contine =JSONObject.fromObject(jsonString);
		json_contine=(JSONObject)json_contine.get("data");
		JSONArray jsonarray=(JSONArray )json_contine.get("songlist");
		System.out.println("jsonarray.size()"+jsonarray.size());
		return jsonarray;
			
	}
}
