package com.lec.java.crawl11;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

/*
 * XML , JSON 파싱 연습
 * 
 * ■서울시 지하철 역사 정보
		http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1
		
		샘플url
		
		XML 버젼
		http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/stationInfo/1/5/서울
		
		JSON 버젼
		http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/서울

	

 *  	 statnNm(STring), subwayId(int), subwayNm(String)
 */


public class Crawl11Main {

	public static final String REQ_SERVICE = "stationInfo"; // TODO
	public static final String API_KEY = "4e74654971736d613438694b614145";
	
	public static void main(String[] args) throws IOException {
		System.out.println("서울시 지하철 역사(station) 정보");
		
		int startIndex = 1; // 요청시작 위치 정수 입력 (페이징 시작번호 입니다 : 데이터 행 시작번호)
		int endIndex = 4;   // 요청 종료위치 정수 입력 (페이징 끝 번호 입니다 : 데이터 행 끝번호)
//		String date;	//날짜 yyyymmdd 형식 
		String statnNm = "왕십리";
		
		String url_address = "";
		StringBuffer sb;   // response 받은 텍스트
		
		// TODO : API url 에 필요한 parameter 들
		
		System.out.println();
		System.out.println("--- XML 파싱 ---");
		url_address = buildUrlAddress("xml", statnNm ,startIndex, endIndex);
		System.out.println(url_address);
		sb = readFromUrl(url_address);
		System.out.println(sb);
		parseXML(sb.toString());
		
		
		System.out.println("--- JSON 파싱 ---");
		url_address = buildUrlAddress("json",statnNm ,startIndex, endIndex);
		System.out.println(url_address);
		sb = readFromUrl(url_address);
		parseJSON(sb.toString());
		
		System.out.println("\n프로그램 종료");
	} // main() end
	
	
	// TODO
	public static String buildUrlAddress(String type, String statnNm, int startIndex, int endIndex) throws IOException {
		
		String urlStatnNm = URLEncoder.encode(statnNm, "UTF-8");
		
		String url_address = String.format("http://swopenAPI.seoul.go.kr/api/subway/%s/%s/%s/%d/%d/%s",
										API_KEY, type, REQ_SERVICE ,startIndex, endIndex, urlStatnNm); 
		
		return url_address;
	}
	
//	public static String  buildUrlAddress(String reqType, int startIndex, 
//			int endIndex, String date) {
//	
//		String url_address = "";
//		
//		// TODO
//		
//		return url_address;
//		
//	} //bulidUrlAddress() end
	
	
	
	public static StringBuffer readFromUrl(String urlAddress) {
		
		StringBuffer sb = new StringBuffer(); // response 받는 데이터 담을 객체
		
		URL url = null; // java.net.URL
		HttpURLConnection conn = null; // java.net.HttpURLConnetion
		
		InputStream in = null; 
		InputStreamReader reader = null; //byte 스트림을 --> 문자기반 Reader
		BufferedReader br = null; // buffer 장착!! 
		
		char[] buf = new char[512]; // 문자용 버퍼 ?????????????????? 왜 안 1024?
		
		// BufferedReader <- InputStreamReader <-  InputStream <- HttpURLConnetion
		
		try {
			url = new URL(urlAddress);
			conn = (HttpURLConnection)url.openConnection(); // Connection 객체 생성
			
			if(conn != null) {
				conn.setConnectTimeout(2000); // 2초 이내에 연결이 수립이 되지 않으면,  java.net.SocketTimeoutException 발생
			
				conn.setRequestMethod("GET"); 	// GET 방식 request 
												// "GET", "POST", ...
												
				conn.setRequestProperty("Content-Type", "appliaction/x-www-form-urlencoded); charset=UTF-8");
				conn.setUseCaches(false); // 캐시사용안함 
				
				System.out.println("request 시작: " + urlAddress);
				conn.connect(); // request 발생 --> 이후 response 받을  떄 까지 delay
				
				System.out.println("response 완료");
				
				
				//response 받은 후 가장 먼저 response code 확인
				//-------------- response 코드값 확인
				int responseCode = conn.getResponseCode();
				System.out.println("response code : " + responseCode);
				 
				// 참조: https://developer.mozilla.org/ko/docs/Web/HTTP/Status
				if(responseCode == 200) {// 200 대신, HttpURLConnection.HTTP_OK == 200
					// TODO
					
					in = conn.getInputStream();
					reader = new InputStreamReader(in, "utf-8");
					br = new BufferedReader(reader); // BufferedReader <- InputStreamReader
					
					int cnt; // 읽은 글자 개수
					while((cnt = br.read(buf)) != -1) {
						sb.append(buf, 0, cnt); // response 받은 텍스트를 StringBuffer 에 추가
					}
					
				} else {
					System.out.println("response 실패");
					return null;
				}
			
			} else {
				System.out.println("conn null");
				return null;
			}
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(conn != null) conn.disconnect(); //작업 끝나고 Connection 해제
		}
		
		return sb;
	} // readFromURL() end
	
	
	public static void parseXML(String xmlText) {
		
		DocumentBuilderFactory dbFactory;
		DocumentBuilder dBuilder;
		
		try {
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			
			InputStream in = new ByteArrayInputStream(xmlText.getBytes("utf-8"));
			
			Document dom = dBuilder.parse(in);
			
			Element docElement = dom.getDocumentElement();

			docElement.normalize();
			
			
			//DOM 내 데이터 파싱
			
			NodeList nList = docElement.getElementsByTagName("row");
			System.out.println("<row> 개수: " + nList.getLength());
			
			System.out.println();
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				
//				System.out.println("node type : " + node.getNodeType());
				if(node.getNodeType() != Node.ELEMENT_NODE) continue;
				
				Element rowElement = (Element)node;
				
				String statnNm = rowElement.getElementsByTagName("statnNm").item(0).getChildNodes().item(0).getNodeValue().trim();
				String subwayNm = rowElement.getElementsByTagName("subwayNm").item(0).getChildNodes().item(0).getNodeValue().trim();
				String subwayId = rowElement.getElementsByTagName("subwayId").item(0).getChildNodes().item(0).getNodeValue().trim();
			 
				System.out.printf("%d: %s %s  %s\n", i , statnNm, subwayId, subwayNm);
				
			}
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
	} // parseXML() end

	
	public static void parseJSON(String jsonText) {

		JSONObject jObj = new JSONObject(jsonText);
		JSONArray stationInfo = jObj.getJSONArray("stationList");
		
		System.out.println("row의 개수 : " + stationInfo.length());
		System.out.println();
		
		for (int i = 0; i < stationInfo.length(); i++) {
			JSONObject station = stationInfo.getJSONObject(i);
			
			String statnNm = station.getString("statnNm");
			String subwayNm = station.getString("subwayNm");
			String subwayId = station.getString("subwayId");
			
			System.out.printf("%d: %s %s  %s\n", i , statnNm, subwayId, subwayNm);

		}
		System.out.println();
		
	} // end parseJSON()
	
	
	
}// class end
