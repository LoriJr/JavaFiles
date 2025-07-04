package app;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		File file = new File("c:\\in.txt");
		
		Scanner sc = null;
		
		try {
			sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
				
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally { //boa prática adicionar o finally para encerrar o código 
			if(sc != null) {
				sc.close();
			}
		}

	}

}
