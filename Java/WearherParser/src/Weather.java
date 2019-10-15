import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Weather{
	
	public void getWeather(int date) {
		
		char[] arr = new char[100];
		
		final String url = "https://weather.com/ko-KR/weather/monthly/l/c86f97bf8a27ec300b062be90c114b04aa9edb4c4d5a77ceeae44f234210a622";
		String result = null;
		
		try {
			Document html = Jsoup.connect(url).get();
			Elements table = html.getElementsByClass("dayCell opaque");
			String dateList = table.toString();
			
			arr = dateList.toCharArray();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<965;i++) {
			System.out.print(arr[i]);
		}
	}
}
