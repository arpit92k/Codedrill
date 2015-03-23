package main;

import java.rmi.RemoteException;

import soapServiceUtill.*;

import com.ideone.api._1.service.Ideone_Service_v1PortProxy;

public class ExecCode {
	private final String user="codedrill";
	private final String pass="megacode";
	private boolean run;
	private boolean _private;
	private String sourceCode;
	private int language;
	private String input;
	private Ideone_Service_v1PortProxy proxy;
	public ExecCode(String file,String inputFile,boolean outputOnly){
		try{
			sourceCode = UtilityFunctions.readFile(file);
			language=UtilityFunctions.getLangCode(file);
			input=UtilityFunctions.readFile(inputFile);
			run=true;
			_private=true;
			if(outputOnly)
				runOutputOnly();
			else
				runVerbose();
		}
		catch (Exception e){
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
	}
	public ExecCode(String file,boolean outputOnly){
		try{
			sourceCode = UtilityFunctions.readFile(file);
			language=UtilityFunctions.getLangCode(file);
			input=null;
			run=true;
			_private=true;
			if(outputOnly)
				runOutputOnly();
			else
				runVerbose();
		}
		catch (Exception e){
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
	}
	public ExecCode(String file){
		try{
			sourceCode = UtilityFunctions.readFile(file);
			language=UtilityFunctions.getLangCode(file);
			input=null;
			run=true;
			_private=true;
			runOutputOnly();
		}
		catch (Exception e){
			System.err.println(e.getMessage());
			System.err.println(e.getStackTrace());
		}
	}
	private void runVerbose() throws RemoteException, InterruptedException {
		System.out.println("Connecting...");
		Ideone_Service_v1PortProxy proxy=new Ideone_Service_v1PortProxy();
		System.out.println("Uploading source...");
		CreateSubmissionResult submission=new CreateSubmissionResult(proxy.createSubmission(user, pass, sourceCode, language, input, run, _private));
		System.out.println("Waiting for results...");
		GetSubmissionStatusResult status=new GetSubmissionStatusResult(proxy.getSubmissionStatus(user, pass, submission.link));
		while(status.status!=0){
			if(status.status<0)
				System.out.println("Waiting for compilation");
			else if(status.status==1)
				System.out.println("Compiling source");
			else if(status.status==3)
				System.out.println("Program is being executed");
			Thread.sleep(2000);
			status=new GetSubmissionStatusResult(proxy.getSubmissionStatus(user, pass, submission.link));
		}
		boolean withSource,withInput,withOutput,withStderr,withCmpinfo;
		withSource=withInput=withOutput=withStderr=withCmpinfo=true;
		GetSubmissionDetailsResult result=new GetSubmissionDetailsResult(proxy.getSubmissionDetails(user, pass, submission.link, withSource, withInput, withOutput, withStderr, withCmpinfo));
		System.out.println("Language name : "+result.langName);
		System.out.println("Language Version : "+result.langVersion);
		System.out.println("Time : "+result.time);
		System.out.println("Date : "+result.date);
		System.out.println("Memory : "+result.memory);
		System.out.println("Signal : "+result.singnal);
		System.out.println("Sandard Error : "+result.stderr);
		System.out.println("Compile info : "+result.cmpinfo);
		System.out.println("Output : \n"+result.output);
		if(result.result!=15)
			System.err.println("ERROR : "+UtilityFunctions.getErrorDesc(result.result));
	}
	private void runOutputOnly() throws RemoteException, InterruptedException {
		proxy=new Ideone_Service_v1PortProxy();
		CreateSubmissionResult submission=new CreateSubmissionResult(proxy.createSubmission(user, pass, sourceCode, language, input, run, _private));
		GetSubmissionStatusResult status=new GetSubmissionStatusResult(proxy.getSubmissionStatus(user, pass, submission.link));
		while(status.status!=0){
			Thread.sleep(2000);
			status=new GetSubmissionStatusResult(proxy.getSubmissionStatus(user, pass, submission.link));
		}
		boolean withSource,withInput,withOutput,withStderr,withCmpinfo;
		withSource=withInput=withOutput=withStderr=withCmpinfo=true;
		GetSubmissionDetailsResult result=new GetSubmissionDetailsResult(proxy.getSubmissionDetails(user, pass, submission.link, withSource, withInput, withOutput, withStderr, withCmpinfo));
		System.out.println(result.output);
		if(result.result!=15)
			System.err.println("ERROR : "+UtilityFunctions.getErrorDesc(result.result));
	}
}
