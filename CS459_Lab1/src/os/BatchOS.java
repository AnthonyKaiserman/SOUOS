package os;
import src.console.*;
import commands.*;

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
		String[] args = new String[argData.length - 1];
		System.arraycopy(argData, 1, args, 0, args.length);
		try{
			Class<?> className = Class.forName("commands." + argData[0]);
			CliCommand cli = (CliCommand)className.newInstance();
			cli.execute(args);
		}catch(Throwable thrown){
			batchOs.writeLine("java.classNotFoundException for "+ command);
			return;
		}
		
	}

}
