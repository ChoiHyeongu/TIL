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
			// DocumentBuilderFactory ����
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder builder;
			Document doc = null;

			// OpenApiȣ��
			String urlstr = "http://www.weather.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=109";
			URL url = new URL(urlstr);
			HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();

			// ���� �б�
			br = new BufferedReader(new InputStreamReader(urlconnection.getInputStream(), "UTF-8"));
			String result = "";
			String line;
			while ((line = br.readLine()) != null) {
				result = result + line.trim();// result = URL�� XML�� ���� ��
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
					data = data.replace("����", "�����ϴ�. ");
					data = data.replace("��������", "���������� �ֽ��ϴ�.");
					data = data.replace("��������", "������ �����ϴ�.");
					data = data.replace("�������� ��", "�� �� �����Դϴ�.");
					data = data.replace("�帲", "�帳�ϴ�.");
					data = data.replace("�帮�� �� ", "�� �� �����Դϴ�.");
					data = data.replaceAll("[1234567890]","");
					data = data.replaceAll("[���������ӳ���]", "");
					System.out.println("[ " + date + "���� ������ "+ data + "]");
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
