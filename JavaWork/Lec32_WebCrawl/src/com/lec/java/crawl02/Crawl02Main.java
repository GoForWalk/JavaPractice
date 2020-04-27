package com.lec.java.crawl02;

import java.io.File;
import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl02Main {
	public static void main(String[] args) throws IOException {
		System.out.println("네이트 인기 검색어");
		
		//TODO
		// www.nate.com
		
		String url = "https://www.nate.com";
		File f = new File(url);
		Document doc;
		Element element;
		Elements elements;
		Response response;
		
		response = Jsoup.connect(url).execute();
		System.out.println(response.statusCode());
		System.out.println(response.statusMessage());
		
		doc = response.parse();
		
		
		elements = doc.select("div.search_keyword a");
		System.out.println(elements.size() + " 개");
		
		
		for(Element e : elements){
			System.out.println(e.text().trim());
		}
		
		System.out.println("\n프로그램 종료");
	}
}
