package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JoinDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DBConnectionMgr pool;
	
	public JoinDAO(){ 
		try{
			pool = DBConnectionMgr.getInstance();
		}
		catch(Exception err){
			System.out.println("JoinDAO(): " + err);
		}
	}
	

	public int login(JoinDTO dto){
		String sql = null;
		try{
			con = pool.getConnection(); //�뿰寃�
				
			sql = "select * from member where id=? and pw=?"; // 異쒕젰
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getId()); 
			pstmt.setString(2, dto.getPw()); 
			rs = pstmt.executeQuery();
					
			if(rs.next()){
				dto.setName(rs.getString("name"));
				System.out.println(rs.getString("name"));
				return 1;
			}else{
				return 0;
			}
		}
		catch(Exception err){
			System.out.println("login() : " + err);
			return -1;
		}
		finally{
			pool.freeConnection(con, pstmt,rs);
		}
	}

	public boolean loginchk(String id){
		String sql = null;
		try{
			con = pool.getConnection();
				
			sql = "select * from member where id=?"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); 
					
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		}
		catch(Exception err){
			System.out.println("login() : " + err);
			return false;
		}
		finally{
			pool.freeConnection(con, pstmt,rs);
		}
	}

	public boolean loginconfirm(String id){
		String sql = null;
		boolean bool = false;
		try{
			con = pool.getConnection();
			
			sql = "select * from member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id); 
			rs = pstmt.executeQuery(); 
			
			if(rs.next()){
				bool = true;
			}
		}
		catch(Exception err){
			System.out.println("login() : " + err);
		}
		finally{
			pool.freeConnection(con, pstmt,rs);
		}
		
		return bool;
	}
	

	public void insertJoin(JoinDTO dto){
		String sql = null;
		try{
			System.out.println(dto.getName());
			sql = "insert into member(id, pw, name, phone, email, zip1, zip2, address) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)"; 

			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPhone());
			pstmt.setString(5, dto.getEmail());
			pstmt.setInt(6, dto.getZip1());
			pstmt.setInt(7, dto.getZip2());
			pstmt.setString(8, dto.getAddress());

			pstmt.executeUpdate();
		}
		catch(Exception err){
			System.out.println("insertJoin() : " + err);
		}
		finally{
			pool.freeConnection(con, pstmt);
		}
	}
	

	public JoinDTO getMemberInfo(String id){
		JoinDTO dto = new JoinDTO();
		String sql = null;
		try{
			con = pool.getConnection();
				
			sql = "select * from member where id=?"; 
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id); 
			rs = pstmt.executeQuery(); 
					
			if(rs.next()){
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setZip1(rs.getInt("zip1"));
				dto.setZip2(rs.getInt("zip2"));
				dto.setAddress(rs.getString("address"));
			}
		}
		catch(Exception err){
			System.out.println("getMemberInfo() : " + err);
		}
		finally{
			pool.freeConnection(con, pstmt,rs);
		}
		
		return dto;
	}

	public void updateJoin(JoinDTO dto){
		String sql = null;
		try{
			sql = "update member set pw=?, name=?, phone=?, email=?, zip1=?, zip2=?, address=? where id=?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getPw());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getEmail());
			pstmt.setInt(5, dto.getZip1());
			pstmt.setInt(6, dto.getZip2());
			pstmt.setString(7, dto.getAddress());
			pstmt.setString(8, dto.getId());
			pstmt.executeUpdate();		
		}
		catch(Exception err){
			System.out.println("updateJoin() : " + err);
		}
		finally{
			pool.freeConnection(con, pstmt);
		}
	}
	
	public void m_dropout(String id){
		String sql = null;
		try{
			sql = "delete from member where id=?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();		
		}
		catch(Exception err){
			System.out.println("deleteBoard() : " + err);
		}
		finally{
			pool.freeConnection(con, pstmt);
		}
	}
}
