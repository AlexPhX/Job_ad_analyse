import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class Description_parserTest {
	
	ArrayList<String> ads = new ArrayList<>();
	
	@Before
	public void setUp() throws Exception {
		URL is = ClassLoader.getSystemClassLoader().getResource("ad_test.txt");
		File f = new File(is.toURI().getPath());
		Scanner in = new Scanner(f);
		while (in.hasNextLine()) {
			ads.add(in.nextLine());
		}
		in.close();
	}

	@Test
	public void testGet_Words() {
		Description_parser dp = new Description_parser();
		Keywords_reader kr = new Keywords_reader("keywords.txt");
		int[] test = new int[kr.getKeywords().size()];
		for (int i = 0; i<ads.size(); i++) {
			test = dp.get_Words(ads.get(i), kr.getKeywords());
			System.out.print(i + 1 + " : ");
			Arrays.stream(test).forEach(item -> System.out.print(item + " "));
			System.out.println();
		}
	}

}
