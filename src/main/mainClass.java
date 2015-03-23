package main;

public class mainClass {

	public static void main(String[] args) {
		if(args.length==1)
			new ExecCode(args[0],false);
		else
			System.err.println("Invalid use refer documentation");
	}

}
