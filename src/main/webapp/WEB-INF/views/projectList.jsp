<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- <%@ page session="false" %> --%>
<%@page import="com.hy.capstone.project.ProjectVO"%>
<!doctype html>
<html lang="kr">

<head>
    <meta http-equiv="Content-Type" contentType="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modernize Free</title>
    <link rel="shortcut icon" type="image/png" href="../assets/images/logos/favicon.png" />
    <link rel="stylesheet" href="/assets/css/styles.min.css" />
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            color: #333;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        .td_subject {
            cursor: pointer;
            font-weight: bold;
        }

        .tab_sch {
            margin-bottom: 20px;
        }

        .sch_sel, .sch_txt, .sch_btn, .inst_btn, .del_btn {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 16px;
        }

        .sch_btn {
            background-color: #007bff;
            color: #fff;
            cursor: pointer;
        }
        .inst_btn {
            background-color: #21ab1f;
            color: #fff;
            cursor: pointer;
        }
        .del_btn {
            background-color: #ff1a00;
            color: #fff;
            cursor: pointer;
        }

        .sch_btn:hover {
            background-color: #0056b3;
        }
        .inst_btn:hover {
            background-color: #336d32;
        }
        .del_btn:hover {
            background-color: #9b1a0b;
        }

        .page_list {
            margin-top: 20px;
            text-align: center;
        }
        .modal{
            position:absolute;
            display:none;
            
            justify-content: center;
            top:0;
            left:0;

            width:100%;
            height:100%;

            

            background-color: rgba(0,0,0,0.4);
        }
        .modal_body{
            position:absolute;
            top:50%; 
        

            width:50%; 
            height:90%;

            padding:40px;  

            text-align: center;

            background-color: rgb(255,255,255); 
            border-radius:10px; 
            box-shadow:0 2px 3px 0 rgba(34,36,38,0.15); 

            transform:translateY(-50%); 
        }
    </style>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>

<body>
  <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
    data-sidebar-position="fixed" data-header-position="fixed">
        <%@include file = "sidebar.jsp" %>
	<div class="body-wrapper">
         <%@include file = "header.jsp" %>
	    <div class="container-fluid">
	    <!-- Modal Start -->
	    <div class="modal">
	    <div class="modal_body">
	    	<h2>프로젝트 등록</h2>
			<button type="button" class="btn-close" data-dismiss="modal" style="float:right;"></button>
	    	<form action="/insertProject.do" enctype="multipart/form-data" method="post" onsubmit="return validateForm()">
			    <label for="project_name">프로젝트명:</label>
				<input type="text" id="project_name" name="project_name" placeholder="프로젝트명"><br>
				<span id="project_name_error" style="color: red;"></span>
				
				<label for="project_cost">프로젝트 비용:</label>
				<input type="text" id="project_cost" name="project_cost" placeholder="프로젝트 비용"><br>
				<span id="project_cost_error" style="color: red;"></span>
				
				<label for="project_manage">프로젝트 관리자:</label>
				<input type="text" id="project_manage" name="project_manage" placeholder="프로젝트 관리자"><br>
				<span id="project_manage_error" style="color: red;"></span>
				
				<label for="company_name">협력업체명:</label>
				<select id="company_name" name="company_id">
				    <c:forEach items="${companyList}" var="company">
				        <option value="${company.company_id}">${company.company_name}</option>
				    </c:forEach>
				</select></br>
				<span id="company_name_error" style="color: red;"></span>
				
				<label for="start_date">시작일:</label>
				<input type="date" id="start_date" name="start_date" placeholder="시작일"><br>
				<span id="start_date_error" style="color: red;"></span>
				
				<label for="end_date">종료일:</label>
				<input type="date" id="end_date" name="end_date" placeholder="종료일"><br>
				<span id="end_date_error" style="color: red;"></span>

			    
			    <label for="project_contents">프로젝트 내용:</label>
			    <textarea id="project_contents" name="project_contents" placeholder="프로젝트 내용"></textarea><br>
			    <span id="error_message" style="color: red;"></span>
			    
			    <label for="manage_phone">관리자 전화번호:</label>
			    <input type="text" id="manage_phone" name="manage_phone" placeholder="관리자 전화번호"><br>
			    <span id="error_message" style="color: red;"></span>
			    
			    <label for="manage_group">관리 그룹:</label>
			    <input type="text" id="manage_group" name="manage_group" placeholder="관리 그룹"><br>
			    <span id="error_message" style="color: red;"></span>
			    
			    <label for="company_phone">회사 전화번호:</label>
			    <input type="text" id="company_phone" name="company_phone" placeholder="회사 전화번호"><br>
			    <span id="error_message" style="color: red;"></span>
			    
			    <button type="submit">등록</button>
			</form>

	    </div>
	    </div>
	    <!-- Modal End -->
	        <div class="tab_sch">
	            <form name="frmSrch" method="post" onsubmit="return true">
	                <select name="search_flg" class="sch_sel">
	                    <option value="title" ${pVO.search_flg == 'title' ? 'selected="selected"' : '' }>제목</option>
	                    <option value="content" ${pVO.search_flg == 'content' ? 'selected="selected"' : '' }>내용</option>
	                </select>
	                <input type="text" name="search" class="sch_txt" value="${pVO.search}" />
	                <input type="button" value="검색" class="sch_btn" onclick="srch()" />
	            	<input type="button" value="등록" class="inst_btn" onclick="inst()"/>
	            	<input type="button" value="삭제" class="del_btn" onclick="delProject()"/>
	            </form>
	        </div>
        <table>
            <colgroup>
            	<col width="5%">
                <col width="5%">
                <col width="30%">
                <col width="25%">
                <col width="25%">
            </colgroup>
            <tr>
			    <th></th>
			    <th>순번</th>
			    <th>제목</th>
			    <th>등록자</th>
			    <th>등록일</th>
			</tr>
			<colgroup>
			    <col width="5%">
			    <col width="5%">
			    <col width="30%">
			    <col width="25%">
			    <col width="25%">
			</colgroup>
			<c:forEach items="${projectList}" var="project" varStatus="loop">
			    <tr>
			        <td><input type="checkbox" id="project_${loop.index}" name="selectedProjects" value="${project.project_id}" /></td>
			        <td>${pg + loop.index}</td>
			        <td class="td_subject" onclick="pg_detail('${project.project_id}')">${project.project_name}</td>
			        <td>${project.project_manage}</td>
			        <td>${project.reg_date}</td>
			    </tr>
			</c:forEach>
        </table>

        <div class="page_list">
			<nav aria-label="Page navigation">
			    <ul class="pagination">
			        <li class="page-item">
			            <a class="page-link" name="prev" onclick="pageMove('prev', ${pg})">prev</a>
			        </li>
			        <c:forEach var="pageNo" begin="1" end="${totalPageCount}">
			            <li class="page-item">
			                <a class="page-link" name="now" onclick="pageMove('now', ${pageNo})">${pageNo}</a>
			            </li>
			        </c:forEach>
			        <li class="page-item">
			            <a class="page-link" name="next" onclick="pageMove('next', ${pg})">next</a>
			        </li>
			    </ul>
			</nav>
       </div>
    </div>
</div>
</div>
    <script>
window.onload = function() {
    var urlParams = new URLSearchParams(window.location.search);
    var searchFlg = urlParams.get('search_flg');
    var searchValue = urlParams.get('search');

    if (searchFlg && searchValue) {

    	document.querySelector(".sch_sel").value = searchFlg;
        document.querySelector(".sch_txt").value = searchValue;
    }
};

function srch() {
    var searchFlg = document.querySelector(".sch_sel").value;
    var searchValue = document.querySelector(".sch_txt").value;

    var currentUrl = window.location.href;

    var url = new URL(currentUrl);
    url.searchParams.set('search_flg', searchFlg);
    url.searchParams.set('search', searchValue);

    window.location.href = url.toString();
}


        function inst() {
        	const modal = document.querySelector('.modal');
//         	const instBtn = document.querySelector('.inst_btn');
        	
//         	instBtn.addEventListener("click", ()=>{
        		modal.style.display="flex";
//         	});
			var btnClose = document.querySelector('.btn-close');
			btnClose.addEventListener('click', function() {
			modal.style.display = 'none';
                });
		}
        
        
        function pg_detail(projectId) {
            window.location.href = "/projectDtl.do?project_id=" + projectId;
        }
        
 
        function delProject() {
            var checkboxes = document.getElementsByName("selectedProjects");
            var selectedIds = [];
            for (var i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].checked) {
                    selectedIds.push(checkboxes[i].value);
                }
            }
            if (selectedIds.length === 0) {
                alert("삭제할 프로젝트를 선택하세요.");
                return;
            }

            var form = document.createElement("form");
            form.method = "POST";
            form.action = "/deleteProjects.do";

            for (var j = 0; j < selectedIds.length; j++) {
                var input = document.createElement("input");
                input.type = "hidden";
                input.name = "projectIds";
                input.value = selectedIds[j];
                form.appendChild(input);
            }

            document.body.appendChild(form);
            form.submit();
        }
        
        function validateForm() {
            var projectName = document.getElementById("project_name").value;
            var projectCost = document.getElementById("project_cost").value;
            var projectManage = document.getElementById("project_manage").value;
            var companyName = document.getElementById("company_name").value;
            var companyManage = document.getElementById("company_manage").value;
            var startDate = document.getElementById("start_date").value;
            var endDate = document.getElementById("end_date").value;

            var isValid = true;

            if (projectName === "") {
                document.getElementById("project_name_error").innerHTML = "프로젝트명은 필수 입력값입니다.<br>";
                isValid = false;
            } else {
                document.getElementById("project_name_error").innerHTML = "";
            }
            if (projectCost === "") {
                document.getElementById("project_cost_error").innerHTML = "프로젝트 비용은 필수 입력값입니다.<br>";
                isValid = false;
            } else {
                document.getElementById("project_cost_error").innerHTML = "";
            }
            if (projectManage === "") {
                document.getElementById("project_manage_error").innerHTML = "프로젝트 관리자는 필수 입력값입니다.<br>";
                isValid = false;
            } else {
                document.getElementById("project_manage_error").innerHTML = "";
            }
            if (companyName === "") {
                document.getElementById("company_name_error").innerHTML = "협력업체명은 필수 입력값입니다.<br>";
                isValid = false;
            } else {
                document.getElementById("company_name_error").innerHTML = "";
            }
            if (startDate === "") {
                document.getElementById("start_date_error").innerHTML = "시작일은 필수 입력값입니다.<br>";
                isValid = false;
            } else {
                document.getElementById("start_date_error").innerHTML = "";
            }
            if (endDate === "") {
                document.getElementById("end_date_error").innerHTML = "종료일은 필수 입력값입니다.<br>";
                isValid = false;
            } else {
                document.getElementById("end_date_error").innerHTML = "";
            }

            return isValid;
        }

        var totalPageCount = [[${totalPageCount}]];

        function pageMove(action,pg) {
 
          var searchValue = document.querySelector(".sch_txt").value;
          console.log("schv : " + searchValue );
          var form = document.createElement("form");
          form.method = "POST";
          form.action = "/projectList.do";
         
          var pageNoInput = document.createElement("input");
          pageNoInput.type = "hidden";
          pageNoInput.name = "pg";
          pageNoInput.value = pg;
          form.appendChild(pageNoInput);

          var searchInput = document.createElement("input");
          searchInput.type = "hidden";
          searchInput.name = "search";
          searchInput.value = searchValue;
          form.appendChild(searchInput);

          
          if (action === 'prev') {
            if(pg>1){
              pageNoInput.value = pg-1;
            }
          } else if (action === 'next') {
            if(pg<totalPageCount)
              pageNoInput.value = pg+1;
          }


          document.body.appendChild(form);
          form.submit();
        }

        
    </script>
  <script src="/assets/libs/jquery/dist/jquery.min.js"></script>
  <script src="/assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <script src="/assets/js/sidebarmenu.js"></script>
  <script src="/assets/js/app.min.js"></script>
  <script src="/assets/libs/simplebar/dist/simplebar.js"></script>
</body>

</html>
