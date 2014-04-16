package commands;

import os.CliCommand;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class Run extends CliCommand{
	public Run(){}
	public String execute(String[] arg) throws InstantiationException, IllegalAccessException, IOException{
		File file = new File("c:/Users/Striker/workspaceOS/Output/ouptputfile.txt");
		if(!file.exists())
		{
			file.createNewFile();
		}
		
		trace = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		while(!runList.isEmpty()){
			process = runList.peek();
			process.run(trace);
			runList.deQueue();
		}
		trace.flush();
		return "Batch has been run";
	}
}
