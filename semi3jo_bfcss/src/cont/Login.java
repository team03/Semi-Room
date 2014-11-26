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

public class Login implements Command {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		System.out.println("�α��� ó�� ���� . . . ");
			
		JoinDTO dto = new JoinDTO();
		JoinDAO dao = new JoinDAO();
		
		dto.setId(req.getParameter("id"));
		dto.setPw(req.getParameter("pw"));
		
		int result = dao.login(dto);
		if(result==1){ //���̵� ��й�ȣ�� ��� �´°��
			HttpSession session=req.getSession();
			//ȸ�� ������ ������ ��� ���̵� ���ǿ� ����ϱ� ���� ���� ��ü�� �����Ѵ�.
			
			String id = (String)dto.getId();
			String name = (String)dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			
			//4. ���������� �̵��ϱ�
			return "index.html";			
		}else if(result==0){//���̵� �Ǵ� ��й�ȣ�� Ʋ�����

			String msg="���̵� �Ǵ� ��й�ȣ�� Ʋ����!";

			req.setAttribute("errMsg", msg);
		}else{//�ͼ����� �߻��Ѱ��

			String msg="�������� �����߻�!";

			req.setAttribute("errMsg", msg);
		}
		return "err.jsp";
	}
}
