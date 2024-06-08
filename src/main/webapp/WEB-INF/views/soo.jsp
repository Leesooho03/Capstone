<%@ page contentType="application/vnd.ms-excel" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.net.URLEncoder" %>
<%
String fileName = "수의계약각서.xlsx";
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
    .large-cell {
        min-height: 100px; /* 셀의 최소 높이 설정 */
        line-height: 1.5; /* 라인 높이 조절 */
        vertical-align: top; /* 텍스트를 상단 정렬 */
    }
</style>
</head>
<body>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <table>
        <thead class="header">
            <tr><th colspan="3">수의계약각서</th></tr>
        </thead>
        <tr>
            <td>업체명</td>
            <td colspan="2">${data.company_name}</td>
        </tr>
        <tr>
            <td>대표자</td>
            <td colspan="2">${data.company_ceo}</td>
        </tr>
        <tr>
            <td>소재지</td>
            <td colspan="2">${data.company_address}</td>
        </tr>
        <tr>
            <td>업종(등록)</td>
            <td colspan="2"></td>
        </tr>
        <tr>
            <td colspan="3" class="large-cell">상기 본인(법인)은 거래처와 수의계약을 체결함에 있어서 붙임 결격사유 중 어느 사유에도 해당되지 않으며 차후에 이러한 사실이 발견된 경우 계약의 해제․해지 및 부정당업자 제재 처분을 받아도 하등의 이유를 제기하지 않겠습니다.</td>
        </tr>
        <tr>
            <td colspan="3">붙임 : &lt;별표1&gt; 수의계약 결격사유 1부.</td>
        </tr>
        <tr>
            <td>업체명:</td>
            <td colspan="2">EW</td>
        </tr>
        <tr>
            <td>대표자:</td>
            <td colspan="2">신현민&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(인)</td>
        </tr>
        <tfoot class="footer">
            <tr>
                <td colspan="3">거래처 귀하</td>
            </tr>
        </tfoot>
    </table>
</body>
</html>
