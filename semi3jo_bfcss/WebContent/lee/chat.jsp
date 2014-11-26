<%@ page contentType="text/html; charset=EUC-KR" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>WebSocket 05</title>
<link href="/semi3jo_bfcss/bootstrap/css/bootstrap.css" rel="stylesheet" />
<script src="/semi3jo_bfcss/bootstrap/js/jquery-2.1.1.js"></script>
</head>
<body>
<div class="container">
<!--<jsp:include page="../right.jsp" flush="true"/> 
 <button class="btn btn-small" onclick="this.nextSibling.style.display=(this.nextSibling.style.display=='none')?'block':'none';" href="javascript:void(0)"> 
	채팅하기<span class="caret"></span>
	</button><div class="container" style="DISPLAY: none">-->
	    <div id="send-message" class="well span3">
	      <h2>채팅</h2>
	      
	      <textarea  id="usersTextArea" rows="5" class="span3" readonly="readonly"></textarea>
	      <hr/>
	      <textarea id="messagesTextArea" rows="20" class="span3" style="overflow: auto; "></textarea>
	      <hr/>	    
	      <label>메시지</label>
	      <input type="text" name="msg" id="messageText" class="span3" placeholder="닉네임 입력" value="<%=session.getAttribute("name")%>" onkeydown="chkEnter()" />
	      <button id="btn-send" class="btn btn-primary pull-right" onclick="sendMessage()">채팅시작</button>
    	</div>
</div>
	<script type="text/javascript">
		var webSocket = new WebSocket("ws://192.168.10.32:8080/SemiPjt_Login/endpointserverdemo");
		var messagesTextArea = document.getElementById("messagesTextArea");
		
		webSocket.onmessage = function processMessage(message){
			var jsonData = JSON.parse(message.data);
			if(jsonData.message != null){
				messagesTextArea.value += jsonData.message + "\n";
				messagesTextArea.scrollTop = messagesTextArea.scrollHeight;
			}
			if(jsonData.users != null){
				usersTextArea.value="";
				var i=0;
				while(i<jsonData.users.length)usersTextArea.value += jsonData.users[i++] + "\n";
			}
		}
		function sendMessage(){
			webSocket.send(messageText.value);
			messageText.value="";
			
			$("input[placeholder='닉네임 입력']").attr("placeholder", "메시지 입력");
			$("#btn-send").text("전송");
		}
		
		function chkEnter() {
			if (event.which || event.keyCode) {
				if ((event.which == 13) || (event.keyCode == 13)) { 
                	document.getElementById("btn-send").click();
                	return false;
               	}
        	}
        	else {       
            	return true;
        	}
    	}
    	

		window.onbeforeunload=function(){
			webSocket.onclose=function(){};
			webSocket.close();
		};
	</script>		
</body>
</html>