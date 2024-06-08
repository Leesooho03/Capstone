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
        <%@include file = "sidebar.jsp" %>

    <!--  Main wrapper -->
    <div class="body-wrapper">
          <%@include file = "header.jsp" %>

      <div class="container-fluid" style="padding-top: 0;">
		<div class="container-fluid">
		    <iframe src="/cal_1.do" width="100%" height="750px" frameborder="0"></iframe>
<!-- 		    <iframe src="/calendar.do" width="100%" height="750px" frameborder="0"></iframe> -->
		</div>
      </div>
    </div>
  </div>
  <script src="/assets/libs/jquery/dist/jquery.min.js"></script>
  <script src="/assets/libs/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <script src="/assets/js/sidebarmenu.js"></script>
  <script src="/assets/js/app.min.js"></script>
  <script src="/assets/libs/simplebar/dist/simplebar.js"></script>
</body>

</html>