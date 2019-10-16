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

			System.out.println("�Ľ��� ����Ʈ �� : " + nList.getLength()); // �Ľ��� ����Ʈ ��

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();
		System.out.println("[17���� 21���� ������ �����Դϴ�.]");
		System.out.println();
	}

	public void getCalender() {

		Calendar cal = Calendar.getInstance(); // Ķ���� �ν��Ͻ� ���

		int today = cal.get(Calendar.DATE); // ���� ���� ����

		int year = 2019;
		int month = 10;

		// ���ϴ� �⵵ ��¥ ����
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);

		cal.set(Calendar.DATE, 1); // ���� ���� 1�Ϸ� ����.
		int sDayNum = cal.get(Calendar.DAY_OF_WEEK); // 1���� ���� ������, SUNDAY (1) .MONDAY(2) , TUESDAY(3),.....
		int endDate = cal.getActualMaximum(Calendar.DATE); // ���� �������� ���

		int nowYear = cal.get(Calendar.YEAR);
		int nowMonth = cal.get(Calendar.MONTH);

		System.out.println("===================== " + nowYear + "��  " + (nowMonth + 1) + "�� ==================");

		int sDay = sDayNum;

		// ���ϸ� ���
		System.out.println(" ��\t ��\t ȭ\t ��\t ��\t ��\t ��\t");
		System.out.println("====================================================");
		// 1���� ���۵Ǵ� ������ ���� �������� ä���
		for (int i = 1; i < sDayNum; i++) {
			System.out.printf("%3s\t", "��");
		} // for-----------------
		for (int i = 1; i <= endDate; i++) { // 1���� �������ϱ��� �ݺ�.

			if (i == today)
				System.out.printf("[%2d]\t", i); // ���� ��¥ ǥ��
			else
				System.out.printf("%3d\t", i); // �Ϲ� ���

			if (sDay % 7 == 0)
				System.out.println(); // ������ 7����� �Ǹ� �ٹٲ�.
			sDay++; // ���� ī��Ʈ
		}
	}
}
