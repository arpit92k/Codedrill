package main;

public class mainClass {

	public static void main(String[] args) {
		if(args[0].equals("-v")){
			if(args.length==2)
				new ExecCode(args[1],false);
			else if(args.length==3)
				new ExecCode(args[1],args[2],false);
			else
				System.err.println("Invalid use refer documentation");
		}
		else{
			if(args.length==1)
				new ExecCode(args[0]);
			else if(args.length==2)
				new ExecCode(args[0],args[1],true);
			else
				System.err.println("Invalid use refer documentation");
		}
	}

}
