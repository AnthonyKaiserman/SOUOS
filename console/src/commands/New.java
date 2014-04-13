package commands;

import os.CliCommand;
import os.ProcessList;

public class New extends CliCommand{
	public New(){
		super();
	}
	@Override
	public void execute(String[] args){
		runList = new ProcessList();	
	}
}
