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
			 * con = pool.getConnection(); ���⼭ �����ص� ������, ������ ���ؼ� ������ �ִ��� �ʰ�, ������
			 * ���� ���� �ִ��� ����!
			 */
		} catch (Exception err) {
			System.out.println("���� ���� : " + err);
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
			size_list.addLast(i); // 1~100������ ���� ���� ����

		Random random = new Random();

		for (int i = size; i > size-20; i--){
			int index = random.nextInt(i); // ���� list ���� ��ŭ�� ���ڿ��� ���� ���� �̾Ƴ�
			int random_number = (Integer) size_list.get(index);
			// ���� ���� ���� ���� ����Ʈ���� �̾Ƴ� (�ᱹ �������� ���°��� �̾Ƴ��°Ͱ� ����

			//System.out.println(random_number + "   count : " + i);
			//System.out.println(random_number);
			select_list.addLast(random_number);
			
			size_list.remove(index); // �̾Ƴ� ����Ʈ ����
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

