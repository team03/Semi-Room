package cont;


public class FactoryCommand {
	
	//싱글톤 패턴
	private FactoryCommand(){}
	private static FactoryCommand instance = new FactoryCommand(); // 공장 한개만 만들어지게
	
	public static FactoryCommand getInstance(){
		return instance;
	}
	
	public Command createCommand(String cmd){
		
		if(cmd.equals("main")) // 로그인
			return new Main();
		else if(cmd.equals("login")) // 로그인
			return new Login();
		else if(cmd.equals("logout")) // 로그아웃
			return new Logout();
		else if(cmd.equals("sign_up")) // 회원가입
			return new Sign_up();
		else if(cmd.equals("m_modify")) // 회원 수정페이지(회원정보 옮기기)
			return new Modify();
		else if(cmd.equals("m_modify_ok")) // 회원 수정완료
			return new Modify_ok();
		else if(cmd.equals("zipcommand")) // 주소
			return new ZipCommand();
		return null;
	}
}
