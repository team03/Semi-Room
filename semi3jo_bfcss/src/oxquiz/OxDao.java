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
	
	public OxDao(){ // �����ڿ� dbcp�� �̿��ϱ� ���� �غ�
		try{
			pool = DBConnectionMgr.getInstance();
		}
		catch(Exception err){
			System.out.println("BoardDao(): " + err);
		}
	}
	
	//��ü ���� ��������
	
	public Vector getQuizList(int intPage){
		Vector v = new Vector(); // ��ü ���� ��� ���� ��
		String sql;
		try{
			//���� 1������ �ּ��� �� ��� 0 ~ 10 ������ ���� �����´�.			
			sql = "select * from OXquiz order by num limit "+(intPage*10-10)+", "+(10)+"";
			con = pool.getConnection(); // DB�� ����
			pstmt = con.prepareStatement(sql); // �̸� �ۼ��� ������ DB�� �����ϱ� ���� ����
			rs = pstmt.executeQuery(); //������ ������� rs�� ����
			
			while(rs.next()){ // �ݺ��� ������ ���
				OxDto dto = new OxDto(); //DTO����
				dto.setNum(rs.getInt("num")); //�� �׸��� ������� dto�� ��Ƽ�
				dto.setAnswer(rs.getString("answer"));
				dto.setQuiz(rs.getString("quiz"));
				dto.setUserID(rs.getString("userId"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCategory(rs.getString("category"));
				
				v.add(dto); // �� ���� dto�� ������ �� 
			}
		}
		catch(Exception err){
			System.out.println("getQuizList(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt, rs); // ������ �߿� 
		}
		
		return v; // ����!! 
	}
	
	//���� ��������(����_tense)
	
	public Vector getQuizList_tense(int intPage){
		Vector v = new Vector(); // ��ü ���� ��� ���� ��
		String sql;
						
		try{
			sql = "select * from OXquiz where category='tense' order by num limit "+(intPage*10-10)+", "+(10)+"";
			con = pool.getConnection(); // DB�� ����
			pstmt = con.prepareStatement(sql); // �̸� �ۼ��� ������ DB�� �����ϱ� ���� ����
			rs = pstmt.executeQuery(); //������ ������� rs�� ����
			
			while(rs.next()){ // �ݺ��� ������ ���
				OxDto dto = new OxDto(); //DTO����
				dto.setNum(rs.getInt("num")); //�� �׸��� ������� dto�� ��Ƽ�
				dto.setAnswer(rs.getString("answer"));
				dto.setQuiz(rs.getString("quiz"));
				dto.setUserID(rs.getString("userId"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCategory(rs.getString("category"));
				
				v.add(dto); // �� ���� dto�� ������ �� 
			}
		}
		catch(Exception err){
			System.out.println("getQuizList(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt, rs); // ������ �߿� 
		}
		
		return v; // ����!! 
	}
	
	//���� ��������(��_voice)
	
	public Vector getQuizList_voice(int intPage){
		Vector v = new Vector(); // ��ü ���� ��� ���� ��
		String sql;
				
		try{
			sql = "select * from OXquiz where category='voice' order by num limit "+(intPage*10-10)+", "+(10)+"";
			con = pool.getConnection(); // DB�� ����
			pstmt = con.prepareStatement(sql); // �̸� �ۼ��� ������ DB�� �����ϱ� ���� ����
			rs = pstmt.executeQuery(); //������ ������� rs�� ����
			
			while(rs.next()){ // �ݺ��� ������ ���
				OxDto dto = new OxDto(); //DTO����
				dto.setNum(rs.getInt("num")); //�� �׸��� ������� dto�� ��Ƽ�
				dto.setAnswer(rs.getString("answer"));
				dto.setQuiz(rs.getString("quiz"));
				dto.setUserID(rs.getString("userId"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCategory(rs.getString("category"));
				
				v.add(dto); // �� ���� dto�� ������ �� 
			}
		}
		catch(Exception err){
			System.out.println("getQuizList(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt, rs); // ������ �߿� 
		}
		
		return v; // ����!! 
	}
	
	//���� ��������(��_num)
	
	public Vector getQuizList_num(int intPage){
		Vector v = new Vector(); // ��ü ���� ��� ���� ��
		String sql;
		//System.out.println("��û intPage : "+intPage);		
		try{
			sql = "select * from OXquiz where category='grammar' order by num limit "+(intPage*10-10)+", "+(10)+"";
			con = pool.getConnection(); // DB�� ����
			pstmt = con.prepareStatement(sql); // �̸� �ۼ��� ������ DB�� �����ϱ� ���� ����
			rs = pstmt.executeQuery(); //������ ������� rs�� ����
			
			while(rs.next()){ // �ݺ��� ������ ���
				OxDto dto = new OxDto(); //DTO����
				dto.setNum(rs.getInt("num")); //�� �׸��� ������� dto�� ��Ƽ�
				dto.setAnswer(rs.getString("answer"));
				dto.setQuiz(rs.getString("quiz"));
				dto.setUserID(rs.getString("userId"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCategory(rs.getString("category"));
				
				v.add(dto); // �� ���� dto�� ������ �� 
			}
		}
		catch(Exception err){
			System.out.println("getQuizList(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt, rs); // ������ �߿� 
		}
		
		return v; // ����!! 
	}
	
	//���� ��������(�ܾ�_word)
	
	public Vector getQuizList_word(int intPage){
		Vector v = new Vector(); // ��ü ���� ��� ���� ��
		String sql;
		//System.out.println("��û intPage : "+intPage);
				
		try{
			sql = "select * from OXquiz where category='word' order by num limit "+(intPage*10-10)+", "+(10)+"";
			con = pool.getConnection(); // DB�� ����
			pstmt = con.prepareStatement(sql); // �̸� �ۼ��� ������ DB�� �����ϱ� ���� ����
			rs = pstmt.executeQuery(); //������ ������� rs�� ����
			
			while(rs.next()){ // �ݺ��� ������ ���
				OxDto dto = new OxDto(); //DTO����
				dto.setNum(rs.getInt("num")); //�� �׸��� ������� dto�� ��Ƽ�
				dto.setAnswer(rs.getString("answer"));
				dto.setQuiz(rs.getString("quiz"));
				dto.setUserID(rs.getString("userId"));
				dto.setExplanation(rs.getString("explanation"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCategory(rs.getString("category"));
				
				v.add(dto); // �� ���� dto�� ������ �� 
			}
		}
		catch(Exception err){
			System.out.println("getQuizList(): " + err);
		}
		finally{
			pool.freeConnection(con, pstmt, rs); // ������ �߿� 
		}
		
		return v; // ����!! 
	}
	
	
	
	//���� �����ϱ�
	public void insertQuiz(OxDto dto){ //
		String sql = null;
		try{
			
			sql = "insert into OXquiz(userId, category, quiz, answer, explanation, regdate) values(?, ?, ?, ?, ?,curdate())";
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql); // �̸� �ۼ��� ������ DB�� �����ϱ� ���� ����
			
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
	
	//������ ���� �Ѱ� ��������
	public OxDto getQuiz(int q_num){ //76
		String sql ="";
		OxDto dto = new OxDto(); //DTO����
		try{
			sql = "select * from OXquiz where q_num=" + q_num;
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dto.setNum(rs.getInt("q_num")); //�� �׸��� ������� dto�� ��Ƽ�
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
	
	
	//���� ����
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
