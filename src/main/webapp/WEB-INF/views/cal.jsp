<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.hy.capstone.schedule.*" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset='utf-8' />
  <!-- 화면 해상도에 따라 글자 크기 대응(모바일 대응) -->
  <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
  <!-- jquery CDN -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <!-- fullcalendar CDN -->
  <link href='https://fastly.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css' rel='stylesheet' />
  <script src='https://fastly.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
  <!-- fullcalendar 언어 CDN -->
  <script src='https://fastly.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>
<style>
  /* body 스타일 */
  body {
    margin-top: 40px;
    font-size: 14px;
    font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
  }
 
  #calendar1 {
    max-width: 1100px;
    margin: 0 auto;
  }
</style>
</head>
<body>

  <div id='wrap'>
    <!-- calendar 태그 -->
    <div id='calendar-wrap'>
      <div id='calendar1'></div>
    </div>
  </div>
  <script>
  (function(){
      document.addEventListener('DOMContentLoaded', function() {
      // calendar element 취득
      var calendarEl = $('#calendar1')[0];
      // full-calendar 생성하기
      var calendar = new FullCalendar.Calendar(calendarEl, {
    	  googleCalendarApiKey: "AIzaSyBk0bTOmuFKRotC8vOYZFL725VgTsy5D2M",
    	  height:'700px',
    	  expandRows:true,
        // 해더에 표시할 툴바
        headerToolbar: {
          right: 'prev,next today',
          center: 'title',
          left:'',
        },
        selectable: true,
        selectMirror: true,
        select: function(arg) {
      	  console.log(arg);

          var title = prompt('입력할 일정:');
          if (title) {
            calendar.addEvent({
              title: title,
              start: arg.start,
              end: arg.end,
              allDay: arg.allDay,
              backgroundColor:"yellow",
              textColor:"blue"
            })
          }
          calendar.unselect()
        },
        eventClick: function(arg) {
          if (confirm('일정 삭제?')) {
            arg.event.remove()
          }
        },
        editable: true,
        dayMaxEvents: true,
        events:{
        	googleCalendarId: 'ko.south_korea.official#holiday@group.v.calendar.google.com',
        	backgroundColor:"red"
        	 },
      });
      // 캘린더 랜더링
      calendar.render();
    });
  })();
</script>
</body>
</html>