import java.io.File;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Page_parser {
	
	public String File_parser(String filename){
		try {
			File f = new File(filename);
			Document doc = Jsoup.parse(f, "UTF-8");
			Elements el = doc.select("[itemprop=\"description\"]");
			return el.get(0).text();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public String URL_parser(String url) throws HttpStatusException {
		try {
			Document doc = Jsoup.connect(url).get();
			Elements el = doc.select("[itemprop=\"description\"]");
			return el.get(0).text();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}	

}
