import java.util.Calendar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class Weather {

	public void getWeekWeather(int date) {

		final String dateFormat = "2019-10-" + date + " 00:00";

		try {
			BufferedReader br = null;
			// DocumentBuilderFactory 생성
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder builder;
			Document doc = null;

			// OpenApi호출
			String urlstr = "http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

			// 응답 읽기
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			String result = "";
			String line;
			while ((line = br.readLine()) != null) {
				result = result + line.trim();// result = URL로 XML을 읽은 값
			}

			InputSource is = new InputSource(new StringReader(result));
			builder = factory.newDocumentBuilder();
			doc = builder.parse(is);
			XPathFactory xpathFactory = XPathFactory.newInstance();
			XPath xpath = xpathFactory.newXPath();
			XPathExpression expr = xpath.compile("//location");
			NodeList nodeList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			
			NodeList child = nodeList.item(0).getChildNodes();
			for (int j = 0; j < child.getLength(); j++) {
				Node node = child.item(j);
				String data = node.getTextContent();
				if(data.contains(dateFormat)) {
					System.out.println(data);
					data = data.replace("A02", "");
					data = data.replace(dateFormat,"");
					data = data.replace("맑음", "맑습니다. ");
					data = data.replace("구름조금", "구름이조금 있습니다.");
					data = data.replace("구름많음", "구름이 많습니다.");
					data = data.replace("구름많고 비", "비가 올 예정입니다.");
					data = data.replace("흐림", "흐립니다.");
					data = data.replace("흐리고 비 ", "비가 올 예정입니다.");
					data = data.replaceAll("[1234567890]","");
					data = data.replaceAll("[보통높음계속낮음]", "");
					System.out.println("[ " + date + "일은 날씨는 "+ data + "]");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
