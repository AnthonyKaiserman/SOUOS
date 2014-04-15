package os;
import java.io.IOException;

import src.console.*;


public class BatchOS implements CommandListener{
	
	OSConsole batchOs;

	public static void main(String[] args) {
		
		new BatchOS();
	}
	public BatchOS(){
		batchOs = new OSConsole("BatchOS");
		batchOs.setCommandListener(this);
		}
	
	@Override
	public void commandReceived(String command) 
	{
		String[] argData = command.split(" ");
		argData[0] = Character.toUpperCase(argData[0].charAt(0)) + argData[0].substring(1);
		String[] args = new String[argData.length - 1];
		System.arraycopy(argData, 1, args, 0, args.length);
		try{
			Class<?> className = Class.forName("commands." + argData[0]);
			CliCommand cli = (CliCommand)className.newInstance();
			batchOs.writeLine(cli.execute(args));
		}catch(Throwable thrown){
			if (thrown instanceof ClassNotFoundException){
				batchOs.writeLine("java.lang.ClassNotFoundException for "+ command);
				return;
			}else if(thrown instanceof IOException){
				batchOs.writeLine("java.io.IOException for "+ command);
			}else if(thrown instanceof InstantiationException){
				batchOs.writeLine("java.lang.InstantiationException for "+ command);
			}else{
				batchOs.writeLine("java.Throwable Exception for " + command);
			}
		}	
	}

}
