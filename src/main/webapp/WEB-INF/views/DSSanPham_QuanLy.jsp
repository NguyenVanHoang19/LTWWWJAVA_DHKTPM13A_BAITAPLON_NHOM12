
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
	                        <li><a href="formdangki"><span>Đăng ký</span></a></li>
                    	</ul>
                	
                	</c:if>
                    <c:if test="${tentk!=null}">
                		<ul>
	                        <li><a href="dangnhap"><span>Xin Chào ${tk.tenTaiKhoan } </span></a></li>
	                        <li><a href="dangxuat"><span>Đăng Xuất</span></a></li>
                    	</ul>
                	</c:if>
                </div>

            </div>
        </div>
        <div class="header_menu">
            <div class="row">
                <div class="col-xl-3 col-lg-2 col-md-12 col-sm-12 col-xs-12">
                    <div class="logo">
                        <a href="#" style="display: block;line-height: 100px;height: 100px;">
                            <img  src="./resources/img/logo.png">
                        </a>
                    </div>
                </div>
                <div class="col-xl-7 col-lg-8 col-md-12">
                    <div class="header_service">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="wrp">
                                    <div class="font-awesome">
                                        <i class="fas fa-truck" style="line-height: 53px;"></i>
                                    </div>
                                </div>
                                <div class="text" id="text-vanchuyen">
                                    <p style="color: #66a182;font-size: 16px;">Miễn phí vận chuyển</p>
                                    <span style="font-size: 14px;">Với đơn hàng trị giá trên 
                                        <strong>1.000.000</strong>
                                    </span>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="wrp">
                                    <div class="font-awesome">
                                        <i class="fas fa-phone" style="line-height: 53px;"></i>
                                    </div>
                                </div>
                                <div class="text" id="text-vanchuyen">
                                    <p style="color: #66a182;font-size: 16px;">Đặt hàng nhanh</p>
                                    <span style="font-size: 14px;">Gọi ngay
                                        <strong>18006750</strong>
                                    </span>
                                </div>
                            </div>
                        </div>
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
												<li class="nav-item "><a class="a-img"
													href="dsDonHang" title="Giới thiệu"> <span>QUẢN
															LÝ ĐƠN HÀNG</span>
												</a></li>
												<li class="nav-item "><a class="a-img" href="#"
													title="Sản phẩm"> <span>QUẢN LÝ SẢN PHẨM</span><i
														class="fa fa-angle-down"></i>
												</a>
													<ul class="item_small">
														<li><a href="dsSanPham_QuanLy" title="Áo Thun">DANH SACH
																SẢN PHẨM</a></li>
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
						<th>Mã sản phẩm</th>
						<th>Tên sản phẩm</th>
						<th>Mô tả</th>
						<th>Ngày sản xuất</th>
						<th>Đơn vị tính</th>
						<th>Đơn giá</th>
						<th>Số lượng nhập</th>
						<th>Tên danh mục</th>
						<th>Tên nhà cung cấp</th>
						<th>EDIT</th>
						<th>DELETE</th>
						
					</tr>
			  		<c:forEach items="${listSanPham }" var="sp">
						<tr>
							<td>${sp.maSanPham }</td>
							<td>${sp.tenSanPham }</td>
							<td>${sp.moTa }</td>
							<td>${sp.ngaySanXuat }</td>
							<td>${sp.donViTinh }</td>
							<td>${sp.donGia }</td>
							<td>${sp.soLuongNhap }</td>
							<td>${sp.danhMuc.tenDanhMuc }</td>
							<td>${sp.nhaCungCap.tenNhaCungCap }</td>
							<td><a href="formSuaSanPham?txtidsua=${sp.maSanPham }">Edit</a></td>
							<td><a href="xoaSanPham?txtidxoa=${sp.maSanPham }">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</body>

</html>