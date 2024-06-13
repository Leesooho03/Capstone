<%@ page contentType="application/vnd.ms-excel" pageEncoding="UTF-8"%> %>
<%@ page import="java.util.*" %>
<%@ page import="java.net.URLEncoder" %>

<%
String fileName = "준공신고서.xlsx";
String encodedFileName = URLEncoder.encode(fileName, "UTF-8").replace("+", " ");
response.setHeader("Content-Disposition", "attachment; filename*=UTF-8''" + encodedFileName);
%>
<html>
<head>
<style>
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid black;
        padding: 8px;
        text-align: center;
    }
    th {
        background-color: #f2f2f2;
    }
    .header {
        background-color: #ddd;
        font-weight: bold;
        text-align: center;
    }
    .footer {
        font-style: italic;
        text-align: right;
    }
    td {
    white-space: pre;
	}
    
</style>
</head>
<body>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <table>
           <thead class="header">
            <tr><th colspan="3">준공신고서</th></tr>
        <tr>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        <tr>
            <td>1.</td>
            <td>건명 : </td>
            <td>${data.project_name}</td>
        </tr>
        <tr>
            <td>2.</td>
            <td>계약금액 :&nbsp;&nbsp;&nbsp; </td>
            <td><pre>금 ${data.project_cost} 원 (금 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;원)</pre></td>
        </tr>
        <tr>
            <td>3.</td>
            <td>준공금액 : </td>
            <td><pre>금 ${data.project_cost} 원 (금 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;원)</pre></td>
        </tr>
        <tr>
            <td>4.</td>
            <td>계약일자 : </td>
            <td></td>
        </tr>
        <tr>
            <td>5.</td>
            <td>착공일자 : </td>
            <td>${data.start_date}</td>
        </tr>
        <tr>
            <td>6.</td>
            <td>준공기한 : </td>
            <td>${data.end_date}</td>
        </tr>
        <tr>
            <td>7.</td>
            <td>준공일자 : </td>
            <td></td>
        </tr>
        <tr>
        	<td colspan="3">위와 같이 준공되었기에 준공신고서를 제출합니다.</td>
        </tr>
        <tr>
        	<td></td>
        	<td></td>
        	<td>202&nbsp;&nbsp;&nbsp;.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;.</td>
        </tr>
		<tr>
			<td>계약자</td>
			<td>주소 : </td>
			<td>경기도 안산시 상록구 한양대학로 55</td>
		</tr>
		<tr>
			<td></td>
			<td>상호 : </td>
			<td>EW</td>
		</tr>
		<tr>
			<td></td>
			<td>대표자 : </td>
			<td>신현민	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(인)</td>
		</tr>
		<tr>
			<td></td>
			<td colspan="2">현장감독담당경유</td>
		</tr>
		<tr>
			<td></td>
			<td>소속</td>
			<td>${data.company_name}</td>
		</tr>
		<tr>
			<td></td>
			<td>직급</td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td>성명</td>
			<td></td>
		</tr>
	 <tfoot class="footer">
            <tr>
                <td colspan="3">거래처 귀하</td>
            </tr>
        </tfoot>
    </table>
</body>
</html>
