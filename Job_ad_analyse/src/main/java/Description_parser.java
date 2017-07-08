import java.util.ArrayList;

public class Description_parser {

	public int[] get_Words(String text, ArrayList<String> keywords){
		int[] res = new int[keywords.size()];
		for (int i = 0; i < keywords.size(); i++){
			if (text.toLowerCase().contains(keywords.get(i).toLowerCase())) res[i] = 1;
		}
		return res;
	}
	
}
