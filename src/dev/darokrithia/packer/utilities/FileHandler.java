package dev.darokrithia.packer.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileHandler {
	
	public static String loadFile(String path){
		StringBuilder sb = new StringBuilder();
				
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			
			while((line=br.readLine()) != null){
				 sb.append(line + "\n");
			}
			br.close();
			return sb.toString();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static void saveToFile(){
		
	}
	public static int parseInt(String str){
		try{
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}
}
