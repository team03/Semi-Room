package totalsite.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import bean.DBConnectionMgr;

public class BoardDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DBConnectionMgr pool;
	
	public BoardDao(){ // 생성자에 dbcp를 이용하기 위한 준비
		try{
			pool = DBConnectionMgr.getInstance();
		}
		catch(Exception err){
			System.out.println("BoardDao(): " + err);
		}
	}
	
	//전체 글 가져오기
	
	public Vector getBoardList(String keyField, String keyWord){
		Vector v = new Vector(); // 전체 글을 담기 위한 통
		String sql;
				
		try{
			if(keyWord==null || keyWord.isEmpty() || keyWord.equals("null")){
				sql = "select * from tblboard order by pos";
			}
			else{
				sql="select * from tblboard where "
						+ keyField + " like '%" + keyWord + "%' order by pos";
			}
			
			con = pool.getConnection(); // DB와 연결
			pstmt = con.prepareStatement(sql); // 미리 작성된 문장을 DB에 전달하기 위해 포장
			rs = pstmt.executeQuery(); //가져온 결과값을 rs에 저장
			
			while(rs.next()){ // 반복문 돌려서 출력
				BoardDto dto = new BoardDto(); //DTO생성
				dto.setContent(rs.getString("content")); //각 항목의 결과값을 dto에 담아서
				dto.setCount(rs.getInt("count"));
				dto.setDepth(rs.getInt("depth"));
				dto.setEmail(rs.getString("email"));
				dto.setHomepage(rs.getString("homepage"));
				dto.setIp(rs.getString("ip"));
				dto.setName(rs.getString("name"));
				dto.setNum(rs.getInt("num"));
				dto.setPass(rs.getString("pass"));
				dto.setPos(rs.getInt("pos"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setSubject(rs.getString("subject"));
				
				v.add(dto); // 그 값을 dto에 누적한 후 
			}
		}
		catch(Exception err){
			System.out.println("getBoardList(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt, rs); // 순서도 중요 
		}
		
		return v; // 리턴!! 
	}
	
	//글 저장하기(저장하기 전에 pos값 업데이트)
	public void insertBoard(BoardDto dto){ //
		String sql = null;
		try{
			sql = "update tblBoard set pos=pos+1";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
			sql = "insert into tblboard(name,email,homepage,subject,content,pass,count,ip,regdate,pos,depth,filename,ofilename)"
					+ " values(?, ?, ?, ?, ?, ?, 0, ?,sysdate(), 0, 0, ?, ?)";
			pstmt = con.prepareStatement(sql); // 미리 작성된 문장을 DB에 전달하기 위해 포장
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getHomepage());
			pstmt.setString(4, dto.getSubject());
			pstmt.setString(5, dto.getContent());
			pstmt.setString(6, dto.getPass());
			pstmt.setString(7, dto.getIp());
			pstmt.setString(8, dto.getFilename());
			pstmt.setString(9, dto.getOfilename());
			
			
			pstmt.executeUpdate();
			
			
		}
		catch(Exception err){
			System.out.println("insertBoard(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt);
		}
	}
	
	//선택한 글 한개 가져오기(글읽기, 수정페이지에서도 사용 가능)
	public BoardDto getBoard(int num){ //76
		String sql ="";
		BoardDto dto = new BoardDto(); //DTO생성
		try{
			sql = "update tblboard set count=count+1 where num="+num; // 조회수 증가 
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			sql = "select * from tblboard where num=" + num;
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dto.setName(rs.getString("name"));
				dto.setContent(rs.getString("content")); //각 항목의 결과값을 dto에 담아서
				dto.setEmail(rs.getString("email"));
				dto.setHomepage(rs.getString("homepage"));
				dto.setIp(rs.getString("ip"));
				dto.setNum(rs.getInt("num"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setSubject(rs.getString("subject"));
				dto.setPass(rs.getString("pass"));
				dto.setPos(rs.getInt("pos"));
				dto.setDepth(rs.getInt("depth"));
				dto.setFilename(rs.getString("filename"));
				dto.setOfilename(rs.getString("ofilename"));
			}
		}
		catch(Exception err){
			System.out.println("getBoard(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt, rs);
		}
		
		return dto;
	}
	
	// 글 수정(이름, 이메일, 제목, 내용)
	public void updateBoard(BoardDto dto){
		String sql = null;
		try{
			sql = "update tblboard set name= ?, email=?, subject=?, content=? where num=?";
			
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getSubject());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, dto.getNum());
						
			pstmt.executeUpdate();
			
			
		}
		catch(Exception err){
			System.out.println("updateBoard(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt);
		}
	}
	
	//글 삭제
	public void deleteBoard(int num){
		String sql=null;
		
		try{
			sql = "delete from tblboard where num=?";
			
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, num);
						
			pstmt.executeUpdate();
			
			
		}
		catch(Exception err){
			System.out.println("delteBoard(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt);
		}
		
	}
	
	// 기존 글의 pos값 변경 (기존글 - 답변글을 달기 위한 부모 글)
	public void replyUpdatePos(BoardDto dto){ // 부모의 값
		String sql=null;
		try{
			System.out.println(dto.getPos()); //0
			sql = "update tblBoard set pos = pos+1 where pos > ?";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getPos());
			
			pstmt.executeUpdate();
			
		}
		catch(Exception err){
			System.out.println("replyUpdatePos(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt);
		}
	}
	
	// 답변 - 답변을 다는 실제 글
	public void replyBoard(BoardDto dto){ // 실제 답변을 입력할 값
		String sql = null;
		try{
			sql = "insert into tblboard(name, email, homepage, subject, content, pass, count, ip, regdate,pos, depth)"
					+" values(?, ?, ?, ?, ?, ?, 0, ?,sysdate(), ?, ?)";
			
			con = pool.getConnection(); // DB와 연결
			pstmt = con.prepareStatement(sql); // 미리 작성된 문장을 DB에 전달하기 위해 포장
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getEmail());
			pstmt.setString(3, dto.getHomepage());
			pstmt.setString(4, dto.getSubject());
			pstmt.setString(5, dto.getContent());
			pstmt.setString(6, dto.getPass());
			pstmt.setString(7, dto.getIp());
			pstmt.setInt(8, dto.getPos()+1);
			pstmt.setInt(9, dto.getDepth()+1);
			
			pstmt.executeUpdate();
			
			
		}
		catch(Exception err){
			System.out.println("replyBoard(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt);
		}
		
	}
	
	//들여쓰기
	public String useDepth(int depth){
		String result = "";
		for(int i=0; i<depth*3; i++){
			result += "&nbsp;";
		}
		return result;
	}
}
