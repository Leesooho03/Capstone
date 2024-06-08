<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!------ Include the above in your HEAD tag ---------->
<script src='/assets/js/calendar/moment.min-2.1.js'></script>
<script src='/assets/js/calendar/jquery.min-2.1.js'></script>
<script src="/assets/js/calendar/jquery-ui.custom.min-2.1.js"></script>
<script src='/assets/js/calendar/fullcalendar.min-2.1.js'></script>
<script src="/assets/js/calendar/calendar.js"></script>
<script src="/assets/js/calendar/LunarCalendar.js"></script>
<script src="/assets/js/bootstrap4/bootstrap.bundle.js"></script>
<!-- <script src="/assets/js/bootstrap4/bootstrap.min.js"></script> -->
<script src="/assets/js/bootstrap4/bootstrap-datepicker.js"></script>
<script src="/assets/js/bootstrap4/bootstrap-datepicker.ko.min.js"></script>
<script src="/assets/js/bootstrap4/bootstrap-datepicker.min.js"></script>


<link href="/assets/css/calendar/calendar.css" rel="stylesheet"/>
<link href="/assets/css/bootstrap.min.css" rel="stylesheet" >
<link href="/assets/css/bootstrap-datepicker.css" rel="stylesheet" >
<link href="/assets/css/bootstrap-datepicker.min.css" rel="stylesheet" >

<!DOCTYPE html>

<html>


<head>



<link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">


</head>
<body>
<div id='wrap'>
<div id='calendar'>

</div>

<div style='clear:both'></div>
</div>
<input type="hidden" id="last_idx" name="last_idx" value="">
<div id="modal" class="modal-overlay modalcss">

        <div class="modal-window">
            <div class="title">
                <h2 class="title_text" style="font-family: 'Roboto', sans-serif !important;">일정 등록</h2>
            </div>
            <div class="close-area">X</div>
            <div class="modal_content" style="padding-bottom: 100px;">
            <input type="hidden" id="idx" name="idx" value="">
            <input type="hidden" id="allday" name="allday" value="">
            <input type="hidden" id="conFlag" name="conFlag" value="">
            <label>일정 제목</label>
            <input type="text" id="title" name="title" value="">
            <label>일정 내용</label>
            <textarea rows="4" cols="4" id="contents"  name="contents"></textarea>
            <label>일정 색상</label>
            <select id="className" name="className">
            	<option value="red">빨간색</option>
            	<option value="orange">주황색</option>
            	<option value="yellow">노란색</option>
            	<option value="green">초록색</option>
            	<option value="blue"  selected="selected">파란색</option>
            	<option value="navy">남색</option>
            	<option value="purple">보라색</option>
            </select>
            <label style="width: 52%; float: left;">시작 일자</label>
            <label style="width: 48%; float: left;">종료 일자</label>
            <input type="text" id="start_date" name="start" value="" class="datepicker0" style="width: 47%; float: left;" readonly="readonly">
            <span style="width: 2%; float: left; padding-left: 8px; padding-top: 7px">-</span>
            <input type="text" id="end_date" name="end" value="" class="datepicker0" style="width: 47%; float: right;" readonly="readonly">
            </div>
            <button value="저장" class="btn-primary" onclick="cal_save()">저장</button>
            <button value="취소" class="btn-delete" onclick="cal_delete()">삭제</button>
            <button value="취소" class="btn-cancel" onclick="modalOff()">취소</button>
        </div>
    </div>
    
    <div id="modal_admin" class="modal-overlay modalcss">

        <div class="modal-window">
            <div class="title">
                <h2 class="title_text" style="font-family: 'Roboto', sans-serif !important;">연동 등록</h2>
            </div>
            <div class="close-area">X</div>
            <div class="modal_content" style="padding-bottom: 100px;">
            <input type="hidden" id="idx" name="idx" value="">
            <input type="hidden" id="allday" name="allday" value="">
            <label>일정 제목</label>
            <input type="text" id="title" name="title" value="">
            <label>일정 내용</label>
            <textarea rows="4" cols="4" id="contents"  name="contents"></textarea>
            <label>일정 중요도</label>
            <select id="className" name="className">
            	<option value="base" selected="selected">기본</option>
            	<option value="info">중요</option>
            	<option value="important">매우 중요</option>
            </select>
            <label style="width: 52%; float: left;">시작 일자</label>
            <label style="width: 48%; float: left;">종료 일자</label>
            <input type="text" id="start_date" name="start" value="" class="datepicker0" style="width: 47%; float: left;" readonly="readonly">
            <span style="width: 2%; float: left; padding-left: 8px; padding-top: 7px">-</span>
            <input type="text" id="end_date" name="end" value="" class="datepicker0" style="width: 47%; float: right;" readonly="readonly">
            </div>
            <button value="저장" class="btn-primary" onclick="cal_save()">저장</button>
            <button value="취소" class="btn-delete" onclick="cal_delete()">삭제</button>
            <button value="취소" class="btn-cancel" onclick="modalOff()">취소</button>
        </div>
    </div>
<form style="display: none" action="/calendar.do" method="POST" id="connectForm">
  <input type="hidden" id="conDB" name="conDB" value=""/>
</form>
</body>
<script>
var conDB = '${conDB}';
/* function connection(){
	conDB_yn();
} */

console.log(Resut("20220101"));
	$(document).ready(function() {
		
		$('.datePicker0').datepicker({
			format: 'yyyy-mm-dd', //데이터 포맷 형식(yyyy : 년 mm : 월 dd : 일 )
//			startDate: '-10d', //달력에서 선택 할 수 있는 가장 빠른 날짜. 이전으로는 선택 불가능 ( d : 일 m : 달 y : 년 w : 주)
//			endDate: '+10d', //달력에서 선택 할 수 있는 가장 느린 날짜. 이후로 선택 불가 ( d : 일 m : 달 y : 년 w : 주)
			autoclose: true, //사용자가 날짜를 클릭하면 자동 캘린더가 닫히는 옵션
//			calendarWeeks: false, //캘린더 옆에 몇 주차인지 보여주는 옵션 기본값 false 보여주려면 true
//			clearBtn: false, //날짜 선택한 값 초기화 해주는 버튼 보여주는 옵션 기본값 false 보여주려면 true
//			datesDisabled: ['2019-06-24', '2019-06-26'], //선택 불가능한 일 설정 하는 배열 위에 있는 format 과 형식이 같아야함.
//			daysOfWeekDisabled: [0, 6], //선택 불가능한 요일 설정 0 : 일요일 ~ 6 : 토요일
//			daysOfWeekHighlighted: [3], //강조 되어야 하는 요일 설정
//			disableTouchKeyboard: false, //모바일에서 플러그인 작동 여부 기본값 false 가 작동 true가 작동 안함.
//			immediateUpdates: false, //사용자가 보는 화면으로 바로바로 날짜를 변경할지 여부 기본값 :false
//			multidate: false, //여러 날짜 선택할 수 있게 하는 옵션 기본값 :false
//			multidateSeparator: ',', //여러 날짜를 선택했을 때 사이에 나타나는 글짜 2019-05-01,2019-06-01
			templates: {
			leftArrow: '&laquo;',
			rightArrow: '&raquo;',
			}, //다음달 이전달로 넘어가는 화살표 모양 커스텀 마이징
			showWeekDays: true, // 위에 요일 보여주는 옵션 기본값 : true
//			title: '테스트', //캘린더 상단에 보여주는 타이틀
			todayHighlight: true, //오늘 날짜에 하이라이팅 기능 기본값 :false
			toggleActive: true, //이미 선택된 날짜 선택하면 기본값 : false인경우 그대로 유지 true인 경우 날짜 삭제
			weekStart: 0, //달력 시작 요일 선택하는 것 기본값은 0인 일요일
			language: 'ko', //달력의 언어 선택, 그에 맞는 js로 교체해줘야한다.
			})
			.on('changeDate', function (e) {
			/* 이벤트의 종류 */
			//show : datePicker가 보이는 순간 호출
			//hide : datePicker가 숨겨지는 순간 호출
			//clearDate: clear 버튼 누르면 호출
			//changeDate : 사용자가 클릭해서 날짜가 변경되면 호출 (개인적으로 가장 많이 사용함)
			//changeMonth : 월이 변경되면 호출
			//changeYear : 년이 변경되는 호출
			//changeCentury : 한 세기가 변경되면 호출 ex) 20세기에서 21세기가 되는 순간
			console.log(e);
			// e.date를 찍어보면 Thu Jun 27 2019 00:00:00 GMT+0900 (한국 표준시) 위와 같은 형태로 보인다.	
	});
		
		
		
		
		
		
		
		
		
		
		
	    var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		
		var event =[];
		
		for (var year=y; year<2044; year++){
			event.push(
						{
							title : "신정",
							start : new Date(year,0,1),
							className : "red",
							editable : false
						},	
						{
							title : "설날연휴",
							start : new Date(year, Resut(String(year)+"0101").substr(0,2)-1,Number(Resut(String(year)+"0101").substr(3,5))-Number(1)),
							end : new Date(year, Resut(String(year)+"0101").substr(0,2)-1,Number(Resut(String(year)+"0101").substr(3,5))+Number(1)),
							className : "red",
							editable : false
						},	
						{
							title : "삼일절",
							start : new Date(year,2,1),
							className : "red",
							editable : false
						},
						{
							title : "어린이날",
							start : new Date(year,4,5),
							className : "red",
							editable : false
							
						},
						{
							title : "부처님오신날",
							start : new Date(year, Resut(String(year)+"0408").substr(0,2)-1,Resut(String(year)+"0408").substr(3,5)),
							className : "red",
							editable : false
						},
						{
							title : "현충일",
							start : new Date(year,5,6),
							className : "red",
							editable : false
						},
						{
							title : "광복절",
							start : new Date(year,7,15),
							className : "red",
							editable : false
						},
						{
							title : "추석연휴",
							start : new Date(year, Resut(String(year)+"0815").substr(0,2)-1,Number(Resut(String(year)+"0815").substr(3,5))-Number(1)),
							end : new Date(year, Resut(String(year)+"0815").substr(0,2)-1,Number(Resut(String(year)+"0815").substr(3,5))+Number(1)),
							className : "red",
							editable : false
						},
						{
							title : "개천절",
							start : new Date(year,9,3),
							className : "red",
							editable : false
						},
						{
							title : "한글날",
							start : new Date(year,9,9),
							className : "red",
							editable : false
						},
						{
							title : "크리스마스",
							start : new Date(year,11,25),
							className : "red",
							editable : false
						},
			)
		}
		console.log(new Date(2024,0,25,12,30,30))
// 		event.push({
// 			id : 1,
// 			title : "tesat",
// 			start : "2022-04-13",
// 			end : "2022-04-13",
// 			eventDurationEditable: true,
// 			editable : true,
// 			className : "important"
// 		})
		$.ajax({
			url: '/calendar_list.do?conDB=${conDB}',
			type: 'POST',
			dataType: 'json',
			async : false,
			
			success: function(data) {
				var last_idx = "";
				if(data.flag){
					
					$.each(data.result,function(index,clist){
						last_idx = clist.idx;
						event.push({
							id : clist.idx,
							title : clist.title,
							start : clist.start,
							end : clist.end,
							className : clist.className,
							conFlag : clist.conFlag
						})
					});
					console.log(event);
					$("#last_idx").val(last_idx);
				}
// 				successCallback(event);
			},
			error: function(request,status,error) {
				console.log(request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				return false;
			}
		}); 
// 		alert(JSON.stringify(event)+",");
		
		var datas = event;
		/*  className colors
		
		className: default(transparent), important(red), chill(pink), success(green), info(blue)
		
		*/		
		
		  
		/* initialize the external events
		-----------------------------------------------------------------*/
	
		$('#external-events div.external-event').each(function() {
		
			// create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
			// it doesn't need to have a start or end
			var eventObject = {
				title: $.trim($(this).text()) // use the element's text as the event title
			};
			
			// store the Event Object in the DOM element so we can get to it later
			$(this).data('eventObject', eventObject);
			
			// make the event draggable using jQuery UI
			$(this).draggable({
				zIndex: 999,
				revert: true,      // will cause the event to go back to its
				revertDuration: 0  //  original position after the drag
			});
			
		});
	
	
		/* initialize the calendar
		-----------------------------------------------------------------*/
		console.log(datas)
		var calendar =  $('#calendar').fullCalendar({
			header: {
				left: 'title',
				center: 'agendaDay,agendaWeek,month',
				right: 'prev,next today'
			},
			editable: true,
			firstDay: 0, //  1(Monday) this can be changed to 0(Sunday) for the USA system
			selectable: true,
			defaultView: 'month',
			
			axisFormat: 'h:mm',
			columnFormat: {
                month: 'ddd',    // Mon
                week: 'ddd d', // Mon 7
                day: 'dddd M/d',  // Monday 9/7
                agendaDay: 'dddd d'
            },
            titleFormat: {
                month: 'yyyy년 MMMM', // September 2009
                week: "yyyy년 MMMM", // September 2009
                day: 'yyyy년 MMMM'                  // Tuesday, Sep 8, 2009
            },
			allDaySlot: false,
			selectHelper: true,
			select: function(start, end, allDay) {
				modalOn();
				
				$("#start_date").val(getDay(start));
				$("#end_date").val(getDay(end));
				$("#allDay").val(allDay);
				
				calendar.fullCalendar('unselect');
			},
			droppable: true, // this allows things to be dropped onto the calendar !!!
			eventClick: function(info,event,view){
				modalOn(info.id, info.conFlag);
			},
			
			
			eventDrop: function(date, daydelta, minuteDelta, allDay, revertFunc) { // this function is called when something is dropped
				// retrieve the dropped element's stored Event Object
				if(!confirm("일정을 수정하시겠습니까?")){
					console.log(revertFunc);
					revertFunc();
					return;
				}
				var originalEventObject = $(this).data('eventObject');
				
// 				// we need to copy it, so that multiple events don't have a reference to the same object
				var copiedEventObject = $.extend({}, originalEventObject);
				
// 				// assign it the date that was reported
				copiedEventObject.start = date;
				copiedEventObject.allDay = allDay;
				
				var start_date = "";
				var end_date = "";
				
				start_date = getDay(date.start);
				
				if(date.end == null){
					end_date = getDay(date.start);
				}else{
					end_date = getDay(date.end);
				}
				
				$.ajax({
					url: '/calendar_update.do',
					type: 'POST',
					dataType: 'json',
					data:{
						idx : date.id,
						start: start_date,
						end: end_date,
						conFlag: date.conFlag
						},
					async : false,
					success: function(data) {
						
					},
					error: function(request,status,error) {
						console.log(request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
						return false;
					}
				});
				
				
				
				
				
// 				
			
				
				// render the event on the calendar
				// the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
				$('#calendar').fullCalendar('renderEvent', copiedEventObject, true);
				
				// is the "remove after drop" checkbox checked?
				if ($('#drop-remove').is(':checked')) {
					// if so, remove the element from the "Draggable Events" list
					$(this).remove();
				}
				
			},
			
			events: datas,
			
		});
		
			if(conDB!=""){
				$("#conDB_connect").val(conDB);
				$("#conDB_connect").prop('checked',true);
			}
	});
	
</script>
<script src="/assets/js/calendar/calFunc.js"></script>

</html>
    