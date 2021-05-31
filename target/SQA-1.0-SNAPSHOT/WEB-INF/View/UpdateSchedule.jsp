
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


<h3 style=" margin-top: 10px;text-align: center;padding-bottom: 5px">SỬA THÔNG TIN LỚP HỌC PHẦN</h3>

<h4 style="text-align: center;color: red"><%=request.getAttribute("update_success") != null ? request.getAttribute("update_sucess") : " "%></h4>

<div style=" margin-left:600px;margin-top: 30px;">
    <form action="updateclass" method="post">


        <input type="hidden" style="margin-bottom: 10px" name="id" value="${sc.id}">
        <br>

        <p>Tên lớp: </p>
        <input style="margin-bottom: 10px" type="text" name="tenlop" value="${sc.tenlop}">
        <br>
        <p>Tên môn học: </p>
        <input style="margin-bottom: 10px" type="text" name="tenmonhoc" value="${sc.tenmonhoc}">
        <br>

        <p>Số tín: </p>
        <input style="margin-bottom: 10px" type="text" name="sotin" value="${sc.sotin}">
        <br>

        <p>Số kíp: </p>
        <input style="margin-bottom: 10px" type="text" name="sokip" value="${sc.sokip}">
        <br>
        <p>Số tiết lý thuyết: </p>
        <input style="margin-bottom: 10px" type="text" name="lythuyet" value="${sc.sokiplythuyet}">
        <br>
        <p>Số tiết thực hành: </p>
        <input style="margin-bottom: 10px"  type="text" name="thuchanh" value="${sc.sokipthuchanh}">
        <br>
        <button href="" style="color: black; background-color: #357ebd; padding: 10px 15px 10px 15px;">Lưu</button>
    </form>
</div>

</body>
</html>
