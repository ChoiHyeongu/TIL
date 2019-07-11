import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Parser {

	 String removeTag(String html) {
		return html.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", ""); // �±׸� ����� ���Խ�
	}

	public String getMeal() throws IOException {
		
		Document doc = Jsoup.connect("http://www.songpa-th.hs.kr/index.do").get();
		
		
		Element section = doc.getElementById("section_16");
		Elements mealContent = section.getElementsByClass("text_contents");
		String meal = removeTag(mealContent.toString());
		meal = meal.substring(0, meal.length()-10);
		meal = meal.replaceAll(" ", "<br>");
		

		return meal;
	}
}
