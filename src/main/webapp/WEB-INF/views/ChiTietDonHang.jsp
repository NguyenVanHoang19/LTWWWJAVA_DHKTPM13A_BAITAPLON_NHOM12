<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt"%>
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
<style type="text/css">
.table &amp;amp;gt;tbody&amp;amp;gt;tr&amp;amp;gt;td, .table
	&amp;amp;gt;tfoot&amp;amp;gt;tr&amp;amp;gt;td {
	vertical-align: middle;
}

@media screen and (max-width: 600px) {
	table#cart tbody td .form-control {
		width: 20%;
		display: inline !important;
	}
	.actions .btn {
		width: 36%;
		margin: 1.5em 0;
	}
	.actions .btn-info {
		float: left;
	}
	.actions .btn-danger {
		float: right;
	}
	table#cart thead {
		display: none;
	}
	table#cart tbody td {
		display: block;
		padding: .6rem;
		min-width: 320px;
	}
	table#cart tbody tr td:first-child {
		background: #333;
		color: #fff;
	}
	table#cart tbody td:before {
		content: attr(data-th);
		font-weight: bold;
		display: inline-block;
		width: 8rem;
	}
	table#cart tfoot td {
		display: block;
	}
	table#cart tfoot td .btn {
		display: block;
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
                    		<li><a href="<c:url value="/thongtincanhan?tenTaiKhoan=${tk.tenTaiKhoan }"/>"><span>Xem thông tin cá nhân</span></a></li>
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
				<div class="col-xl-2 col-lg-2 hidden-md hiden-sm hidden-xs"
					id="giohang">
					<div
						class="cart visible-xl visible-lg hidden-md hidden-sm hidden-xs">
						<a href="#" id="icon-cart"> <img src="./resources/img/icon-cart.png"
							style="padding-top: 12px;">
						</a>
						<div class="text-giohang">
							<a href="giohang" style="font-size: 16px; color: #66a182;">Giỏ hàng</a>
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
												<li class="nav-item  active "><a class="a-img" href="trangchu"
													title="Trang chủ"> <span>Trang chủ</span>
												</a></li>
												<li class="nav-item "><a class="a-img"
													href="gioithieu" title="Giới thiệu"> <span>Giới
															thiệu</span>
												</a></li>
												<li class="nav-item "><a class="a-img" href=""
													title="Sản phẩm"> <span>Sản phẩm</span><i
														class="fa fa-angle-down"></i>
												</a>
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
									<div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
										<div class="serachpc">
											<div class="searchform">
												<form action="timkiem" method="get"
													class="input-group search-bar" role="search">
													<input type="text" name="timkiem" value="" autocomplete="off"
														placeholder="Tìm kiếm..."
														class="input-group-field auto-search visible_index">
													<button type="submit"
														class="visible_index btn icon-fallback-text">
														<i class="fa fa-search"></i>
													</button>
												</form>
											</div>
										</div>

									</div>
								</div>
							</div>
						</div>
						<section class="main-cart-page main-container col1-layout">
							<div class="main container cartpcstyle">
								<div class="wrap_background_aside margin-bottom-40">
									<div class="header-cart">
										<h1 class="title_cart">
											<span>Giỏ hàng</span>
										</h1>
										<div class="container">
											<table id="cart" class="table table-hover table-condensed">
												<thead>
													<tr>
														<th style="width: 50%">Tên sản phẩm</th>
														<th style="width: 10%">Giá</th>
														<th style="width: 8%">Số lượng</th>
														<th style="width: 22%" class="text-center">Thành tiền</th>
														<th style="width: 10%"></th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${cart.getGioHang() }" var="sp">
														<form method="POST" action="MuaHang">
															<tr>
																<td data-th="Product">
																	<div class="row">
																		<div class="col-sm-2 hidden-xs">
																			<img
																				src="${sp.urlHinhAnh}"
																				alt="${sp.urlHinhAnh}" class="img-responsive" width="100">
																		</div>
																		<div class="col-sm-10">
																			<h4 class="nomargin">${sp.tenSanpham }</h4>
																			<c:if test="${sp.soLuongConTrongKho > 0}">
																				<p style="color: blue;">Số lượng ${sp.soLuongConTrongKho}</p>
																			</c:if>
																			<c:if test="${sp.soLuongConTrongKho == 0}">
																				<p style="color: red;">Số lượng ${sp.soLuongConTrongKho}</p>
																				<p style="color: red;">Hết Hàng</p>
																			</c:if>
																		</div>
																	</div>
																</td>
																<td data-th="Price">${sp.donGia}</td>
																<td data-th="Quantity"><input
																	class="form-control text-center" value="${sp.soLuong }" type="number" name="soLuong" min="1" max="300">
																	<c:if test="${sp.soLuong > sp.soLuongConTrongKho}">
																		<p style="color: red;">Không đủ SL</p>
																	</c:if>
																</td>
																<!-- 
																	<td data-th="Subtotal" class="text-center">${sp.soLuong*sp.donGia}</td>
																 -->
																<td data-th="Subtotal" class="text-center">
																		<fmt:setLocale value="vi_VN"/>
																		<fmt:formatNumber value="${sp.soLuong*sp.donGia}" type="currency"/>
																</td>
												
																<td class="actions" data-th="">
																	<input type="hidden" name="id" value="${sp.id}">
																	<button class="btn btn-info btn-sm" type="submit" name="action" value="update">
																		<i class="fa fa-edit"></i>
																	</button>
																	<button class="btn btn-danger btn-sm" type="submit" name="action" value="delete">
																		<i class="fa fa-remove"></i>
																	</button>
																</td>
															</tr>
														
														</form>
														
													</c:forEach>
													
												</tbody>
												<tfoot>
													<tr class="visible-xs">
														<td class="text-center"><strong>
																đ</strong></td>
													</tr>
													
													<tr>
														<td style="text-align: left;"><a href="trangchu"
															class="btn btn-warning"><i class="fa fa-angle-left"></i>
																Tiếp tục mua hàng</a></td>
														<td colspan="2" class="hidden-xs"></td>
														<td class="hidden-xs text-center"><strong>Tổng
																tiền 
															<fmt:setLocale value="vi_VN"/>
															<fmt:formatNumber value="${cart.TongTien() }" type="currency"/>
														</strong></td>														
														<c:if test="${cart.checkSoLuongCon() ==1 && cart.TongTien() >0}">
															<td><a href="<c:url value="/thanhtoan?action=thanhtoan&tenTaiKhoan=${tentk}"/>"
																class="btn btn-success btn-block">Thanh toán <i
																	class="fa fa-angle-right"></i></a></td>
														</c:if>
														<c:if test="${cart.checkSoLuongCon() == -1}">
															<td><a href="#"
																class="btn btn-danger btn-block">Thanh toán <i
																	class="fa fa-angle-right"></i></a></td>
															<p style="color: red;">Vui Lòng Kiểm Tra Lại Số Lượng Hợp Lệ Trước Khi Thanh Toán</p>
														</c:if>
														<c:if test="${cart.TongTien() == 0 }">
															<td><a href="#"
																class="btn btn-danger btn-block">Thanh toán <i
																	class="fa fa-angle-right"></i></a></td>
															<p style="color: red;">Vui Lòng Kiểm Tra Lại Số Lượng Hợp Lệ Trước Khi Thanh Toán</p>
														</c:if>
													</tr>
												</tfoot>
											</table>
										</div>


										
									</div>
								</div>

							</div>
						</section>


					</div>
				</div>
			</div>
</body>

</html>