package com.lec.java.crawl14;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/* XML, Json 파싱1
 * 
 * ■서울시 지하철호선별 역별 승하차 인원 정보 
 * http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12914&srvType=A&serviceKind=1&currentPageNo=1
 * 
 * 샘플url
 * XML 버젼
 * http://openapi.seoul.go.kr:8088/4e74654971736d613438694b614145/xml/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/CardSubwayStatsNew/1/5/20181001
 *   
 * JSON 버젼
 * http://openapi.seoul.go.kr:8088/4e74654971736d613438694b614145/json/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/CardSubwayStatsNew/1/5/20181001 
 * */

public class Crawl14Main {

	public static void main(String[] args) throws IOException {
		System.out.println("jacson-databind 연습 : URL -> json -> Java");
		
		ObjectMapper mapper = new ObjectMapper();
		
		URL url = new URL("http://openapi.seoul.go.kr:8088/4e74654971736d613438694b614145/json/CardSubwayStatsNew/1/5/20181001");
		
		Subway subway = mapper.readValue(url, Subway.class);
		
		System.out.println(subway.getCardSubwayStatsNew().getList_total_count());
		
		for (Subrow e : subway.getCardSubwayStatsNew().getRow()) {
			System.out.printf("%5s : %8s역 [승차:%6d 하차:%6d]\n", 
					e.getLineNum(), 
					e.getStationName(), 
					e.getRidePassangerNum(), 
					e.getAlightPassangerNum());
		}
		
		System.out.println("시스템 종료");
	} // end main()

}// end class

@JsonIgnoreProperties(ignoreUnknown = true)
class Subway{
	public Stats CardSubwayStatsNew; // 왜 이것만 public?? 

	public Stats getCardSubwayStatsNew() {
		return CardSubwayStatsNew;
	}

	public void setCardSubwayStatsNew(Stats cardSubwayStatsNew) {
		this.CardSubwayStatsNew = cardSubwayStatsNew;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true) // 이거 복습!! annotation 
class Stats {
	
	private int list_total_count;

	private List<Subrow> row;
	
	public int getList_total_count() {
		return list_total_count;
	}

	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}

	public List<Subrow> getRow() {
		return row;
	}

	public void setRow(List<Subrow> row) {
		this.row = row;
	}
}


// JSON 필드명과 매핑되는 Java 객체의 변수명을 달리하고 싶으면,
// @JsonProperty 사용

@JsonIgnoreProperties(ignoreUnknown = true) // 자바에서 변수로 명시되지 않은 Json 자료들은 무시한다.
class Subrow {
	
	@JsonProperty("LINE_NUM") // JSON 의 LINE_NUM --> lineNum으로 매핑
	// 꼭 Json 에서의 이름으로 그대로 선언하지 않아도 된다.
	private String lineNum;
	
	@JsonProperty("SUB_STA_NM")
	private String StationName;
	@JsonProperty("RIDE_PASGR_NUM")
	private int ridePassangerNum;
	@JsonProperty("ALIGHT_PASGR_NUM")
	private int alightPassangerNum;
	
	// 생성자
	public Subrow() {
		super();
	}
	
	public Subrow(String lineNum, String stationName, int ridePassangerNum, int alightPassangerNum) {
		super();
		this.lineNum = lineNum;
		StationName = stationName;
		this.ridePassangerNum = ridePassangerNum;
		this.alightPassangerNum = alightPassangerNum;
	}
	
	// getter & setter
	public String getLineNum() {
		return lineNum;
	}
	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}
	public String getStationName() {
		return StationName;
	}
	public void setStationName(String stationName) {
		StationName = stationName;
	}
	public int getRidePassangerNum() {
		return ridePassangerNum;
	}
	public void setRidePassangerNum(int ridePassangerNum) {
		this.ridePassangerNum = ridePassangerNum;
	}
	public int getAlightPassangerNum() {
		return alightPassangerNum;
	}
	public void setAlightPassangerNum(int alightPassangerNum) {
		this.alightPassangerNum = alightPassangerNum;
	}
	
}


// Retrofit
// Volley