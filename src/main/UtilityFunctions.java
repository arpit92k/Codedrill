package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import exception.LanguageNotSupportedException;

public class UtilityFunctions {
	public static int getLangCode(String fileName) throws LanguageNotSupportedException{
		String ext=fileName.substring(fileName.lastIndexOf('.')+1);
		if(ext.equals("java"))
			return 10;
		if(ext.equals("cpp"))
			return 1;
		if(ext.equals("c"))
			return 11;
		if(ext.equals("pl"))
			return 3;
		if(ext.equals("py"))
			return 4;
		if(ext.equals("php"))
			return 29;
		throw new LanguageNotSupportedException(ext);
	}
	/*public static String getLangName(int langCode) throws LanguageNotSupportedException{
		if(langCode==10)
			return "Java";
		throw new LanguageNotSupportedException("Invalid language code : "+langCode);
	}*/
	public static String readFile(String fileName) throws FileNotFoundException{
		Scanner scanner;
		String content = (scanner =new Scanner(new File(fileName))).useDelimiter("\\Z").next();
		scanner.close();
		return content;
	}
	public static String getErrorDesc(int code){
		switch(code){
			case 11 :
				return "Compilation Error";
			case 12:
				return "Runtime Error";
			case 13:
				return "Time Linit Exceeded";
			case 15:
				return "Success no error ";
			case 17:
				return "Memory limit Exceeded";
			case 19:
				return "Illegal system call";
			case 20:
				return "Internel error at ideone server please try again";
			default:
				return "Unknown Error : "+code;
		}
	}
}
