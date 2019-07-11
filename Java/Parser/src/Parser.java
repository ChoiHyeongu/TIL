import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {

	public static void main(String[] args) {
		
		Document doc = null;
		
		try {
			doc = Jsoup.connect("http://www.songpa-th.hs.kr/index.do").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Element section = doc.getElementById("section_16");
		Elements mealContent = section.getElementsByClass("text_contents");
		String meal = removeTag(mealContent.toString());
		meal = meal.substring(0, meal.length()-10);
		meal = meal.replaceAll(" ", "\n");
		
		System.out.println(meal);		
	}
	
	static String removeTag(String html){
		return html.replaceAll("<(/)?([a-zA-Z]*)(\\s[a-zA-Z]*=[^>]*)?(\\s)*(/)?>", "");
	}
}
