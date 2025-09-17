package tutorialVideoÜbungen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ImportText {

	public static void main(String[] args) {
		File datei=new File("Uebung.txt");
		try {
			FileWriter writer=new FileWriter(datei, true);
			writer.write("Zeile 1 \n");
			writer.write("Zeile 2 \n");
			writer.write("Zeile 3 \n");
			writer.flush();
			writer.close();
			Scanner scan=new Scanner(datei);
			while(scan.hasNextLine()) {
			System.out.println(scan.nextLine());}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
