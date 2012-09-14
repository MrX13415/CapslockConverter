import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;

/**
 * This program demonstrates how to write a Java Console Application.
 * This works currently in Windows only. (Should be a way for Linux, etc. too)
 * It is properly not very well coded, and only an example ...
 * 
 * 
 * License:
 * 
 *  CreativeCommons Attribution-NonCommercial-ShareAlike 3.0 Unported (CC BY-NC-SA 3.0)
 * 
 *   For more Informations:
 *   http://creativecommons.org/licenses/by-nc-sa/3.0/
 * 
 *  
 * @author MrX13415
 *
 */
public class CapslockConverter {

	public static void main(String[] args){

		if (System.console() == null){
			openWithConsole();
		}	
		
		BufferedReader c = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("CAPSLOCK CONVERTER v1.1 (C) MrX13415\n");
		System.out.println("Enter $help for Help\n");
				
		while (true) {

			try {
				System.out.print("Input:  ");

				String input = c.readLine();
				
				if (input.equalsIgnoreCase("$exit")) System.exit(0);
			
				String output = input.toUpperCase();

				if (input.equalsIgnoreCase("$cat")) output = "MEOW :3";
				if (input.equalsIgnoreCase("$help")) output = "$help\tThis Help screen\n\t$cat\tMeow\n\t$exit\tExit\n"; 
					
				System.out.println("\nOutput: " + output + "\n");
			} catch (IOException e) {
			}

		}
	}

	
	public static void openWithConsole(){
		String path = CapslockConverter.class.getProtectionDomain()
				.getCodeSource().getLocation().getPath();
		String decodedPath = "";
		try {
			decodedPath = URLDecoder.decode(path, "UTF-8")
					.replace("/", "\\").substring(1);
		} catch (Exception e) {
			e.printStackTrace();
		}// new
			// File(System.getProperty("java.home"),"bin\\java.exe").getAbsolutePath()

		String p = "cmd /c \"\"" +
				new File(System.getProperty("java.home"), "bin\\java.exe")
				.getAbsolutePath() + "\" -jar \"" + decodedPath + "\"\"";

		if (decodedPath.endsWith("\\")){
		p = "cmd /c \"\"" +
			new File(System.getProperty("java.home"), "bin\\java.exe")
			.getAbsolutePath() + "\" \"" +
			CapslockConverter.class.getName() + "\"\"";
		}
		
		System.out.println("\nOpen Console first ... \n" + p + "\n\n");
		try {

			// Runtime.getRuntime().exec(p);

			Runtime rt = Runtime.getRuntime();
			rt.exec("cmd.exe /c start " + p + "", null, new File(decodedPath.endsWith("\\") ? decodedPath : decodedPath.substring(0, decodedPath.lastIndexOf("\\") + 1)));

		} catch (Exception exc) {
			System.out.println(exc);
		}
		System.exit(0);
	}
}
