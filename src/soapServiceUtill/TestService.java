package soapServiceUtill;

import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.Map.Entry;
import java.util.Scanner;

import com.ideone.api._1.service.Ideone_Service_v1PortProxy;

public class TestService {

	public static void main(String[] args) throws RemoteException, FileNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		String user="";
		String pass="";
		Ideone_Service_v1PortProxy proxy=new Ideone_Service_v1PortProxy();
		/*TestFunctionResult result=new TestFunctionResult(proxy.testFunction(user, pass));
		System.out.println("Test Function : ");
		System.out.println(result.error);
		if(result.error.equals("OK")){
			System.out.println(result.pi);
			System.out.println(result.answerToLifeAndEverything);
			System.out.println(result.moreHelp);
			System.out.println(result.oOok);
		}
		GetLanguagesResult result1=new GetLanguagesResult(proxy.getLanguages(user, pass));
		System.out.println("Languages : ");
		System.out.println(result1.error);
		if(result1.error.equals("OK")){
			for(Entry<Integer, String> en:result1.langs.entrySet()){
				System.out.println(en.getKey()+" : "+en.getValue());
			}
		}*/
		Scanner scanner;
		String sourceCode = (scanner =new Scanner(new File("javaCode.txt"))).useDelimiter("\\Z").next();
		//System.out.println(sourceCode);
		scanner.close();
		int language=10;
		String input=null;
		boolean run=true;
		boolean _private=true;
		System.out.println("Creating new submissuion");
		CreateSubmissionResult result2=new CreateSubmissionResult(proxy.createSubmission(user, pass, sourceCode, language, input, run, _private));
		System.out.println("Checking submission status "+result2.link);
		GetSubmissionStatusResult result3=new GetSubmissionStatusResult(proxy.getSubmissionStatus(user, pass, result2.link));
		while(result3.status!=0){
			int st=result3.status;
			if(st<0)
				System.out.println("Status : waiting for comilation");
			else if(st==1)
				System.out.println("Status : compiling source code");
			else if(st==3)
				System.out.println("Status : Running program");
			Thread.sleep(2000);
			result3=new GetSubmissionStatusResult(proxy.getSubmissionStatus(user, pass, result2.link));
		}
		System.out.println("Status : Program has finished");
		System.out.println("Fetcing program result");
		boolean withSource,withInput,withOutput,withStderr,withCmpinfo;
		withSource=withInput=withOutput=withStderr=withCmpinfo=true;
		GetSubmissionDetailsResult result4=new GetSubmissionDetailsResult(proxy.getSubmissionDetails(user, pass, result2.link, withSource, withInput, withOutput, withStderr, withCmpinfo));
		if(result4.result==15){
			System.out.println("Language : "+result4.langName+" : "+result4.langVersion);
			System.out.println("Execution time : "+ result4.time);
			System.out.println("Time of submission : "+result4.date);
			System.out.println("Memory used : "+result4.memory);
			System.out.println("Output : "+result4.output);
			System.out.println("stderr output : "+result4.stderr);
			System.out.println("Compilation information : "+ result4.cmpinfo);
		}
		else
			System.out.println("Error running program result code is  : "+result4.result);
	}

}
