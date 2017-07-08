import java.util.ArrayList;

import org.jsoup.HttpStatusException;

public class Job_ad_analise {
	
	public static ArrayList<String> temp = new ArrayList<>();
	
	public static void main(String[] args) {
		Keywords_reader kr = new Keywords_reader();
		Job_links jl = new Job_links();
		temp = jl.get_links(1, 100, "Java");
//		int i = 0;
//		for (String counter: temp){
//			System.out.println(++i + " " + counter);
//		}
//		Чтение в 2 потока
		Runnable task1 = () -> {
			Page_parser pp = new Page_parser();
			for (int i = 0; i < temp.size(); i = i + 3) {
				try {
					System.out.println(i + " " + pp.URL_parser(temp.get(i)).substring(0, 20));
				} catch (HttpStatusException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Runnable task2 = () -> {
			Page_parser pp = new Page_parser();
			for (int i = 1; i < temp.size(); i = i + 3) {
				try {
					System.out.println(i + " " + pp.URL_parser(temp.get(i)).substring(0, 20));
				} catch (HttpStatusException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Runnable task3 = () -> {
			Page_parser pp = new Page_parser();
			for (int i = 2; i < temp.size(); i = i + 3) {
				try {
					System.out.println(i + " " + pp.URL_parser(temp.get(i)).substring(0, 20));
				} catch (HttpStatusException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread thread1 = new Thread(task1);
		Thread thread2 = new Thread(task2);
		Thread thread3 = new Thread(task3);
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
