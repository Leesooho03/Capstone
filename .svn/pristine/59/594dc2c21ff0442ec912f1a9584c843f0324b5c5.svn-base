<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Modernize Free</title>
  <link rel="shortcut icon" type="image/png" href="/assets/images/logos/logo.png" />
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
                <form name="regForm" method="post" onsubmit="return true" action="">
                  <div class="mb-3">
                    <label for="name" class="form-label">이름</label>
                    <input type="text" class="form-control" id="name" name="user_name" aria-describedby="textHelp">
                  </div>
                  <div class="mb-3">
                    <label for="id" class="form-label">아이디</label>
                    <input type="text" class="form-control" id="id" name="user_id" aria-describedby="textHelp">
                  </div>
                  <div class="mb-3">
                    <label for="email" class="form-label">직급</label>
                    <input type="text" class="form-control" id="rank" name="user_rank" aria-describedby="emailHelp">
                  </div>
                  <div class="mb-4">
                    <label for="password" class="form-label">비밀번호</label>
                    <input type="password" class="form-control" id="password" name="user_pw">
                  </div>
                  <button onclick="reg()" class="btn btn-primary w-100 py-8 fs-4 mb-4 rounded-2">Sign Up</button> 
                  <div class="d-flex align-items-center justify-content-center">
                    <p class="fs-4 mb-0 fw-bold">이미 계정이 있습니까?</p>
                    <a class="text-primary fw-bold ms-2" href="/login.do">로그인</a>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="/assets/libs/jquery/dist/jquery.min.js"></script>
  <script src="/assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <script type="text/javascript">
  function reg() {
	  var form = document.querySelector('form[name="regForm"]');
	  var user_id = document.querySelector('input[name="user_id"]').value;
	  var user_name = document.querySelector('input[name="user_name"]').value;
	  var user_rank = document.querySelector('input[name="user_rank"]').value;
	  var user_pw = document.querySelector('input[name="user_pw"]').value;
	  form.action="/reg.do";

	  form.submit();
}
  </script>
</body>

</html>