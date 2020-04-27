package com.lec.java.crawl03;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {

	public static void main(String[] args) throws IOException {
		System.out.println("Daum 실시간 검색어");
		
		//TODO
		// https://www.daum.net/
		// 15개
		// class slide_favorsch li
		String url = "https://www.daum.net/";
		File f;
		Element element;
		Elements elements;
		Response response;
		Document doc;
		
		f = new File(url);
		response = Jsoup.connect(url).execute();
		System.out.println(response.statusCode());
		System.out.println(response.statusMessage());
		
		doc = response.parse();
		
		elements = doc.select("div.slide_favorsch li a");
		System.out.println();
		System.out.println(elements.size() + " 개");
				
		for(Element e : elements) {
			System.out.println(e.text().trim());
			System.out.println(e.attr("href").trim());
		}
		
		System.out.println("\n프로그램 종료");
	} // main() end

} // class end
