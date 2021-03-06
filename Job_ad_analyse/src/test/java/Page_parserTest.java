import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.net.URL;

import org.jsoup.HttpStatusException;
import org.junit.Test;

public class Page_parserTest {
	
	Page_parser pp = new Page_parser(null);

	@Test
	public void testFile_parser() throws URISyntaxException {
		URL is = ClassLoader.getSystemClassLoader().getResource("test_page1.html");
		String filename = is.toURI().getPath();
		assertEquals("��� ����� �������, ������� ����� �������������"
				+ " ������ ��������� �������� � ������ � ������� ��������������."
				+ " ������ Java, ������ �������! ���� �� ������ �������� � ������ ������������ "
				+ "� ����������� ������� � ��������� ��������, �������� ������ ������ ������������,"
				+ " � ���������, �����������. �� �������, ��� �� ������: ��������������� �� Java; ��������"
				+ " � ������������ ������ ������; ����������� ����������� ���. ������� ����� ����: ��������������"
				+ " ����������������; ���������� ��� Unix ��� Linux; ������ � ��������� ����������� ����������"
				+ " (Jenkins, Teamcity � ��.); ����������� ���������� (jstack, jmap, jstat, VisualVM � ��.). "
				+ "� ����� ������: ���������� ���� (PostgreSQL, Oracle, MySQL, MS SQL); ������� ���������� (TCP\\IP, UDP, HTTP);"
				+ " ������� ���������� � �������� ������; ������� � ��������� ��������������.", pp.File_parser(filename));
	}

	@Test
	public void testURL_parser() throws HttpStatusException {
		assertEquals("�����������: ��������� �� ������� ������������ �� ��������� 1�8.11.3 ��������� "
				+ "���������, �������, �������� ����. ��������� ������� ����������� � 1� ��������� ������"
				+ " ������� ����� ���������� ��������������� ������. ����������: ������ ����������� 1�8 �������"
				+ " ���������� �������������� ���������������� ������ ���� ������ �� ����� 3-� ��� �������: ���� ��������"
				+ " ��������� � 3 �� �� ����������� �����, 15 ��� �� ��.��. \"��������\" ������ ������ 5/2 � 9.00 "
				+ "- 18.00 ���������� ����� - 80 ��� ��� ����� +20��� ������ �� ����������� ������� �������������"
				+ " ���� 2 ���", pp.URL_parser("https://spb.hh.ru/vacancy/21336069?query=�����������"));
	}

}
