<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page session="false" %>

<!doctype html>
<html lang="kr">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>프로젝트 상세 정보</title>
    <link rel="shortcut icon" type="image/png" href="../assets/images/logos/favicon.png" />
    <link rel="stylesheet" href="/assets/css/styles.min.css" />
    <style>
        .table-container {
            margin-top: 20px;
        }

        .back-button {
            margin-top: 20px;
        }
    </style>
</head>

<body>
    <div class="container">
        <h2>프로젝트 상세 정보</h2>
        <form id="projectForm" action="/updateProject.do" method="post" enctype="multipart/form-data">
            <div class="table-container">
                <table>
	                <tr>
						<td><input type="hidden" name="project_id" value="${projectDtl.project_id}"></td>
                    </tr>
                    <tr>
                        <td>프로젝트명:</td>
                        <td><input type="text" name="project_name" value="${projectDtl.project_name}" /></td>
                    </tr>
                    <tr>
                        <td>프로젝트 비용:</td>
                        <td><input type="text" name="project_cost" value="${projectDtl.project_cost}" /></td>
                    </tr>
                    <tr>
                        <td>프로젝트 담당자:</td>
                        <td><input type="text" name="project_manage" value="${projectDtl.project_manage}" /></td>
                    </tr>
                    <tr>
                        <td>협력업체명:</td>
                        <td><input type="text" name="company_name" value="${projectDtl.company_name}" /></td>
                    </tr>
                    <tr>
                        <td>협력업체 대표명:</td>
                        <td><input type="text" name="company_ceo" value="${projectDtl.company_ceo}" /></td>
                    </tr>
                    <tr>
                        <td>시작일:</td>
                        <td><input type="date" name="start_date" value="${projectDtl.start_date}" /></td>
                    </tr>
                    <tr>
                        <td>종료일:</td>
                        <td><input type="date" name="end_date" value="${projectDtl.end_date}" /></td>
                    </tr>
                    <tr>
                        <td>프로젝트 내용:</td>
                        <td><textarea name="project_contents">${projectDtl.project_contents}</textarea></td>
                    </tr>
                    <tr>
                        <td>관리자 전화번호:</td>
                        <td><input type="text" name="manage_phone" value="${projectDtl.manage_phone}" /></td>
                    </tr>
                    <tr>
                        <td>관리 그룹:</td>
                        <td><input type="text" name="manage_group" value="${projectDtl.manage_group}" /></td>
                    </tr>
                    <tr>
                        <td>협력업체 전화번호:</td>
                        <td><input type="text" name="company_tel" value="${projectDtl.company_tel}" /></td>
                    </tr>
                   <c:forEach var="file" items="${file}">
					    <tr>
					        <td>
					            <a href="/downloadFile?filePath=${file.file_path}&fileName=${file.file_name}">
					                ${file.file_name}
					            </a>
					        </td>
					        <td>
					        </td>
					    </tr>
					</c:forEach>
					<tr>
					    <td><input type="button" value="파일 추가" onClick="fn_addFile()"></td>
					    <td id="d_file"></td>
					</tr>

                </table>
            </div>
            <div class="back-button">
                <button type="submit">프로젝트 업데이트</button>
                <button type="button" onclick="history.back()">취소</button>
            </div>
        </form>
        <select id="auto_write" name="auto_write">
        	<option value = "jungong">준공신고서</option>
        	<option value="soo">수의계약각서</option>
        </select>
        <button onclick="auto_write()">excel파일로 저장</button>
    </div>
    <script src = "http://code.jquery.com/jquery-latest.js"></script>
    <script type="text/javascript">
    var cnt = 1;
    function fn_addFile(){
        $("#d_file").append("<br>" + "<input type='file' name='file" + cnt + "' />");
        cnt++;
    }
    function auto_write() {
        var selectElement = document.getElementById('auto_write');
        var projectId = document.getElementsByName('project_id')[0].value;
        var selectedValue = selectElement.options[selectElement.selectedIndex].value;
        var form = document.createElement('form');
        form.method = 'POST';
        form.action = selectedValue + '.do';  // 서버에 따라 URL 패턴을 조정해야 할 수 있습니다.

        // 프로젝트 ID를 전송할 input 요소 생성
        var idInput = document.createElement('input');
        idInput.type = 'hidden';
        idInput.name = 'projectId';
        idInput.value = projectId;
        form.appendChild(idInput);

        // 전송할 form을 body에 추가 후 제출
        document.body.appendChild(form);
        form.submit();
    }
    </script>
</body>

</html>