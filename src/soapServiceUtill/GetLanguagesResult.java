package soapServiceUtill;

import java.util.HashMap;

public class GetLanguagesResult {
	public String error;
	public HashMap<Integer,String> langs;
	@SuppressWarnings("unchecked")
	public GetLanguagesResult(Object [] res){
		HashMap<String,Object> result=(HashMap<String,Object>)res[0];
		error=(String)result.get("error");
		langs=(HashMap<Integer,String>)result.get("languages");
	}
}
