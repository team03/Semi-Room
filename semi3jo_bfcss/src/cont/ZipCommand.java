package cont;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cont.Command;
import bean.DBConnectionMgr;

public class ZipCommand implements Command {

	@Override
	public Object processCommand(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, UnsupportedEncodingException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		HttpSession session=req.getSession();

		String dong = req.getParameter("dong"); //일회용
		
		Vector vAddr = new Vector();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DBConnectionMgr pool = null;
		
		try{
			String sql = "select * from tblzipcode where dong like '%" + dong + "%'";
			
			pool = DBConnectionMgr.getInstance();
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				ZipDto dto = new ZipDto();
				dto.setBunji(rs.getString("bunji"));
				dto.setDong(rs.getString("dong"));
				dto.setGugun(rs.getString("gugun"));
				dto.setSido(rs.getString("sido"));
				dto.setZipcode(rs.getString("zipcode"));
			
				vAddr.add(dto);
			}
		}
		catch(Exception err){
			err.printStackTrace();
		}
		finally{
			pool.freeConnection(con, pstmt, rs);
		}
		req.setAttribute("addr", vAddr); 
		//vAddr이란 벡터 변수를 addr변수로 바꿔서 보내준다.
		return "zipSearch.jsp";
		//resp.sendRedirect("zipSearch.jsp");
	}
}
