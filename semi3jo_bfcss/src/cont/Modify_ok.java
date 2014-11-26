package cont;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.JoinDAO;
import bean.JoinDTO;

public class Modify_ok implements Command {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		HttpSession session=req.getSession();
	
		System.out.println("ȸ�� ���� ó�� ���� . . . ");

		JoinDAO dao = new JoinDAO();
		JoinDTO dto = new JoinDTO();

		String id = (String)req.getParameter("id");
		String pw = (String)req.getParameter("pw");
		String name = (String)req.getParameter("name");
		System.out.println(name);
		String phone = (String)req.getParameter("phone");
		String email = (String)req.getParameter("email");
		int zip1 = Integer.parseInt(req.getParameter("zip1"));
		int zip2 = Integer.parseInt(req.getParameter("zip2"));
		String address = (String)req.getParameter("address");	

		dto.setId(id);
		dto.setPw(pw);
		dto.setName(name);
		dto.setPhone(phone);
		dto.setEmail(email);
		dto.setZip1(zip1);
		dto.setZip2(zip2);
		dto.setAddress(address);
		dao.updateJoin(dto);

		System.out.println("ȸ�� ���� ó�� �� . . . ");
		session.setAttribute("name", name);
		
		return "mypage.jsp";
	}
}
