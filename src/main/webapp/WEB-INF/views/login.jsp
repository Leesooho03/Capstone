<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Modernize Free</title>
  <link rel="shortcut icon" type="image/png" href="../assets/images/logos/logo.png" />
  <link rel="stylesheet" href="/assets/css/styles.min.css" />
</head>

<body>
  <!--  Body Wrapper -->
  <div class="page-wrapper" id="main-wrapper" data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full"
    data-sidebar-position="fixed" data-header-position="fixed">
    <div
      class="position-relative overflow-hidden radial-gradient min-vh-100 d-flex align-items-center justify-content-center">
      <div class="d-flex align-items-center justify-content-center w-100">
        <div class="row justify-content-center w-100">
          <div class="col-md-8 col-lg-6 col-xxl-3">
            <div class="card mb-0">
              <div class="card-body">
                <a href="/" class="text-nowrap logo-img text-center d-block py-3 w-100">
                  <img src="/assets/images/logos/logo.png" width="180" alt="">
                </a>
                <p class="text-center">Your Work Management Program</p>
                <form name="login_form" method="post" onsubmit="return true" action="">
                  <div class="mb-3">
                    <label for="id" class="form-label">아이디</label>
                    <input type="text" class="form-control" id="id" name="user_id" aria-describedby="emailHelp">
                  </div>
                  <div class="mb-4">
                    <label for="pw" class="form-label">비밀번호</label>
                    <input type="password" class="form-control" id="pw" name="user_pw">
                  </div>
                  <div class="d-flex align-items-center justify-content-between mb-4">
                    <div class="form-check">
                      <input class="form-check-input primary" type="checkbox" value="" id="flexCheckChecked" checked>
                      <label class="form-check-label text-dark" for="flexCheckChecked">
                        이 기기 기억하기
                      </label>
                    </div>
                  </div>
                  <c:if test="${not empty error}">
				    <div class="alert alert-danger" role="alert">
				        ${error}
				    </div>
				</c:if>
                  <a onclick="logIn()" class="btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2">로그인</a>
                  <div class="d-flex align-items-center justify-content-center">
                    <p class="fs-4 mb-0 fw-bold">처음이신가요?</p>
                    <a class="text-primary fw-bold ms-2" href="/register.do">계정 만들기</a>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script type="text/javascript">
  function logIn() {
	  var form = document.querySelector('form[name="login_form"]');
	  var user_id = document.querySelector('input[name="user_id"]').value;
	  var user_pw = document.querySelector('input[name="user_pw"]').value;
	  form.action="/login.do";

	  form.submit();
}
  </script>
  <script src="/assets/libs/jquery/dist/jquery.min.js"></script>
  <script src="/assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
