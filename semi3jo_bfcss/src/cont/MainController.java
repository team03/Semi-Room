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
		//���忡 ������ ���� ��������
		Command icmd = factory.createCommand(cmd); 
		// Command��� Http��ü�� ���ϸ��� �ִ´�.
		url = (String)icmd.processCommand(req, res);
		// ���ϸ� �ִ� �޼ҵ带 �����Ű�� �ּҸ� ��ȯ�޴´�.
					
		RequestDispatcher view = 
				req.getRequestDispatcher(url); // �̵��� �϶�� ������ ���� ��. ������ �̵�X
		view.forward(req, res); // ��û�� ������ ������ �������� �̵��ϼ��� 
	}
}