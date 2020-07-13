package fit.se.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fit.se.model.ChiTietDonHang;
import fit.se.model.DanhMuc;
import fit.se.model.DonHang;
import fit.se.model.KhachHang;
import fit.se.model.NhaCungCap;
import fit.se.model.SanPham;
import fit.se.service.ChiTietDonHangService;
import fit.se.service.DanhMucService;
import fit.se.service.DonHangService;
import fit.se.service.KhachHangService;
import fit.se.service.NhaCungCapService;
import fit.se.service.SanPhamService;

@Controller 
public class QuanLyController {
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
	@Qualifier(value="nhaCungCapService")
	private NhaCungCapService nhaCungCapService;
	@Autowired(required=true)
	@Qualifier(value="sanPhamService")
	private SanPhamService sanPhamService;
	@Autowired(required=true)
	@Qualifier(value="khachHangService")
	private KhachHangService khachHangService;
	public void setChiTietDonHangService(ChiTietDonHangService chiTietDonHangService) {
		this.chiTietDonHangService = chiTietDonHangService;
	}
	public void setDanhMucService(DanhMucService danhMucService) {
		this.danhMucService = danhMucService;
	}
	public void setDonHangService(DonHangService donHangService) {
		this.donHangService = donHangService;
	}

	public void setNhaCungCapService(NhaCungCapService nhaCungCapService) {
		this.nhaCungCapService = nhaCungCapService;
	}
	public void setSanPhamService(SanPhamService sanPhamService) {
		this.sanPhamService = sanPhamService;
	}
	
	public void setKhachHangService(KhachHangService khachHangService) {
		this.khachHangService = khachHangService;
	}
	@RequestMapping("/admin")
	public String TrangQuanLy(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException, ServletException{
		return "admin";
	}
	@RequestMapping("/dsDonHang")
	public String dSDonHang(HttpServletRequest request) throws IOException, ServletException{
		HttpSession session = request.getSession();
		session.setAttribute("listDonHang", donHangService.getAllDonHang());
		return "dsDonHang";
	}

	@RequestMapping("/dsChiTiet")
	public String DSChiTiet(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException, ServletException{
		HttpSession session = request.getSession();
		String id= request.getParameter("txtidDH");
		session.setAttribute("listChiTiet", chiTietDonHangService.getAllChiTietDonHangbyDonHang(Integer.parseInt(id)));
		return "DSChiTietDH";
	}
	@RequestMapping("/dsSanPham_QuanLy")
	public String dsSanPham(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException, ServletException{
		HttpSession session = request.getSession();
		session.setAttribute("listSanPham", sanPhamService.getAllSanPhambyTrangThai());
		return "DSSanPham_QuanLy";
	}
	@RequestMapping("/xoaSanPham")
	public String xoaSanPham(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException, ServletException{
		HttpSession session = request.getSession();
		String id= request.getParameter("txtidxoa");
		sanPhamService.updateSanPhambyTrangThai(Integer.parseInt(id));
		session.setAttribute("listSanPham", sanPhamService.getAllSanPhambyTrangThai());
		return "DSSanPham_QuanLy";
	}
	@RequestMapping(value = "/formSuaSanPham", method = RequestMethod.GET)
	public String formSuaSanPham(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException, ServletException{
		HttpSession session = request.getSession();
		request.setAttribute("listDanhMuc", danhMucService.getAllDanhMuc());
		request.setAttribute("listNCC", nhaCungCapService.getAllNhaCungCap());
		String id= request.getParameter("txtidsua");
		session.setAttribute("suasp", sanPhamService.getSanPhamByID(Integer.parseInt(id)));
		System.out.println(sanPhamService.getSanPhamByID(Integer.parseInt(id)));
		return "FormUpdataSanPham";
	}
	@RequestMapping(value = "/formThemSanPham", method = RequestMethod.GET)
	public String formThemSanPham(HttpServletRequest request,Model model) throws IOException, ServletException{
		HttpSession session = request.getSession();
		request.setAttribute("listDanhMuc", danhMucService.getAllDanhMuc());
		request.setAttribute("listNCC", nhaCungCapService.getAllNhaCungCap());
		model.addAttribute("sanPhamThem", new SanPham());
		return "FormThemSanPham";
	}
	@RequestMapping(value = "/themSanPham", method = {RequestMethod.POST,RequestMethod.GET})
	public String themSanPham(HttpServletRequest request,HttpServletResponse response, @Valid @ModelAttribute("sanPhamThem") SanPham s, BindingResult result, Model model) throws IOException, ServletException{
		if(result.hasErrors()) {
//			HttpSession session = request.getSession();
			request.setAttribute("listDanhMuc", danhMucService.getAllDanhMuc());
			request.setAttribute("listNCC", nhaCungCapService.getAllNhaCungCap());
//			model.addAttribute("sanPhamThem", new SanPham());
			return "FormThemSanPham";
		}
		else {
			String ngay=request.getParameter("txtngay");
			String tenDanhMuc=request.getParameter("txtDanhMuc");
			String tenNhaCungCap=request.getParameter("txtNhaCungCap");
			String anh=request.getParameter("fileanh");
			DanhMuc dm= danhMucService.getDanhMucbyTen(tenDanhMuc);
			NhaCungCap n=nhaCungCapService.getNhaCungCapbyTen(tenNhaCungCap);
			LocalDate d=LocalDate.parse(ngay);
			s.setTrangThai("true");
			s.setNgaySanXuat(d);
			s.setDanhMuc(dm);
			s.setNhaCungCap(n);
			s.setUrlHinh(anh);
			sanPhamService.addSanPham(s);
			return "redirect:/";
		}
	}
	@RequestMapping(value = "/suaSanPham")
	public String suaSanPham(HttpServletRequest request,HttpServletResponse response,Model model) throws IOException, ServletException{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String maSanPham=request.getParameter("txtmasua");
		String tenSanPham= request.getParameter("txttensua");
		String mota= request.getParameter("txtmotasua");
		String donViTinh= request.getParameter("txtdvtsua");
		String soluong= request.getParameter("txtslsua");
		String dg= request.getParameter("txtgiasua");
		float donGia=Float.parseFloat(dg);
		String ngaysanxuat= request.getParameter("txtngaysua");
		LocalDate ngay=LocalDate.parse(ngaysanxuat);

		String tenDanhMuc=request.getParameter("txtDanhMucsua");
		String tenNhaCungCap=request.getParameter("txtNhaCungCapsua");
		DanhMuc dm= danhMucService.getDanhMucbyTen(tenDanhMuc);
		NhaCungCap n=nhaCungCapService.getNhaCungCapbyTen(tenNhaCungCap);

		SanPham s= sanPhamService.getSanPhamByID(Integer.parseInt(maSanPham));
		s.setDanhMuc(dm);
		s.setDonGia(donGia);
		s.setDonViTinh(donViTinh);
		s.setMoTa(mota);
		s.setNgaySanXuat(ngay);
		s.setNhaCungCap(n);
		s.setSoLuongNhap(Integer.parseInt(soluong));
		s.setTenSanPham(tenSanPham);

		sanPhamService.updateSanPham(s);

		HttpSession session = request.getSession();
		session.setAttribute("listSanPham", sanPhamService.getAllSanPhambyTrangThai());
		return "DSSanPham_QuanLy";
	}
	@RequestMapping(value = "/capnhatChiTiet", method = RequestMethod.POST)
	public String capNhatChiTiet(HttpServletRequest request) throws IOException, ServletException{
		String maSanPham= request.getParameter("maSanPham").trim();
		String maDonHang=request.getParameter("maDonHang").trim();
		String sl= request.getParameter("txtsoLuong").trim();
		int soLuong= Integer.parseInt(sl);
		
//		System.out.println("=================================================================================================");
//		System.out.println("số lượng:"+sl);
//		System.out.println(maDonHang);
//		System.out.println(maSanPham);
		ChiTietDonHang ct= chiTietDonHangService.getChiTietbyDHSP(Integer.parseUnsignedInt(maDonHang), Integer.parseInt(maSanPham));
		ct.setSoLuong(soLuong);
		
		chiTietDonHangService.updateChiTietDonHang(ct);
		
		HttpSession session = request.getSession();
		session.setAttribute("listChiTiet", chiTietDonHangService.getAllChiTietDonHangbyDonHang(Integer.parseInt(maDonHang)));
		return "admin";
	}
	@RequestMapping(value = "/giaoDienSuaChiTiet", method = RequestMethod.GET)
	public String giaoDienSuaChiTiet(HttpServletRequest request,Model model) throws IOException, ServletException{
		HttpSession session = request.getSession();
		String id= request.getParameter("maDonHangChinh");
		session.setAttribute("listChiTiet", chiTietDonHangService.getAllChiTietDonHangbyDonHang(Integer.parseInt(id)));
		return "ChinhSuaChiTiet";
	}
	@RequestMapping(value = {"/dsDonHangKhachHang"})
	public String dsDonHangKhachHang(HttpServletRequest request) throws IOException, ServletException{
		HttpSession session = request.getSession();
		KhachHang khachHang = khachHangService.getKhachHangByTaiKhoan(request.getParameter("tenTaiKhoan"));
		if(donHangService.getAllDonHangbyMaKhachHang(khachHang.getMaKhachHang()).isEmpty()) {
			return "XemDSDonHang_KhachHang";
		}
		
		session.setAttribute("listDonHangKhachHang", donHangService.getAllDonHangbyMaKhachHang(khachHang.getMaKhachHang()));
		return "XemDSDonHang_KhachHang";
	}
	@RequestMapping(value = "/xemChiTietDonHangKhachHang", method = RequestMethod.GET)
	public String xemChiTietDonHangKhachHang(HttpServletRequest request) throws IOException, ServletException{
		HttpSession session = request.getSession();
		String maDonHang=request.getParameter("maDonHangKH");
		session.setAttribute("listChiTietKhachHang", chiTietDonHangService.getAllChiTietDonHangbyDonHang(Integer.parseInt(maDonHang)));
		return "XemDSChiTiet_KhachHang";
	}
	
	
	





}
