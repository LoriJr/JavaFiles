package app;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;


public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter file path:");
		String filePath = sc.nextLine();
		
		File sourceFile = new File(filePath);
		String sourceFolder = sourceFile.getParent();
		
		boolean success = new File(sourceFolder + "\\out").mkdir();
		
		String targetFile = sourceFolder + "\\out\\summary.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			
			String itemCSV = br.readLine();
			
			while(itemCSV != null) {
				
				String[] vect = itemCSV.split(",");
				String name = (vect[0]);
				double price = Double.parseDouble(vect[1]);
				int quantity = Integer.parseInt(vect[2]);
				
				list.add(new Product(name, price,quantity));
				
				itemCSV = br.readLine();
			}
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile))){
				
				for(Product item: list) {
					bw.write(item.getName() + "," + String.format("%.2f", item.total()));
					bw.newLine();
				}
				
				System.out.println(targetFile + " CREATED");
			}
			catch(IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();			

	}

}
