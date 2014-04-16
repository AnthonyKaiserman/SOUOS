package commands;

import os.CliCommand;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Run extends CliCommand{
	public Run(){}
	public String execute(String[] arg) throws InstantiationException, IllegalAccessException, IOException{
		File file = new File(ROOT, arg[0]+".bat");
		trace = new PrintWriter(file.getCanonicalFile());
		String str = "";
		while(!runList.isEmpty()){
			str += runList.deQueue().run(trace);	
		}
		trace.flush();
		trace.close();
		if (str == "")
			return "Error: Queue is empty";
		else
			return str;
	}
}
