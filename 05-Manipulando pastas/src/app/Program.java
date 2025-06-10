package app;

import java.io.File;

public class Program {

	public static void main(String[] args) {
		
		String path = "c:\\py";
		File p = new File(path);
		
		File[] folders = p.listFiles(File::isDirectory);
		System.out.println("FOLDERS:");
		for(File folder: folders) {
			System.out.println(folder);
		}
		
		File[] files = p.listFiles(File::isFile);
		System.out.println("FILES:");
		for(File file : files) {
			System.out.println(file);
		}
		
		boolean success = new File(p + "\\sudir").mkdir();
		System.out.println("Directory created successfully: " + success);

	}

}
