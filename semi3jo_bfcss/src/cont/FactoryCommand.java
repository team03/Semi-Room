package cont;


public class FactoryCommand {
	
	//�̱��� ����
	private FactoryCommand(){}
	private static FactoryCommand instance = new FactoryCommand(); // ���� �Ѱ��� ���������
	
	public static FactoryCommand getInstance(){
		return instance;
	}
	
	public Command createCommand(String cmd){
		
		if(cmd.equals("main")) // �α���
			return new Main();
		else if(cmd.equals("login")) // �α���
			return new Login();
		else if(cmd.equals("logout")) // �α׾ƿ�
			return new Logout();
		else if(cmd.equals("sign_up")) // ȸ������
			return new Sign_up();
		else if(cmd.equals("m_modify")) // ȸ�� ����������(ȸ������ �ű��)
			return new Modify();
		else if(cmd.equals("m_modify_ok")) // ȸ�� �����Ϸ�
			return new Modify_ok();
		else if(cmd.equals("zipcommand")) // �ּ�
			return new ZipCommand();
		return null;
	}
}
