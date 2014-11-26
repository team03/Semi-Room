package cont;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.JoinDAO;
import bean.JoinDTO;

public class Modify implements Command {
	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		HttpSession session=req.getSession();
		
		JoinDAO dao = new JoinDAO();
		JoinDTO dto = new JoinDTO();
		
		String id = (String)session.getAttribute("id");
		dto = dao.getMemberInfo(id);
		
		session.setAttribute("dto",dto);
		session.setAttribute("name",dto.getName());
		session.setAttribute("address",dto.getAddress());
		return "member_modify.jsp";
	}
}
