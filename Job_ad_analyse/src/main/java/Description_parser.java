import java.util.LinkedList;
import java.util.ListIterator;

public class Description_parser {

	public int[] get_Words(String text, LinkedList<LinkedList<String>> keywords){
		int[] res = new int[keywords.size()];
		for (int i = 0; i < keywords.size(); i++){
			ListIterator<String> li =keywords.get(i).listIterator();
			while (li.hasNext()) {
				if (text.toLowerCase().contains(li.next().toLowerCase())) {
					res[i] = 1;
					break;	
				}
			}
		}
		return res;
	}
	
}
