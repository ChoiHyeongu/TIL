

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParserServlet
 */
@WebServlet("/ParserServlet")
public class ParserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out = response.getWriter();
		out.println("<fieldset style=\"width:340px; background:yellow;\">" + "<legend align=\"center\">" + getDate() + " 급식입니다!</legend>");
		Parser parser = new Parser();
		String meal = parser.getMeal();
		out.println(meal);
		out.println("</fieldset>");
		out.close();
	}

	private String getDate() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년MM월dd일");
		String today = simpleDateFormat.format(date);

		return today;
	}

}
