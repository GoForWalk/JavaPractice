package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜          	   구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             	구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요
// JSON 은  jackson 을 활용하여 파싱하세요


public class DailySumMain {

	private static String REQ_SERVICE = "SPOP_DAILYSUM_JACHI";
	private static String API_KEY = "4e74654971736d613438694b614145";

	public static void main(String[] args) throws IOException {
		
		// 변수 선언
		int startIndex = 1; // 시작하는 줄
		int endIndex = 5;	// 끝나는 줄
		String siGnGuCode = "";
		String date ="20190101";
		String url_address = "";
		
		// json 을 jackson 을 파싱
		System.out.println("-----JSON 파싱 -----");
		System.out.println();
		// url 주소 가져오기!!
		url_address = buildUrlAddress("json", startIndex, endIndex, date, siGnGuCode);
//		System.out.println(url_address);
		
		// jackson 활용하기 (Controller)
		ObjectMapper mapper = new ObjectMapper();
		URL url = new URL(url_address);
		PopList popList = mapper.readValue(url, PopList.class);
		
		// view 단 (Main)
		System.out.println("날짜\t\t구ID\t\t총생활인구수\t\t일최대인구이동인구수");
		System.out.println("--------------------------------------------------------------------------");
		for(RowObject e : popList.getSeoulPopDailySum().getRow()) {
			System.out.printf("%s\t%s\t\t%s\t\t%s\n", 
					e.getDateNum(), e.getGuID(), e.getTotalPop(), e.getMovePopTotalMax() );
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("-----XML 파싱-----");
		System.out.println();
		
		url_address = buildUrlAddress("xml", startIndex, endIndex, date, siGnGuCode);

		Document doc = Jsoup.connect(url_address).parser(Parser.xmlParser()).get();
		
		Elements elements = doc.select("row");
		
		System.out.println("날짜\t\t구ID\t\t총생활인구수\t\t일최대인구이동인구수");
		System.out.println("--------------------------------------------------------------------------");
		
		for(Element e : elements) {
			String getDateNum = e.select("STDR_DE_ID").text().trim();
			String getGuID  = e.select("SIGNGU_CODE_SE").text().trim() ;
			String getTotalPop = e.select("TOT_LVPOP_CO").text().trim();
			String getMovePopTotalMax = e.select("DAIL_MXMM_MVMN_LVPOP_CO").text().trim();
			
			System.out.printf("%s\t%s\t\t%s\t\t%s\n", 
					getDateNum, getGuID, getTotalPop, getMovePopTotalMax);
			
		}
		

	} // end main
	
public static String buildUrlAddress(String type, int startIndex, int endIndex, String date, String siGnGuCode) throws IOException {
		
		//http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
		String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/%s/%d/%d/%s/%s",
										API_KEY, type, REQ_SERVICE ,startIndex, endIndex, date, siGnGuCode); 
		
		return url_address;
	}
	

} // end class

@JsonIgnoreProperties (ignoreUnknown = true)
class RowObject{
	
	@JsonProperty("STDR_DE_ID")
	private String dateNum;
	
	@JsonProperty("SIGNGU_CODE_SE")
	private String guID;
	
	@JsonProperty("TOT_LVPOP_CO")
	private String totalPop;
	
	@JsonProperty("DAIL_MXMM_MVMN_LVPOP_CO")
	private String movePopTotalMax;

	public RowObject() {
		super();
	}

	public RowObject(String dateNum, String guID, String totalPop, String movePopTotalMax) {
		super();
		this.dateNum = dateNum;
		this.guID = guID;
		this.totalPop = totalPop;
		this.movePopTotalMax = movePopTotalMax;
	}

	public String getDateNum() {
		return dateNum;
	}

	public void setDateNum(String dateNum) {
		this.dateNum = dateNum;
	}

	public String getGuID() {
		return guID;
	}

	public void setGuID(String guID) {
		this.guID = guID;
	}

	public String getTotalPop() {
		return totalPop;
	}

	public void setTotalPop(String totalPop) {
		this.totalPop = totalPop;
	}

	public String getMovePopTotalMax() {
		return movePopTotalMax;
	}

	public void setMovePopTotalMax(String movePopTotalMax) {
		this.movePopTotalMax = movePopTotalMax;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class SeoulPopDailySumObject{
	
	private ArrayList<RowObject> row;

	public SeoulPopDailySumObject() {
		super();
	}

	public SeoulPopDailySumObject(ArrayList<RowObject> row) {
		super();
		this.row = row;
	}

	public ArrayList<RowObject> getRow() {
		return row;
	}

	public void setRow(ArrayList<RowObject> row) {
		this.row = row;
	}
}

@JsonIgnoreProperties(ignoreUnknown = true)
class PopList{
	@JsonProperty("SPOP_DAILYSUM_JACHI")
	private SeoulPopDailySumObject seoulPopDailySum;

	public PopList() {
		super();
	}

	public PopList(SeoulPopDailySumObject seoulPopDailySum) {
		super();
		this.seoulPopDailySum = seoulPopDailySum;
	}

	public SeoulPopDailySumObject getSeoulPopDailySum() {
		return seoulPopDailySum;
	}

	public void setSeoulPopDailySum(SeoulPopDailySumObject seoulPopDailySum) {
		this.seoulPopDailySum = seoulPopDailySum;
	}
}
