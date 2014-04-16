package commands;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import os.CliCommand;

public class Cat extends CliCommand{

	@Override
	public String execute(String[] args) {
		String strVar = null;
		StringBuffer strBuffer = new StringBuffer();
		try{
			File file = new File(ROOT, args[0]);
			BufferedReader in = new BufferedReader(new FileReader(file.getCanonicalPath()));
			while((strVar = in.readLine())!= null){
				strBuffer.append(strVar);
				strBuffer.append("\n");
			}
			in.close();
		}catch(IOException ioe){
			return "ERROR: File does not Exist! " + args[0];
		}
		return strBuffer.toString();
	}
}
