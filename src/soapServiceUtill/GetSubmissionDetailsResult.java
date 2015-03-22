package soapServiceUtill;

import java.util.HashMap;

public class GetSubmissionDetailsResult {
	public String error;
	public int langId;
	public String langName;
	public String langVersion;
	public float time;
	public String date;
	public int status;
	public int result;
	public int memory;
	public int singnal;
	public boolean pub;
	public String source;
	public String input;
	public String output;
	public String stderr;
	public String cmpinfo;
	@SuppressWarnings("unchecked")
	public GetSubmissionDetailsResult(Object[] res){
		HashMap<String,Object> result=(HashMap<String,Object>)res[0];
		error=(String)result.get("error");
		if(error.equals("OK")){
			langId=(Integer)result.get("langId");
			langName=(String)result.get("langName");
			langVersion=(String)result.get("langVersion");
			time=(Float)result.get("time");
			date=(String)result.get("date");
			status=(Integer)result.get("status");
			this.result=(Integer)result.get("result");
			memory=(Integer)result.get("memory");
			singnal=(Integer)result.get("signal");
			pub=(Boolean)result.get("public");
			source=(String)result.get("source");
			input=(String)result.get("input");
			output=(String)result.get("output");
			stderr=(String)result.get("stderr");
			cmpinfo=(String)result.get("cmpinfo");
		}
	}
}
