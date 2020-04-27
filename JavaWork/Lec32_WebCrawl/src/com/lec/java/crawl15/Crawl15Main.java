package com.lec.java.crawl15;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

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

public class Crawl15Main {

	public static final String REQ_SERVICE = "stationInfo";
	public static final String API_KEY = "4e74654971736d613438694b614145";
	
	public static void main(String[] args) throws IOException {
		System.out.println("");
		
		int startIndex = 1; // 요청시작 위치 정수 입력 (페이징 시작번호 입니다 : 데이터 행 시작번호)
		int endIndex = 5;   // 요청 종료위치 정수 입력 (페이징 끝 번호 입니다 : 데이터 행 끝번호)
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 역 이름을 입력하세요: ");
		String statnNm = sc.nextLine();
		
		String url_address = "";
		
		System.out.println("--- JSON 파싱 ---");
		url_address = buildUrlAddress("json",statnNm ,startIndex, endIndex);
//		System.out.println(url_address);
		
		ObjectMapper mapper = new ObjectMapper();
		
		URL url = new URL(url_address);
		
		Station station = mapper.readValue(url, Station.class);
		
		
//		System.out.println(station.getStationList());
		
		for(StationListObject e : station.getStationList()) {
			System.out.printf("%s %s  %s\n", e.getStatnNm(), e.getSubwayId(), e.getSubwayNm());
		}
		
		
		
		System.out.println("\n시스템 종료");
	} // end main()

public static String buildUrlAddress(String type, String statnNm, int startIndex, int endIndex) throws IOException {
		
		String urlStatnNm = URLEncoder.encode(statnNm, "UTF-8");
		
		String url_address = String.format("http://swopenAPI.seoul.go.kr/api/subway/%s/%s/%s/%d/%d/%s",
										API_KEY, type, REQ_SERVICE ,startIndex, endIndex, urlStatnNm); 
		
		return url_address;
	}
	
}// end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Station {
	private List<StationListObject> stationList;

	public List<StationListObject> getStationList() {
		return stationList;
	}

	public void setStationList(List<StationListObject> stationList) {
		this.stationList = stationList;
	}
	
}

//@JsonIgnoreProperties(ignoreUnknown = true)
//class StationList{
//	private ArrayList<StationListObject> stationList;
//
//	public ArrayList<StationListObject> getStationList() {
//		return stationList;
//	}
//
//	public void setStationList(ArrayList<StationListObject> stationList) {
//		this.stationList = stationList;
//	}
//}


@JsonIgnoreProperties(ignoreUnknown = true)
class StationListObject {
	private String statnNm;
	private String subwayId;
	private String subwayNm;
	public StationListObject() {
		super();
	}
	public StationListObject(String statnNm, String subwayId, String subwayNm) {
		super();
		this.statnNm = statnNm;
		this.subwayId = subwayId;
		this.subwayNm = subwayNm;
	}
	public String getStatnNm() {
		return statnNm;
	}
	public void setStatnNm(String statnNm) {
		this.statnNm = statnNm;
	}
	public String getSubwayId() {
		return subwayId;
	}
	public void setSubwayId(String subwayId) {
		this.subwayId = subwayId;
	}
	public String getSubwayNm() {
		return subwayNm;
	}
	public void setSubwayNm(String subwayNm) {
		this.subwayNm = subwayNm;
	}
}

