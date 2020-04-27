package com.lec.java.crawl04;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl04Main {
	
	public static void main(String[] args) throws IOException {
		System.out.println("네이버 연관 검색어");
		
		String url;
		Document doc;
		Element element;
		Elements elements;
		Response response;
		
		String searchKeyword;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력하세요: ");
		searchKeyword = sc.nextLine();
		sc.close();
		
		String encoded = URLEncoder.encode(searchKeyword, "UTF-8"); // 한글 글자로 UTF-8(한글 개당 3바이트)인지, euc-kr(한글 개당 2바이트)인지 확인
		// 네이버 검색 페이지는
		
		url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=" + encoded;
//		System.out.println(url); // 생성된 url 확인
		
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("div#nx_related_keywords ul._related_keyword_ul li a");
		System.out.println(elements.size());
		
		for(Element e : elements) {
			System.out.println(e.text().trim());
		}
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class
