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
        <h2>협력업체 상세 정보</h2>
        <form id="CompanyForm" action="/updateCompany.do" method="post">
            <div class="table-container">
                <table>
	                <tr>
						<td><input type="hidden" name="company_id" value="${companyDtl.company_id}"></td>
                    </tr>
                    <tr>
                        <td>업체명:</td>
                        <td><input type="text" name="company_name" value="${companyDtl.company_name}" /></td>
                    </tr>
                    <tr>
                        <td>소재지:</td>
                        <td><input type="text" name="company_address" value="${companyDtl.company_address}" /></td>
                    </tr>
                    <tr>
                        <td>대표:</td>
                        <td><input type="text" name="company_ceo" value="${companyDtl.company_ceo}" /></td>
                    </tr>
                    <tr>
                        <td>회사 전화번호:</td>
                        <td><input type="text" name="company_tel" value="${companyDtl.company_tel}" /></td>
                    </tr>
                    <tr>
                        <td>회사 이메일:</td>
                        <td><input type="text" name="company_email" value="${companyDtl.company_email}" /></td>
                    </tr>
                </table>
            </div>
            <div class="back-button">
                <button type="submit">협력업체 업데이트</button>
                <button type="button" onclick="history.back()">취소</button>
            </div>
        </form>
    </div>
    <script src = "http://code.jquery.com/jquery-latest.js"></script>
</body>

</html>
