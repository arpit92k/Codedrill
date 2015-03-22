package soapServiceUtill;

import java.util.HashMap;

public class TestFunctionResult {
	public String error;
	public String moreHelp;
	public float pi;
	public int answerToLifeAndEverything ;
	public boolean oOok ;
	@SuppressWarnings("unchecked")
	public TestFunctionResult(Object[] res){
		HashMap<String,Object> result=(HashMap<String,Object>)res[0];
		error=(String)result.get("error");
		if(error.equals("OK")){
			moreHelp=(String)result.get("moreHelp");
			pi=(Float)result.get("pi");
			answerToLifeAndEverything=(Integer)result.get("answerToLifeAndEverything");
			oOok=(boolean)result.get("oOok");
		}
	}
}
