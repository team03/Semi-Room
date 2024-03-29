<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:include page="right.jsp" flush="true"/> 
<br/><br/><br/><br/><br/>
<!DOCTYPE html>
<html>
<head>
<title>j calendar</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="kim/script/fullcalendar/fullcalendar.css" rel="stylesheet" />
<link href="kim/script/fullcalendar/fullcalendar.print.css" rel="stylesheet" media="print" />
<script src="kim/script/fullcalendar/lib/moment.min.js"></script>
<script src="kim/script/fullcalendar/lib/jquery.min.js"></script>
<script src="kim/script/fullcalendar/fullcalendar.min.js"></script>
<script src="kim/script/fullcalendar/lang-all.js"></script>
<script src="kim/script/jalert/jquery.alerts.js"></script>
<script>

$(document).ready(function() {
	$("#calendar").fullCalendar({
		header: {
			left: "prev,next today",
			center: "title",
			right: "month,agendaWeek,agendaDay"
		},

		lang: "ko",
		events: [
		         {
		        	title: 'My Event',
		            start: '2014-11-14'
		         }
		         ],
		editable: true,
		dayClick: function(date,jsEvent,view){
         var year = date.year();
         var month = date.month()+1;
         var day = date.date();
         alert(year +"/"+ month +"/" + day );
    	  },	
		eventClick: function(calEvent, jsEvent, view) {
			alert(year);
		},
		selectable: true,
		selectHelper: true,
		select: function(start, end) {
			jDetail("", "", "새 이벤트 만들기", function(r) {
				var title = r;
				var eventData;
				if (title) {
					eventData = {
						title: title,
						start: start,
						end: end
					};
					$('#calendar').fullCalendar('renderEvent', eventData, true); // stick? = true
				}
				$('#calendar').fullCalendar('unselect');
				
			});
		}
	});
});

</script>
<style>
body {
	margin: 0 10px;
	padding: 0;
	font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}


#popup_container {
	font-family: Arial, sans-serif;
	font-size: 12px;
	min-width: 300px; /* Dialog will be no smaller than this */
	max-width: 600px; /* Dialog will wrap after this width */
	background: #FFF;
	border: solid 5px #999;
	color: #000;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
}

#popup_title {
	font-size: 14px;
	font-weight: bold;
	text-align: center;
	line-height: 1.75em;
	color: #666;
	background: #CCC top repeat-x;
	border: solid 1px #FFF;
	border-bottom: solid 1px #999;
	cursor: default;
	padding: 0em;
	margin: 0em;
}

#popup_content {
	padding: 1em 1.75em;
	margin: 0em;
} 

#popup_panel {
	text-align: center;
	margin: 1em 0em 0em 1em;
}

#popup_prompt {
	margin: .5em 0em;
}
</style>
</head>
<body>
<div id='calendar'></div>
</body>
</html>