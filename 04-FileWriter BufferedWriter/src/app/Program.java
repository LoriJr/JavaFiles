package app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		
		String p = "c:\\py\\arquivo.txt";
		String texto = "Aqui é um texto teste";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(p, true))) 
		{		
			bw.write(texto);
		}
		catch(IOException e) {
			e.printStackTrace();
			
		}		

	}

}
