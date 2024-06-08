
function cal_save(){
	let idx = "";
	let title ="";
	let contents ="";
	let start ="";
	let end ="";
	let allDay ="";
	let className ="";
	
	idx = $("#idx").val();
	title = $("#title").val();
	contents = $("#contents").val();
	start = $("#start_date").val();
	end = $("#end_date").val();
	allDay = $("#allDay").val();
	className = $("#className option:selected").val();
	
	
//	if(!confirm("일정을 저장하시겠습니까?")){
//		return;
//	}else{
		var start_date = getDay(start);
		var end_date = getDay(end);
		if(idx==null || idx==""){
		$('#calendar').fullCalendar('renderEvent',
				{
					id: Number($("#last_idx").val())+1,
					title: title,
					start: start,
					end: end,
					allDay: allDay,
					className : className
				},
				
				true // make the event "stick"
			);
			
			
			
			$.ajax({
				url: '/calendar_insert.do',
				type: 'POST',
				dataType: 'json',
				data:{

					title: title,
					contents: contents,
					start: start_date,
					end: end_date,
					className : className},
				async : false,
				success: function(data) {
					
					if(data.flag){
						$("#last_idx").val(data.liidx);
						alert("등록되었습니다.");
						location.reload();

						
					}
//	 				successCallback(event);
				},
				error: function(request,status,error) {
					alert(request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					return false;
				}
			});
			modalOff();
		}
		else{
			//수정
			$.ajax({
				url: '/calendar_update.do',
				type: 'POST',
				dataType: 'json',
				data:{
					idx : idx,
					title: title,
					contents: contents,
					start: start_date,
					end: end_date,
					className : className},
				async : false,
				success: function(data) {
					
					if(data.flag){
							alert("수정되었습니다");
							location.reload();
					}
//	 				successCallback(event);
				},
				error: function(request,status,error) {
					alert(request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
					return false;
				}
			});
			modalOff();
		}
//	}
}

function cal_delete(){
	let idx = ""
	let conFlag = ""
	idx = $("#idx").val();
	conFlag = $("#conFlag").val();
	
	if(conFlag=="con"){
		alert("연동데이터는 달력에서 삭제 하실수 없습니다. 연동시스템에서 삭제해 주십시오");
		return;
	}
	if(!confirm("일정을 삭제하시겠습니까?")){
		return;
	}else{
		$.ajax({
			url: '/calendar_delete.do',
			type: 'POST',
			dataType: 'json',
			data:{
				idx : idx},
			async : false,
			success: function(data) {
				
				if(data.flag){
//						alert("삭제되었습니다");
						location.reload();
				}
// 				successCallback(event);
			},
			error: function(request,status,error) {
				alert(request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				return false;
			}
		});
		modalOff();
	}
}

function connection(){
	 if($("#conDB_connect").is(":checked")){
		 if(!confirm("연동데이터를 가져오시겠습니까?")){
			 return;
		 }
        $("#conDB").val("mes4_std");
     }else{
    	 if(!confirm("연동데이터를 지우시겠습니까?")){
			 return;
		 }
    	 $("#conDB").val("");
     }
	 $("#connectForm").submit();
	
//	
//	if(conDB==""){
//		location.href='/calendar.do';
//	}else{
//		location.href='/calendar.do?conDB='+conDB;
//	}
}


const modal = document.getElementById("modal")
function modalOn(sidx , sconFlag) {
    modal.style.display = "flex"
    
	$("#idx").val("");
   	$("#title").val("");
	$("#contents").val("");
	$("#start_date").val("");
	$("#end_date").val("");
	$("#conFlag").val("");
	
	if(sconFlag=="con"){
		$("#contents").attr("readonly","readonly").attr("placeholder","달력에서는 연동데이터의 내용을 수정할 수 없습니다.");
		$("#className").val("important").prop("selected",true);
		$("#className").attr("disabled","disabled");
		
	}
    
    if(sidx==null){
	    $("#title").focus();
    	$(".title_text").text("일정 등록")
    	$(".btn-delete").css("display","none");
    }else{
    	$(".title_text").text("일정 수정")
    	$(".btn-delete").css("display","inline-block");
    	
    	
    	$.ajax({
			url: '/calendar_event_content.do',
			type: 'POST',
			dataType: 'json',
			data:{
				idx : sidx,
				conFlag : sconFlag,
				},
			async : false,
			success: function(data) {
				$("#idx").val(data.result.idx);
				$("#title").val(data.result.title);
				$("#contents").val(data.result.contents);
				$("#start_date").val(data.result.start);
				$("#end_date").val(data.result.end);
 				$("#className").val(data.result.className).prop("selected",true);
 				$("#conFlag").val(data.result.conFlag);
			},
			error: function(request,status,error) {
				alert(request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				return false;
			}
		});
    	
    	
    	
    }
    
    
    
}
function isModalOn() {
    return modal.style.display === "flex"
}
function modalOff() {
    modal.style.display = "none"
}
const closeBtn = modal.querySelector(".close-area")
closeBtn.addEventListener("click", e => {
    modalOff()
})
modal.addEventListener("click", e => {
    const evTarget = e.target
    if(evTarget.classList.contains("modal-overlay")) {
        modalOff()
    }
})
window.addEventListener("keyup", e => {
    if(isModalOn() && e.key === "Escape") {
        modalOff()
    }
})

function getDay(day){
    var date = new Date(day);
    var year = date.getFullYear();
    var month = ("0" + (1 + date.getMonth())).slice(-2);
    var day = ("0" + date.getDate()).slice(-2);

    return year + "-" + month + "-" + day;
}
