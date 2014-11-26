package cont;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		String cmd = req.getParameter("cmd");
		
		String url="";
		
		FactoryCommand factory = FactoryCommand.getInstance(); 
		//공장에 물건을 만들 공간생성
		Command icmd = factory.createCommand(cmd); 
		// Command라는 Http객체에 파일명을 넣는다.
		url = (String)icmd.processCommand(req, res);
		// 파일명에 있는 메소드를 실행시키고 주소를 반환받는다.
					
		RequestDispatcher view = 
				req.getRequestDispatcher(url); // 이동을 하라고 결정만 내린 것. 실제로 이동X
		view.forward(req, res); // 요청이 들어오면 지정된 페이지로 이동하세요 
	}
}