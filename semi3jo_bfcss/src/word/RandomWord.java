package word;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import bean.DBConnectionMgr;

public class RandomWord {
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private PreparedStatement pstmt2 = null;
	private ResultSet rs = null;
	private DBConnectionMgr pool = null;

	public RandomWord() {
		try {
			pool = DBConnectionMgr.getInstance();
			/*
			 * con = pool.getConnection(); 여기서 연결해도 되지만, 성능을 위해서 연결을 최대한 늦게, 연결을
			 * 끊는 것은 최대한 빨리!
			 */
		} catch (Exception err) {
			System.out.println("연결 실패 : " + err);
		}
	}
	
	public int DB_word_size(){
		String sql = "select count(*) from tblword";
		int size = 0;
		
		try {
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			rs.next();
			size = rs.getInt("count(*)");
		}
		catch (Exception e) {
			System.out.println("DB_word_size() : " + e);
		}			
		return size;		
	}
	
	public void Sel_word(){		
		RandomWord ws = new RandomWord();
		int size = ws.DB_word_size(); //327
		String sql = "";
		
		LinkedList<Integer> size_list = new LinkedList<Integer>();
		LinkedList<Integer> select_list = new LinkedList<Integer>();
		//ArrayList<String> word_list = new ArrayList<String>();
		for (int i = 1; i <= size; i++)
			size_list.addLast(i); // 1~100까지의 값을 집어 넣음

		Random random = new Random();

		for (int i = size; i > size-20; i--){
			int index = random.nextInt(i); // 현재 list 길이 만큼의 숫자에서 랜덤 숫자 뽑아냄
			int random_number = (Integer) size_list.get(index);
			// 랜덤 값이 나온 값을 리스트에서 뽑아냄 (결국 랜덤으로 나온값을 뽑아내는것과 같음

			//System.out.println(random_number + "   count : " + i);
			//System.out.println(random_number);
			select_list.addLast(random_number);
			
			size_list.remove(index); // 뽑아낸 리스트 제거
		}	
		
		System.out.println(select_list.size());
		try{
			con = pool.getConnection();
			
			sql = "select word, meaning from tblword where no=?";
			String sql2 = "insert into tblt_word(word, meaning) values(?, ?)";
			pstmt = con.prepareStatement(sql);
			for(int i=0; i<select_list.size(); i++){
				int no = select_list.get(i);
				pstmt.setInt(1, no);
				rs = pstmt.executeQuery();
				rs.next();
				pstmt2 = con.prepareStatement(sql2);
				pstmt2.setString(1, rs.getString("word"));
				pstmt2.setString(2, rs.getString("meaning"));
				pstmt2.executeUpdate();
				//word_list.add(rs.getString("word") + "," + rs.getString("meaning"));
				//System.out.println((i+1) + ". " + rs.getString("word"));
			}

		}
		catch(Exception e){
			System.out.println("Sel_word() : " + e);
		}
		//return word_list;
	}
	public ArrayList<String> Print_word(){
		ArrayList<String> word_list = new ArrayList<String>();
		String sql = "select * from tblt_word";
	
		try{
			con = pool.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			for(int i=0; i<20; i++){
				rs.next();
				word_list.add(rs.getString("word") + "," + rs.getString("meaning"));
			}
		}
		catch(Exception e){
			
		}
		System.out.println("print" + word_list.size());
		return word_list;
	}
}

