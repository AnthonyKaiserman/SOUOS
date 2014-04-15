package commands;

import os.CliCommand;

public class Run extends CliCommand{
	public Run(){}
	public String execute(String[] arg) throws InstantiationException, IllegalAccessException{
		String str = null;
		while(!runList.isEmpty()){
			str += runList.deQueue().run(trace);
		}
		if (str == null)
			return "Error: Queue is empty";
		else
			return str;
	}
}
