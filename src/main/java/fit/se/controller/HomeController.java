package fit.se.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fit.se.cartbeans.GioHang;
import fit.se.model.SanPham;
import fit.se.service.ChiTietDonHangService;
import fit.se.service.DanhMucService;
import fit.se.service.DonHangService;
import fit.se.service.KhachHangService;
import fit.se.service.NguoiQuanLyService;
import fit.se.service.NhaCungCapService;
import fit.se.service.SanPhamService;
import fit.se.service.TaiKhoanService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired(required=true)
	@Qualifier(value="chiTietDonHangService")
	private ChiTietDonHangService chiTietDonHangService;
	@Autowired(required=true)
	@Qualifier(value="danhMucService")
	private DanhMucService danhMucService;
	@Autowired(required=true)
	@Qualifier(value="donHangService")
	private DonHangService donHangService;
	@Autowired(required=true)
	@Qualifier(value="khachHangService")
	private KhachHangService khachHangService;
	@Autowired(required=true)
	@Qualifier(value="nguoiQuanLyService")
	private NguoiQuanLyService nguoiQuanLyService;
	@Autowired(required=true)
	@Qualifier(value="nhaCungCapService")
	private NhaCungCapService nhaCungCapService;
	@Autowired(required=true)
	@Qualifier(value="sanPhamService")
	private SanPhamService sanPhamService;
	@Autowired(required=true)
	@Qualifier(value="taiKhoanService")
	private TaiKhoanService taiKhoanService;
	// setter
	public void setChiTietDonHangService(ChiTietDonHangService chiTietDonHangService) {
		this.chiTietDonHangService = chiTietDonHangService;
	}
	
	public void setDanhMucService(DanhMucService danhMucService) {
		this.danhMucService = danhMucService;
	}
	
	public void setDonHangService(DonHangService donHangService) {
		this.donHangService = donHangService;
	}
	
	public void setKhachHangService(KhachHangService khachHangService) {
		this.khachHangService = khachHangService;
	}
	
	public void setNguoiQuanLyService(NguoiQuanLyService nguoiQuanLyService) {
		this.nguoiQuanLyService = nguoiQuanLyService;
	}
	
	public void setNhaCungCapService(NhaCungCapService nhaCungCapService) {
		this.nhaCungCapService = nhaCungCapService;
	}
	
	public void setSanPhamService(SanPhamService sanPhamService) {
		this.sanPhamService = sanPhamService;
	}
	
	public void setTaiKhoanService(TaiKhoanService taiKhoanService) {
		this.taiKhoanService = taiKhoanService;
	}

	@RequestMapping(value = {"/trangchu","/","/tatcasanpham"}, method = RequestMethod.GET)
	public String trangChu(Model model,Model model2,HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		GioHang gioHang = null;
		Object objGioHang = session.getAttribute("cart");
		
		if(objGioHang!=null) {
			gioHang = (GioHang) objGioHang;
		}
		else {
			gioHang = new GioHang();
			session.setAttribute("cart", gioHang);
		}
			model.addAttribute("listSanPham",sanPhamService.getAllSanPham() );
			model2.addAttribute("listDanhMuc",danhMucService.getAllDanhMuc() );
			return "trangchu";
	}
	@RequestMapping(value = "/giohang")
	public String showGioHang(Model model) {
		return "ChiTietDonHang";
	}
	@RequestMapping(value = "/dangnhap",method = RequestMethod.POST)
	public String xacNhanDangNhap(@RequestParam("user") String user,@RequestParam("password") String password) {
		if(user.equals("admin")&&password.equals("admin")) {
			return "admin";
		}
		return "dangnhap";
	}	
	
	@RequestMapping(value = "/gioithieu")
	public String showFormGioithieu(Model model) {
		
		return "gioithieu";
	}
	
	
	@RequestMapping(value = "/tintuc")
	public String showTintuc(Model model) {
		
		return "tintuc";
	}
	
	
	
	@RequestMapping(value = "/lienhe")
	public String showLienhe(Model model) {
		
		return "lienhe";
	}
	@RequestMapping(value = "/timkiem")
	public String showFormTimKiem(HttpServletRequest request, HttpServletResponse response,Model model) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String tenSanPham=request.getParameter("timkiem");
	//	List<SanPham> list = sanPhamEJB_CRUDRemote.getSanPhamByten(tenSanPham);
		List<SanPham> list = sanPhamService.getSanPhamByten(tenSanPham);
		request.setAttribute("listSanPham", list);
		request.setAttribute("tukhoa", tenSanPham);
		return "ListKetQuaTimKiem";
	}
	@RequestMapping(value = "/aothun")
	public String showListAoThun(Model model,Model model2) {
		List<SanPham> list = sanPhamService.getSanPhamByDanhMucByTen("Áo Thun");
		model.addAttribute("listSanPham", list);
		model2.addAttribute("danhmuc", "Áo Thun");
		return "ListMenuSanPham";
	}
	@RequestMapping(value = "/aophong")
	public String showListAoPhong(Model model,Model model2) {
		List<SanPham> list = sanPhamService.getSanPhamByDanhMucByTen("Áo Phông Nam");
		model.addAttribute("listSanPham", list);
		model2.addAttribute("danhmuc", "Áo Phông Nam");
		return "ListMenuSanPham";
	}
	@RequestMapping(value = "/aosomi")
	public String showListAoSoMi(Model model,Model model2) {
		List<SanPham> list = sanPhamService.getSanPhamByDanhMucByTen("Áo Sơ Mi");
		model.addAttribute("listSanPham", list);
		model2.addAttribute("danhmuc", "Áo Sơ Mi");
		return "ListMenuSanPham";
	}
	@RequestMapping(value = "/aococtay")
	public String showListCocTay(Model model,Model model2) {
		List<SanPham> list = sanPhamService.getSanPhamByDanhMucByTen("Áo Cộc Tay");
		model.addAttribute("listSanPham", list);
		model2.addAttribute("danhmuc", "Áo Cộc Tay");
		return "ListMenuSanPham";
	}
	@RequestMapping(value = "/quanjean")
	public String showListQuanJean(Model model,Model model2) {
		List<SanPham> list = sanPhamService.getSanPhamByDanhMucByTen("Quần Jean Nam");
		model.addAttribute("listSanPham", list);
		model2.addAttribute("danhmuc", "Quần Jean Nam");
		return "ListMenuSanPham";
	}
}
