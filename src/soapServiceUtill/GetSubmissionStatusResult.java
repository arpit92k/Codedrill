package soapServiceUtill;

import java.util.HashMap;

public class GetSubmissionStatusResult {
	public String error;
	public String status;
	public String result;
	@SuppressWarnings("unchecked")
	public GetSubmissionStatusResult(Object[] res){
		HashMap<String,Object> result=(HashMap<String,Object>)res[0];
		error=(String)result.get("error");
		status=(String)result.get("status");
		this.result=(String)result.get("result");
	}
}
