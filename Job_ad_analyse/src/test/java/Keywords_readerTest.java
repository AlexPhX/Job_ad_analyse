import static org.junit.Assert.*;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class Keywords_readerTest {

	LinkedList<String> testll = new LinkedList<>();
	
	@Before
	public void setUp() {
		testll.add("Java ");
		testll.add("Java.");
		testll.add("Java,");
		testll.add("JSE");
		testll.add("JEE");
		testll.add("Джав");
		testll.add("J2EE");		
	}
	
	@Test
	public void testGetKeywords() {
		Keywords_reader kr = new Keywords_reader("keywords.txt");
//		kr.getKeywords().forEach(item -> {
//			item.forEach(inner_item ->
//				System.out.print(inner_item + ";"));
//				System.out.println();});
		assertEquals(testll, kr.getKeywords().get(0));
	} 

}
