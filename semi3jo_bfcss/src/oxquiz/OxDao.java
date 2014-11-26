package oxquiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import bean.DBConnectionMgr;

public class OxDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DBConnectionMgr pool;
	
	public OxDao(){ // 생성자에 dbcp를 이용하기 위한 준비
		try{
			pool = DBConnectionMgr.getInstance();
		}
		catch(Exception err){
			System.out.println("BoardDao(): " + err);
		}
	}
	
	//전체 문제 가져오기
	
	public Vector getQuizList(int intPage){
		Vector v = new Vector(); // 전체 글을 담기 위한 통
		String sql;
		try{
			//만약 1페이지 주세요 할 경우 0 ~ 10 까지의 수를 가져온다.			
			sql = "select * from OXquiz order by num limit "+(intPage*10-10)+", "+(10)+"";
			con = pool.getConnection(); // DB와 연결
			pstmt = con.prepareStatement(sql); // 미리 작성된 문장을 DB에 전달하기 위해 포장
			rs = pstmt.executeQuery(); //가져온 결과값을 rs에 저장
			
			while(rs.next()){ // 반복문 돌려서 출력
				OxDto dto = new OxDto(); //DTO생성
				dto.setNum(rs.getInt("num")); //각 항목의 결과값을 dto에 담아서
				dto.setAnswer(rs.getString("answer"));
				dto.setQuiz(rs.getString("quiz"));
				dto.setUserID(rs.getString("userId"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCategory(rs.getString("category"));
				
				v.add(dto); // 그 값을 dto에 누적한 후 
			}
		}
		catch(Exception err){
			System.out.println("getQuizList(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt, rs); // 순서도 중요 
		}
		
		return v; // 리턴!! 
	}
	
	//문제 가져오기(시제_tense)
	
	public Vector getQuizList_tense(int intPage){
		Vector v = new Vector(); // 전체 글을 담기 위한 통
		String sql;
						
		try{
			sql = "select * from OXquiz where category='tense' order by num limit "+(intPage*10-10)+", "+(10)+"";
			con = pool.getConnection(); // DB와 연결
			pstmt = con.prepareStatement(sql); // 미리 작성된 문장을 DB에 전달하기 위해 포장
			rs = pstmt.executeQuery(); //가져온 결과값을 rs에 저장
			
			while(rs.next()){ // 반복문 돌려서 출력
				OxDto dto = new OxDto(); //DTO생성
				dto.setNum(rs.getInt("num")); //각 항목의 결과값을 dto에 담아서
				dto.setAnswer(rs.getString("answer"));
				dto.setQuiz(rs.getString("quiz"));
				dto.setUserID(rs.getString("userId"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCategory(rs.getString("category"));
				
				v.add(dto); // 그 값을 dto에 누적한 후 
			}
		}
		catch(Exception err){
			System.out.println("getQuizList(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt, rs); // 순서도 중요 
		}
		
		return v; // 리턴!! 
	}
	
	//문제 가져오기(태_voice)
	
	public Vector getQuizList_voice(int intPage){
		Vector v = new Vector(); // 전체 글을 담기 위한 통
		String sql;
				
		try{
			sql = "select * from OXquiz where category='voice' order by num limit "+(intPage*10-10)+", "+(10)+"";
			con = pool.getConnection(); // DB와 연결
			pstmt = con.prepareStatement(sql); // 미리 작성된 문장을 DB에 전달하기 위해 포장
			rs = pstmt.executeQuery(); //가져온 결과값을 rs에 저장
			
			while(rs.next()){ // 반복문 돌려서 출력
				OxDto dto = new OxDto(); //DTO생성
				dto.setNum(rs.getInt("num")); //각 항목의 결과값을 dto에 담아서
				dto.setAnswer(rs.getString("answer"));
				dto.setQuiz(rs.getString("quiz"));
				dto.setUserID(rs.getString("userId"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCategory(rs.getString("category"));
				
				v.add(dto); // 그 값을 dto에 누적한 후 
			}
		}
		catch(Exception err){
			System.out.println("getQuizList(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt, rs); // 순서도 중요 
		}
		
		return v; // 리턴!! 
	}
	
	//문제 가져오기(수_num)
	
	public Vector getQuizList_num(int intPage){
		Vector v = new Vector(); // 전체 글을 담기 위한 통
		String sql;
		//System.out.println("요청 intPage : "+intPage);		
		try{
			sql = "select * from OXquiz where category='grammar' order by num limit "+(intPage*10-10)+", "+(10)+"";
			con = pool.getConnection(); // DB와 연결
			pstmt = con.prepareStatement(sql); // 미리 작성된 문장을 DB에 전달하기 위해 포장
			rs = pstmt.executeQuery(); //가져온 결과값을 rs에 저장
			
			while(rs.next()){ // 반복문 돌려서 출력
				OxDto dto = new OxDto(); //DTO생성
				dto.setNum(rs.getInt("num")); //각 항목의 결과값을 dto에 담아서
				dto.setAnswer(rs.getString("answer"));
				dto.setQuiz(rs.getString("quiz"));
				dto.setUserID(rs.getString("userId"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCategory(rs.getString("category"));
				
				v.add(dto); // 그 값을 dto에 누적한 후 
			}
		}
		catch(Exception err){
			System.out.println("getQuizList(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt, rs); // 순서도 중요 
		}
		
		return v; // 리턴!! 
	}
	
	//문제 가져오기(단어_word)
	
	public Vector getQuizList_word(int intPage){
		Vector v = new Vector(); // 전체 글을 담기 위한 통
		String sql;
		//System.out.println("요청 intPage : "+intPage);
				
		try{
			sql = "select * from OXquiz where category='word' order by num limit "+(intPage*10-10)+", "+(10)+"";
			con = pool.getConnection(); // DB와 연결
			pstmt = con.prepareStatement(sql); // 미리 작성된 문장을 DB에 전달하기 위해 포장
			rs = pstmt.executeQuery(); //가져온 결과값을 rs에 저장
			
			while(rs.next()){ // 반복문 돌려서 출력
				OxDto dto = new OxDto(); //DTO생성
				dto.setNum(rs.getInt("num")); //각 항목의 결과값을 dto에 담아서
				dto.setAnswer(rs.getString("answer"));
				dto.setQuiz(rs.getString("quiz"));
				dto.setUserID(rs.getString("userId"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCategory(rs.getString("category"));
				
				v.add(dto); // 그 값을 dto에 누적한 후 
			}
		}
		catch(Exception err){
			System.out.println("getQuizList(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt, rs); // 순서도 중요 
		}
		
		return v; // 리턴!! 
	}
	
	
	
	//문제 저장하기
	public void insertQuiz(OxDto dto){ //
		String sql = null;
		try{
			
			sql = "insert into OXquiz(userId, category, quiz, answer, explanation, regdate) values(?, ?, ?, ?, ?,curdate())";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql); // 미리 작성된 문장을 DB에 전달하기 위해 포장
			
			pstmt.setString(1, dto.getUserID());
			pstmt.setString(2, dto.getCategory());
			pstmt.setString(3, dto.getQuiz());
			pstmt.setString(4, dto.getAnswer());
			pstmt.setString(5, dto.getExplanation());
			
			pstmt.executeUpdate();
			
		}
		catch(Exception err){
			System.out.println("insertQuiz(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt);
		}
	}
	
	//선택한 문제 한개 가져오기
	public OxDto getQuiz(int q_num){ //76
		String sql ="";
		OxDto dto = new OxDto(); //DTO생성
		try{
			sql = "select * from OXquiz where q_num=" + q_num;
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dto.setNum(rs.getInt("q_num")); //각 항목의 결과값을 dto에 담아서
				dto.setAnswer(rs.getString("answer"));
				dto.setQuiz(rs.getString("quiz"));
				dto.setUserID(rs.getString("userId"));
			}
		}
		catch(Exception err){
			System.out.println("getQuiz(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt, rs);
		}
		
		return dto;
	}
	
	
	//문제 삭제
	public void deleteQuiz(int q_num){
		String sql=null;
		
		try{
			sql = "delete from OXquiz where q_num=?";
			
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, q_num);
						
			pstmt.executeUpdate();
			
		}
		catch(Exception err){
			System.out.println("delteQuiz(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt);
		}
		
	}
}
