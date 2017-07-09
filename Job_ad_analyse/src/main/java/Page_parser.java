import java.io.File;
import java.util.ArrayList;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Page_parser implements Runnable {
	
	private ArrayList<String> links = new ArrayList<>();
	ArrayList<String> parsestrings = new ArrayList<>();
	
	public Page_parser(ArrayList<String> links){
		this.links = links;
	}
	
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
		} catch (HttpStatusException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<String> getParsestrings() {
		return parsestrings;
	}

	@Override
	public void run() {
		boolean done =false;
		for (String link: links){
			while (!done)
			try {
				parsestrings.add(URL_parser(link));
				done = true;
			} catch (HttpStatusException e) {
				if (e.getStatusCode() == 429)
					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					} 
				else {
					e.printStackTrace();
					break;
					}
				}
			done = false;
		}
	}	

}
