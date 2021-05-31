<%--
  Created by IntelliJ IDEA.
  User: vietmd329
  Date: 4/4/2021
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng ký lịch giảng</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #008080">

        <ul class="navbar-nav">
            <a  style="margin-left: 600px; color: white" href="BackHomeForward"
                class="nav-link">Quay lại</a>
        </ul>
    </nav>
</header>


<h3 style=" margin-top: 10px;text-align: center;padding-bottom: 5px">ĐĂNG KÝ LỚP HỌC PHẦN</h3>

<h4 style="text-align: center;color: red"><%=request.getAttribute("msg_addClass") != null ? request.getAttribute("msg_addClass") : " "%></h4>

<div style=" margin-left:600px;margin-top: 30px;">
    <form action="RegisterSubController" method="post">
        <p>Tên lớp: </p>
        <input style="margin-bottom: 10px" type="text" name="tenlop">
        <br>
        <p>Tên môn học: </p>
        <input style="margin-bottom: 10px" type="text" name="tenmonhoc">
        <br>

        <p>Số tín: </p>
        <input style="margin-bottom: 10px" type="text" name="sotin">
        <br>

        <p>Số kíp: </p>
        <input style="margin-bottom: 10px" type="text" name="sokip">
        <br>
        <p>Số tiết lý thuyết: </p>
        <input style="margin-bottom: 10px" type="text" name="lythuyet">
        <br>
        <p>Số tiết thực hành: </p>
        <input style="margin-bottom: 10px"  type="text" name="thuchanh">
        <br>
        <button href="" style="color: black; background-color: #357ebd; padding: 10px 15px 10px 15px;">Lưu</button>
    </form>
</div>

</body>
</html>
