package com.lec.java.crawl07;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/*
 * 검색어 입력 받아서,
 * 첫페이지의 '국내도서' 카테고리 20개 아이템 크롤링
 * 	책이름, 책가격, 상세페이지 주소, 썸네일 주소 
 * 
 * yes24.com 검색페이지는 euc-kr 로 URL 인코딩 되어있다.
 * 		한글 한글자당 2바이트 인코딩
 * 
 */


public class Crawl07Main {

	private static final String PATH = "books";
	
	public static void main(String[] args) throws IOException {
		System.out.println("인터파크 도서 책 정보 검색결과");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력하세요: ");
		String search = sc.nextLine();
		sc.close();
		
		Crawl07Main app = new Crawl07Main();
		ArrayList<InfoBook> list = app.crawlInterPark(search); // 검색어 입력 받아서 검색!! 
		
		// 썸네일 이미지 다운로드 받아서
		// thumb001.jpg ~ thumb020.jpg...
		
		int fileIndex = 1;
		for(InfoBook e :list) {
			System.out.println(e); // 크롤링 정보 출력
		
			//썸네일 이미지 다운로드
			String fileName = String.format(PATH + File.separator + "thumb%03d.jpg", fileIndex);
			URL imgUrl = new URL(e.getImgUrl());
			
			BufferedImage imgData = ImageIO.read(imgUrl);
			File file = new File(fileName);
			ImageIO.write(imgData, "jpg", file);
			System.out.println(fileName + " 이 저장되었습니다.");
			
			fileIndex++;
		}
		
		System.out.println("\n프로그램 종료");
		
	}// main() end
	
	
	

	private ArrayList<InfoBook> crawlInterPark(String search) throws IOException {
		ArrayList<InfoBook> list = new ArrayList<InfoBook>();
		
		String url;
		Document doc;
		Response response;
		Element element;
		Elements rowElements;
		Matcher matcher;
		String regex = "^[1-9][0-9]*";
		Pattern pattern = Pattern.compile(regex);
		String transNum = "";
		
		url = "http://bsearch.interpark.com/dsearch/book.jsp?sch=all&sc.shopNo=&bookblockname=s_main&booklinkname=s_main&bid1=search_auto&bid2=product&bid3=000&bid4=001&query="
				+ URLEncoder.encode(search, "euc-kr");
//		System.out.println(url);
		
		doc = Jsoup.connect(url).execute().parse();
		
		
		rowElements = doc.select("#bookresult > form > .list_wrap");
		System.out.println(rowElements.size());
		
		for(Element e : rowElements) {
		
			String imgUrl = e.selectFirst("div.bimgWrap > a > img").attr("src").trim();
//			System.out.println(imgUrl);
		
			Element infoElement = e.selectFirst("p.tit > b > a");
			
			String bookTitle = infoElement.text().trim();
			String linkUrl = infoElement.attr("href").trim();
//			String priceStr = e.selectFirst(" div.price > p.FnowCoupon > span").text().trim().replace(",", "").split("원")[0];
//			double price = Double.parseDouble(priceStr);
			
			String priceStr = e.selectFirst(" div.price > p.FnowCoupon > span").text().trim().replace(",", "");
			matcher = pattern.matcher(priceStr);
//			System.out.println(matcher.group());
			
//			System.out.println(matcher.find());
			
			while(matcher.find()) {
				transNum = matcher.group();
			}
//			
//			
			double price = Double.parseDouble(transNum);
			
//			double price = Double.parseDouble(pattern.matcher(priceStr).group()); // 정규표현식 왜 안되는지 모르겟습니다 ㅜㅜ 
			
			// err: java.lang.IllegalStateException
			// debugging
			/*
				 public String group(int group) {
			        if (first < 0)
			            throw new IllegalStateException("No match found");
			        if (group < 0 || group > groupCount())
			            throw new IndexOutOfBoundsException("No group " + group);
			        if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
			            return null;
			        return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
			    	}
			    	
			    	IllegalStateException
		     *          If no match has yet been attempted,
		     *          or if the previous match operation failed
			 */
			
			
//			System.out.println(priceStr);
//			System.out.println(bookTitle + " : " + linkUrl);
//			System.out.println(price + "원");
			
			list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));
		}
		
		// 첫페이지의 '국내도서' 카테고리 20개 아이템 크롤링
		// 	책이름, 책가격, 상세페이지 주소, 썸네일 주소 , 썸네일 다운로드 
		
		return list;
		
	}// crawlYes24() end
	
}// class end
