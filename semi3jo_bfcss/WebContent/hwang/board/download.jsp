<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="java.io.*"%>

<%
	request.setCharacterEncoding("euc-kr");

	String name = request.getParameter("name");
	String realPath = getServletContext().getRealPath("hwang/upload"); // 실제 경로 준비 
	System.out.println(realPath);
	response.setContentType("Application/octet-stream"); // 내가 선택한 파일의 content타입 전달 -> 임의로 지정 가능
															//octet stream 다운로드 받을 때 쪼개서 받으라고 
	response.setHeader("content-Disposition", "attachment;filename=" + name);
	
	File f = new File(realPath + "/" + new String(name.getBytes("8859_1"), "euc-kr"));
	byte[] data = new byte[1024]; // 1024바이트로 묶어서 전달

	try{
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(f));
		
		BufferedOutputStream output = new BufferedOutputStream(response.getOutputStream());
		
		int read = input.read(data); // 1024바이트 만큼씩 읽어들인다 
		while(read != -1){
			output.write(data, 0, read);
			read = input.read(data);
		}
		output.close();
		output.flush();
		input.close();
		
	}
	
	catch(Exception err){
		err.printStackTrace();
	}
%>