<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous"> -->
<!--<link rel="stylesheet" type="text/css" href="../css/fontawesome-free-5.13.0-web/css/all.css">  -->
 <link href="<c:url value="/resources/css/fontawesome-free-5.13.0-web/css/all.css"/>" rel='stylesheet' type='text/css'/>

 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel='stylesheet' type='text/css'/>
 <link href="<c:url value="/resources/css/bootstrap.css"/>" rel='stylesheet' type='text/css'/>
 <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>

 <link href="<c:url value="/resources/css/css.css"/>" rel='stylesheet' type='text/css'/>
<title>Shop Đồ Nam Nữ</title>
</head>
<style>
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container_thanhtoan {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

.input_thanhtoan {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>
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
	                        <li><a href="dangnhap"><span>Xin Chào ${tk.tenTaiKhoan } </span></a></li>
	                        <li><a href="dangxuat"><span>Đăng Xuất</span></a></li>
                    	</ul>
                	</c:if>
                </div>
                <div class="col-md-8" id="navbar-header-right">
                    <ul>
                        <c:if test="${tentk!=null}">
                    		<li><a href="thongtincanhan"><span>Xem thông tin cá nhân</span></a></li>
                    		<li><a href="<c:url value="/dsDonHangKhachHang?tenTaiKhoan=${tk.tenTaiKhoan }"/>"><span>Đơn hàng</span></a></li>
                    	</c:if>
                    </ul>
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
                <div class="col-xl-2 col-lg-2 hidden-md hiden-sm hidden-xs" id="giohang">
                    <div class="cart visible-xl visible-lg hidden-md hidden-sm hidden-xs">
                        <a href="#" id="icon-cart">
                            <img src="./resources/img/icon-cart.png" style="padding-top: 12px;">
                        </a>
                        <div class="text-giohang">
                            <a href="giohang" style="font-size: 16px;color: #66a182;">Giỏ hàng</a>
                            <p style="margin: 0 0 15px 0;">
                                (<span style="color: red;">${cart.soLuongItiem() }</span>) Sản phẩm
                            </p>
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
                                                <li class="nav-item  active ">
                                                    <a class="a-img" href="trangchu" title="Trang chủ">
                                                        <span>Trang chủ</span> </a>
                                                </li>
                                                <li class="nav-item ">
                                                    <a class="a-img" href="gioithieu" title="Giới thiệu">
                                                        <span>Giới thiệu</span> </a>
                                                </li>
                                                <li class="nav-item ">
                                                    <a class="a-img" href="" title="Sản phẩm">
                                                        <span>Sản phẩm</span><i class="fa fa-angle-down"></i> </a>
                                                    <ul class="item_small">
                                                        <li>
                                                            <a href="aothun" title="Áo Thun">Áo Thun</a>

                                                        </li>
                                                        <li>
                                                            <a href="aophong" title="Áo phông">Áo phông</a>

                                                        </li>
                                                        <li>
                                                            <a href="aosomi" title="Áo sơ mi">Áo sơ mi</a>

                                                        </li>
                                                        <li>
                                                            <a href="aococtay" title="Áo cộc tay">Áo cộc tay</a>
                                                        </li>
                                                        <li>
                                                            <a href="quanjean" title="Áo cộc tay">Quần Jean Nam</a>
                                                        </li>
                                                        <li>
                                                            <a href="tatcasanpham" title="Áo cộc tay">Tất cả sản phẩm</a>
                                                        </li>
                                                        <li>
                                                            <!-- <a href="/san-pham-moi" title="Sản phẩm mới">Sản phẩm mới<i class="fa fa-angle-right"></i></a>
                                                            <ul>
                                                                <li>
                                                                    <a href="/san-pham-moi" title="Hàng mới" class="a3">Hàng mới</a>
                                                                </li>
                                                                <li>
                                                                    <a href="/san-pham-khuyen-mai" title="Hàng giảm giá" class="a3">Hàng giảm giá</a>
                                                                </li>
                                                            </ul>
                                                        </li>
                                                        <li>
                                                            <a href="/san-pham-noi-bat" title="Sản phẩm nổi bật">Sản phẩm nổi bật</a>
                                                        </li>
                                                        <li>
                                                            <a href="/san-pham-ban-chay" title="Sản phẩm bán chạy">Sản phẩm bán chạy</a>
                                                        </li>
                                                        <li>
                                                            <a href="/san-pham-khuyen-mai" title="Sản phẩm khuyến mãi">Sản phẩm khuyến mãi</a>
                                                        </li> -->
                                                    </ul>
                                                    </li>
                                                    <li class="nav-item ">
                                                        <a class="a-img" href="tintuc" title="Tin tức">
                                                            <span>Tin tức</span> </a>
                                                    </li>
                                                    <li class="nav-item ">
                                                        <a class="a-img" href="lienhe" title="Liên hệ">
                                                            <span>Liên hệ</span> </a>
                                                    </li>
                                            </ul>
                                        </nav>
                                    </div>
						<!--  -->

						<!--  -->
					</div>
				</div>
			</div>
			<h2>Thông tin của bạn</h2>
		
			<div class="row">
				<div class="col-75">
					<div class="container_thanhtoan">
						<form:form action="thongtinkhh" method="POST" modelAttribute="kH">
							<div class="row">
								<div class="col-50">
									<h3>Thông tin cá nhân</h3>
									<label for="fname"><i class="fa fa-user"></i> Họ và
										tên:</label> <form:input path="tenKhachHang" class="input_thanhtoan" type="text" 
										placeholder="Nguyễn Văn Hoàng" title="Tên Không Được Nhập Số Hoặc Kí Tự Đặt Biệt" />
										<form:errors path="tenKhachHang" cssClass="error" style="color:red;"></form:errors> 
										<label
										for="email"><i class="fa fa-envelope"></i> Email</label> <form:input path="email" class="input_thanhtoan"
										type="text" 
										placeholder="nguyenvanhoang34iuh@gmai.com"   />
										<form:errors path="email" cssClass="error" style="color:red;"></form:errors>
									<label for="adr"><i class="fa fa-address-card-o"></i>
										Địa chỉ nhận hàng:</label> <form:input path="diaChi" class="input_thanhtoan" type="text"  title="Địa Chỉ Không Được Nhập Kí Tự Đặt Biệt" 
										placeholder="14 Lê Văn Bảo, Gò Vấp"  />
										<form:errors path="diaChi" cssClass="error" style="color:red;"></form:errors>
									<div class="row">
										<div class="col-50">
											<label for="soDienThoai">Số điện thoai: </label> <form:input path="soDienThoai" class="input_thanhtoan"
												type="text" title="Số điện thoại có 10 số" 
												placeholder="0898136956"  />
											<form:errors path="soDienThoai" cssClass="error" style="color:red;"></form:errors>
										</div>
									</div>
								</div>
							</div>
							<input type="hidden" name="tenTaiKhoan" value="${tk.tenTaiKhoan }"> 
							<button type="submit" value="Xác Nhận Thanh Toán" class="btn">Lưu thông tin</button>
						</form:form>
						<script>
					        function thongbao(){
					            confirm("Lưu thông tin thành công");
					        }
					    </script>
					</div>
				</div>
				
</body>

</html>