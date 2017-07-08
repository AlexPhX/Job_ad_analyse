import java.io.*;
import java.net.URL;
import java.util.*;

public class Keywords_reader {
	
	ArrayList<String> keywords = new ArrayList<>();
	
	public Keywords_reader(){
		try {
			URL is = ClassLoader.getSystemClassLoader().getResource("keywords.txt");
			File f = new File(is.toURI());
			Scanner in = new Scanner(f);
			while (in.hasNextLine()) {
				keywords.add(in.nextLine());
			}
			in.close();
		} catch (Exception e) {
			System.out.println("Невозможно открыть файл ключевых слов.");
		}
	}
	
	public ArrayList<String> getKeywords(){
		return keywords;
	}
	
}
