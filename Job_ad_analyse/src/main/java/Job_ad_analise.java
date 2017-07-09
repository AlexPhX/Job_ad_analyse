import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class Job_ad_analise {
	
	private static void desc_out(ArrayList<String> data, String fileName) {
	    //���������� ����
		URL is = ClassLoader.getSystemClassLoader().getResource(fileName);
		try {
			File file = new File(is.toURI());
		    try {
		        //���������, ��� ���� ���� �� ���������� �� ������� ���
		        if(!file.exists()){
		            file.createNewFile();
		        }
		 
		        //PrintWriter ��������� ����������� ������ � ����
		        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
		 
		        try {
		            //���������� ����� � ����
		            for (String item: data)
		            	out.println(item);
		            	
		        } finally {
		            //����� ���� �� ������ ������� ����
		            //����� ���� �� ���������
		            out.close();
		        }
		    } catch(IOException e) {
		        throw new RuntimeException(e);
		    }
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	private static void parse_result(ArrayList<String> data, String fileName) {
	    //���������� ����
		URL is = ClassLoader.getSystemClassLoader().getResource(fileName);
		try {
			File file = new File(is.toURI());
		    try {
		        //���������, ��� ���� ���� �� ���������� �� ������� ���
		        if(!file.exists()){
		            file.createNewFile();
		        }
		 
		        //PrintWriter ��������� ����������� ������ � ����
		        PrintWriter out = new PrintWriter(file.getAbsoluteFile());
		 
		        try {
		            //���������� ����� � ����
		    		Keywords_reader kr = new Keywords_reader("keywords.txt");
		    		Description_parser dp = new Description_parser();
		    		int[] res = new int[kr.getKeywords().size()];
		    		for (int i = 0; i<data.size(); i++) {
		    			res = dp.get_Words(data.get(i), kr.getKeywords());
		    			out.print(i + 1 + " : ");
		    			Arrays.stream(res).forEach(item -> out.print(item + " "));
		    			out.println();
		    		}
		            	
		        } finally {
		            //����� ���� �� ������ ������� ����
		            //����� ���� �� ���������
		            out.close();
		        }
		    } catch(IOException e) {
		        throw new RuntimeException(e);
		    }
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		Job_links jl = new Job_links();
		ArrayList<String> links = jl.get_links(10, 100, "�����������");
		Page_parser pp1 = new Page_parser(new ArrayList<String>(links.subList(0, links.size()/2)));
		Page_parser pp2 = new Page_parser(new ArrayList<String>(links.subList(links.size()/2, links.size())));
		//������ �������
		Thread t1 = new Thread(pp1, "T1");
		Thread t2 = new Thread(pp2, "T2");
		t1.start();
		t2.start();
		while (t1.isAlive() || t2.isAlive());
		ArrayList<String> result = new ArrayList<>();
		result.addAll(pp1.getParsestrings());
		result.addAll(pp2.getParsestrings());
		desc_out(result, "descriptions.txt");
		parse_result(result, "output.txt");
	}
}
