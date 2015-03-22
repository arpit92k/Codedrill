package soapServiceUtill;

import java.util.HashMap;

public class GetSubmissionStatusResult {
	public String error;
	public int status;
	public int result;
	@SuppressWarnings("unchecked")
	public GetSubmissionStatusResult(Object[] res){
		HashMap<String,Object> result=(HashMap<String,Object>)res[0];
		error=(String)result.get("error");
		if(error.equals("OK")){
			status=(Integer)result.get("status");
			this.result=(Integer)result.get("result");
		}
	}
}
