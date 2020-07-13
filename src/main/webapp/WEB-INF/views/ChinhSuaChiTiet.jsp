
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous"> -->
<!--<link rel="stylesheet" type="text/css" href="../css/fontawesome-free-5.13.0-web/css/all.css">  -->
<link
	href="<c:url value="/resources/css/fontawesome-free-5.13.0-web/css/all.css"/>"
	rel='stylesheet' type='text/css' />
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel='stylesheet' type='text/css' />
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel='stylesheet' type='text/css' />
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link href="<c:url value="/resources/css/css.css"/>" rel='stylesheet'
	type='text/css' />
<title>Trang Chủ</title>
</head>

<body>
	<input type="hidden" value="${tk.tenTaiKhoan }" name="tenTaiKhoan">
	<c:set var="tentk" value="${tk.tenTaiKhoan }" scope="session"></c:set>
	<div class="container-fluid">
		<div class="topheader">
			<div class="row">
				<div class="col-md-4" id="navbar-header">
					<c:if test="${tentk==null}">
						<ul>
							<li><a href="dangnhap"><span>Đăng nhập</span></a></li>
							<li><a href="#"><span>Đăng ký</span></a></li>
						</ul>

					</c:if>
					<c:if test="${tentk!=null}">
						<ul>
							<li><a href="dangnhap"><span>Xin Chào
										${tk.tenTaiKhoan } </span></a></li>
							<li><a href="/WEBBANHANGEJB_WEB/DangNhap?action=dangxuat"><span>Đăng
										Xuất</span></a></li>
						</ul>
					</c:if>
				</div>
				<div class="col-md-8" id="navbar-header-right">
					<ul>
						<li><a href="dangnhap-admin"><span>Đăng nhập admin</span></a></li>
						<li><a href="#"><span>Đơn hàng</span></a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="header_menu">
			<div class="row">
				<div class="col-xl-3 col-lg-2 col-md-12 col-sm-12 col-xs-12">
					<div class="logo">
						<a href="#"
							style="display: block; line-height: 100px; height: 100px;"> <img
							src="./resources/img/logo.png">
						</a>
					</div>
				</div>


			</div>
		</div>
	</div>
	<div class="header_nav_main section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<div class="heade_menunav">
						<div class="wrap_main d-none d-lg-block d-xl-block">
							<div class="bg-header-nav">
								<div class="row">
									<div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
										<nav class="header-nav">
											<ul class="item_big">
												<li class="nav-item  active "><a class="a-img"
													href="trangchu" title="Trang chủ"> <span>Trang
															chủ</span>
												</a></li>
												<li class="nav-item "><a class="a-img" href="dsDonHang"
													title="Giới thiệu"> <span>QUẢN LÝ ĐƠN HÀNG</span>
												</a></li>
												<li class="nav-item "><a class="a-img" href="#"
													title="Sản phẩm"> <span>QUẢN LÝ SẢN PHẨM</span><i
														class="fa fa-angle-down"></i>
												</a>
													<ul class="item_small">
														<li><a href="dsSanPham_QuanLy" title="Áo Thun">DANH
																SACH SẢN PHẨM</a></li>
														<li><a href="themSanPham" title="Áo Thun">THÊM
																SẢN PHẨM</a></li>

													</ul>
										</nav>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container form-text">
		<div class="row">
			<div class="col-sm-12">
				<h1>Danh sách Sản Phẩm</h1>
			</div>
			<div class="col-sm-12">
				<table>
					<tr>
						<th>Mã Đơn Hàng</th>
						<th>Tên sản phẩm</th>
						<th>Đơn giá</th>
						<th>Số lượng</th>
						<th>Cập nhật</th>
					</tr>
					<c:forEach items="${listChiTiet }" var="c">
						<form method="POST" action="capnhatChiTiet">
							<tr>
								<td>${c.donHang.maDonHang }</td>
								<td>${c.sanPham.tenSanPham }</td>
								<td>${c.donGia } </td>
								<td><input class="form-control text-center" type="text" name="txtsoLuong" value="${c.soLuong }"></td>
								<td>
									<input type="hidden" name="maDonHang" value="${c.donHang.maDonHang}"/>
									<input type="hidden" name="maSanPham" value="${c.sanPham.maSanPham }"/>
									<input type="submit" value="Cập nhật">
								</td>
							</tr>
						</form>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
