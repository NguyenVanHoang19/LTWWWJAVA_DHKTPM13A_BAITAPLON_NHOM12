package fit.se.controller;


import java.io.IOException;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fit.se.model.KhachHang;
import fit.se.model.TaiKhoan;
import fit.se.service.ChiTietDonHangService;
import fit.se.service.DanhMucService;
import fit.se.service.DonHangService;
import fit.se.service.KhachHangService;
import fit.se.service.NguoiQuanLyService;
import fit.se.service.NhaCungCapService;
import fit.se.service.SanPhamService;
import fit.se.service.TaiKhoanService;
@Controller
public class DangKiController {
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


	@RequestMapping(value="/formdangki")
	public String formdangki(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "dangki";
	}
	@RequestMapping(value="/dangki")
	public String dangki(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dangkikh(request, response);
		return "redirect:/dangnhap";
	}
	@RequestMapping(value="/thongtincanhan")
	public String showThongTinCaNhan(Model model,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KhachHang khachHang = khachHangService.getKhachHangByTaiKhoan(request.getParameter("tenTaiKhoan"));
		model.addAttribute("kH", khachHang);
		return "thongtinkkh";
	}
	@RequestMapping(value="/thongtinkhh")
	public String updateTTKH(@Valid @ModelAttribute("kH") KhachHang khachHang,BindingResult theBindingResult,@RequestParam("tenTaiKhoan") String tenTaiKhoan,HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
		if(theBindingResult.hasErrors()) {
			return "thongtinkkh";
		}
		else {
			//khach hang tim boi tai khoan da login
			KhachHang khachHangLogin = khachHangService.getKhachHangByTaiKhoan(tenTaiKhoan);
			// cập nhật lại khách hàng
			khachHang.setMaKhachHang(khachHangLogin.getMaKhachHang());
			khachHang.setNgaySinh(khachHangLogin.getNgaySinh());
			khachHang.setTrangThai(khachHangLogin.getTrangThai());
			khachHang.setSoCMND(khachHangLogin.getSoCMND());
			khachHang.setTaiKhoan(khachHangLogin.getTaiKhoan());
			khachHangService.updateKhachHang(khachHang);
			return"redirect:/trangchu";	
			//
		}
		
		
	}
	public void dangkikh(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String tentk =request.getParameter("tentaikhoan");
		String tenkh = request.getParameter("tenkhachhhang");
		String emaill = request.getParameter("email");
		String sdt = request.getParameter("sdt");
		String matkhau= request.getParameter("password");
		TaiKhoan taikhoan=new TaiKhoan(tentk,matkhau);

		taiKhoanService.addTaiKhoan(taikhoan);
		KhachHang khachhang=new KhachHang();
		khachhang.setTenKhachHang(tenkh);
		khachhang.setEmail(emaill);
		khachhang.setSoDienThoai(sdt);
		khachhang.setTaiKhoan(taikhoan);
		khachHangService.addKhachHang(khachhang);

	}

}
