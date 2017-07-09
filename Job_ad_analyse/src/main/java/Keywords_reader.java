import java.io.*;
import java.net.URL;
import java.util.*;

public class Keywords_reader {
	
	private LinkedList<LinkedList<String>> keywords = new LinkedList<>();
	
	public Keywords_reader(String fileName){
		try {
			URL is = ClassLoader.getSystemClassLoader().getResource(fileName);
			File f = new File(is.toURI());
			Scanner in = new Scanner(f);
			while (in.hasNextLine()) {
				Scanner in_line = new Scanner(in.nextLine());
				LinkedList<String> ll = new LinkedList<>();
				while (in_line.useDelimiter(";").hasNext()) {
					ll.add(in_line.useDelimiter(";").next());					
				}
				keywords.add(ll);
				in_line.close();
			}
			in.close();
		} catch (Exception e) {
			System.out.println("Невозможно открыть файл ключевых слов.");
		}
	}

	public LinkedList<LinkedList<String>> getKeywords(){
		return keywords;
	}
	
}
