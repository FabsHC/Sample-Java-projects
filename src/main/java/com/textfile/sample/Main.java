package com.textfile.sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

	private static String FILE_NAME = "texto.txt";
	
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		String opcao = new String("");
		while(opcao!=null) {
			System.out.println("1)Input new line");
			System.out.println("2)Read file");
			System.out.println("3)Exit");
			System.out.print("->");
			opcao = sc.nextLine();
			switch (opcao) {
			case "1":
				System.out.print("Write the new input: ");
				inputNewLine(sc.nextLine());
				break;
			
			case "2":
				readFile();
				break;
				
			case "3":
				System.out.println("GOOD BYE!!!!");
				sc.close();
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}

	private static void readFile() throws Exception{
		System.out.println("\n--READING--");
		BufferedReader reader = new BufferedReader(new FileReader(getFile(FILE_NAME)));
		System.out.println("--START--");
		String line = reader.readLine();
		while (line!=null) {
			System.out.println(line);
			line=reader.readLine();
		}
		System.out.println("--END--\n");
		reader.close();
	}

	private static void inputNewLine(String newLine) throws Exception{
		BufferedWriter writer = new BufferedWriter(new FileWriter(getFile(FILE_NAME), true));
		writer.newLine();
		writer.write(newLine);
		writer.flush();
		writer.close();
		System.out.println("--SAVING--\n");
	}

	private static File getFile(String file) throws Exception{
		return new File(Main.class.getClassLoader().getResource(file).toURI());
	}

}
