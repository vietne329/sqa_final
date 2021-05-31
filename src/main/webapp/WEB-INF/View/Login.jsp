<%--
  Created by IntelliJ IDEA.
  User: vietmd329
  Date: 4/4/2021
  Time: 12:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Login</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/Template/Frontend/images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Template/Frontend/vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Template/Frontend/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Template/Frontend/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Template/Frontend/vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Template/Frontend/vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Template/Frontend/vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Template/Frontend/vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Template/Frontend/vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Template/Frontend/css/util.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Template/Frontend/css/main.css">
</head>
<body>
<div class="limiter">
    <div class="container-login100">
        <div class="wrap-login100 p-t-50 p-b-90">
            <form  name="myform" class="login100-form validate-form flex-sb flex-w" action="LoginController" method="post">
					<span class="login100-form-title p-b-51">
						Đăng nhập
					</span>

                <h4 style="color: red; margin-bottom: 10px" name="saitentk"><%=request.getAttribute("message") != null ? request.getAttribute("message") : " "%></h4>

                <div class="wrap-input100 validate-input m-b-16" name="notk"  data-validate = "Hãy nhập tên tài khoản!">
                    <input class="input100" type="text" name="username" placeholder="Tên tài khoản" onkeyup="Validate()">

                    <span class="focus-input100"></span>
                </div>
                <p style="color: red" id="errorname"></p>

                <div class="wrap-input100 validate-input m-b-16" name = "nomk" data-validate = "Hãy nhập mật khẩu!">
                    <input class="input100" type="password" name="password" placeholder="Password" onkeyup="Validate()">

                    <span class="focus-input100"></span>
                </div>
                <p id="errorpass"style="color: red"></p>
                <div class="flex-sb-m w-full p-t-3 p-b-24">
                    <div class="contact100-form-checkbox" name="cbx">
                        <input class="input-checkbox100" id="ckb1" type="checkbox" name="remember-me">
                        <label class="label-checkbox100" for="ckb1" name =>
                            Nhớ tài khoản
                        </label>
                    </div>

                    <div>
                        <a href="#" class="txt1">
                            Quên mật khẩu?
                        </a>
                    </div>
                </div>

                <div class="container-login100-form-btn m-t-17">
                    <button  class="login100-form-btn" name="submit">
                        Đăng nhập
                    </button>
                </div>

            </form>
        </div>
    </div>
</div>


<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/Template/Frontend/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/Template/Frontend/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/Template/Frontend/vendor/bootstrap/js/popper.js"></script>
<script src="${pageContext.request.contextPath}/Template/Frontend/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/Template/Frontend/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/Template/Frontend/vendor/daterangepicker/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/Template/Frontend/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/Template/Frontend/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="${pageContext.request.contextPath}/Template/Frontend/js/main.js"></script>

</body>
</html>
