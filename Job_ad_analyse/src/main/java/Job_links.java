import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Job_links {
	
	final private static int NUMBER_OF_AD = 200;
	final private static String DEFAULT_WORD = "Программист";
	
	private ArrayList<String> get_page_links(String req) throws IOException{
		ArrayList<String> res =new ArrayList<>();
		try {
			Document doc = Jsoup.connect(req).get();
			Elements links = doc.select("[data-position]");
			for (int i = 0; i < links.size(); i++)
				res.add(links.get(i).attr("abs:href"));
		} catch (HttpStatusException e){
			if (e.getStatusCode() == 404)
				System.out.println("Окончание чтения.");
			throw e;			
		} catch (Exception e) {
			throw e;
		}
		return res;
	}
	
	public ArrayList<String> get_total_links(int number_of_ad, String keyword) {
		ArrayList<String> res = new ArrayList<>();
		int i = 0;
		final String req = "https://spb.hh.ru/search/vacancy?items_on_page=" + number_of_ad
							+ "&clusters=true&area=2&enable_snippets=true&"
							+ "text=" + keyword + "&no_magic=true&page=";
		while (true){
			try {
				get_page_links(req+i).forEach(obj -> res.add(obj));
				i++;
			} catch (IOException e) {
				break;
			}
		}
		return res;
	}	
	
	public ArrayList<String> get_total_links() {
		return this.get_total_links(NUMBER_OF_AD, DEFAULT_WORD);
	}
	
	public ArrayList<String> get_links(int num, int number_of_ad, String keyword) {
		ArrayList<String> res = new ArrayList<>();
		final String req = "https://spb.hh.ru/search/vacancy?items_on_page=" + number_of_ad
							+ "&clusters=true&area=2&enable_snippets=true&"
							+ "text=" + keyword + "&no_magic=true&page=";
		for (int i = 0; i < num; i++){
			try {
				get_page_links(req+i).forEach(obj -> res.add(obj));
			} catch (IOException e) {
				break;
			}
		}
		return res;
	}
	
}
