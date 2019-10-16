import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Weather {

	public void getWeather(int date) {

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder
					.parse("http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109");

			document.getDocumentElement().normalize();
			System.out.println("Root element: " + document.getDocumentElement().getNodeName());

			NodeList nList = document.getElementsByTagName("tmEf");
			
			for(int i = 0 ; i < nList.getLength(); i++) {
				String tmEf = nList.getNodeValue();
			}

			System.out.println("파싱할 리스트 수 : " + nList.getLength()); // 파싱할 리스트 수

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("[17일은 21도에 날씨는 맑음입니다.]");
		System.out.println();
	}

	public void getCalender() {

		Calendar cal = Calendar.getInstance(); // 캘린더 인스턴스 얻기

		int today = cal.get(Calendar.DATE); // 오늘 일자 저장

		int year = 2019;
		int month = 10;

		// 원하는 년도 날짜 세팅
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);

		cal.set(Calendar.DATE, 1); // 현재 달을 1일로 설정.
		int sDayNum = cal.get(Calendar.DAY_OF_WEEK); // 1일의 요일 얻어오기, SUNDAY (1) .MONDAY(2) , TUESDAY(3),.....
		int endDate = cal.getActualMaximum(Calendar.DATE); // 달의 마지막일 얻기

		int nowYear = cal.get(Calendar.YEAR);
		int nowMonth = cal.get(Calendar.MONTH);

		System.out.println("===================== " + nowYear + "년  " + (nowMonth + 1) + "월 ==================");

		int sDay = sDayNum;

		// 요일명 출력
		System.out.println(" 일\t 월\t 화\t 수\t 목\t 금\t 토\t");
		System.out.println("====================================================");
		// 1일이 시작되는 이전의 요일 공백으로 채우기
		for (int i = 1; i < sDayNum; i++) {
			System.out.printf("%3s\t", "★");
		} // for-----------------
		for (int i = 1; i <= endDate; i++) { // 1부터 마지막일까지 반복.

			if (i == today)
				System.out.printf("[%2d]\t", i); // 오늘 날짜 표시
			else
				System.out.printf("%3d\t", i); // 일반 출력

			if (sDay % 7 == 0)
				System.out.println(); // 요일이 7배수가 되면 줄바꿈.
			sDay++; // 요일 카운트
		}
	}
}
