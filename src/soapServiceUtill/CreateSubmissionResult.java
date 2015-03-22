package soapServiceUtill;

import java.util.HashMap;

public class CreateSubmissionResult {
	public String error;
	public String link;
	@SuppressWarnings("unchecked")
	public CreateSubmissionResult(Object[] res){
		HashMap<String,Object> result=(HashMap<String,Object>)res[0];
		error=(String)result.get("error");
		link=(String)result.get("link");
	}
}
