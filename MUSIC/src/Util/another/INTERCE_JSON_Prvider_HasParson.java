package Util.another;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/*
 * 负责提供json解析后字符串的接口
 * 输入json字符串，输出集合，集合中装载规范的信息
 */
public interface INTERCE_JSON_Prvider_HasParson {
	
	
	
	List<String[]> Parson_JSonString_ToArray();
	List<Map> Parson_JSonString_ToMap(	 );
}
