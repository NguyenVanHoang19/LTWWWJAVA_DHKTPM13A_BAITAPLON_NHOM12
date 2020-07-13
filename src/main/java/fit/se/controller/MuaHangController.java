package fit.se.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.FormSubmitEvent.MethodType;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fit.se.cartbeans.GioHang;
import fit.se.cartbeans.Item;
import fit.se.model.ChiTietDonHang;
import fit.se.model.ChiTietDonHangID;
import fit.se.model.DanhMuc;
import fit.se.model.DonHang;
import fit.se.model.KhachHang;
import fit.se.model.NhaCungCap;
import fit.se.model.SanPham;
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
public class MuaHangController {
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
	@RequestMapping(value="/MuaHang")
	public String themVaoGioHang(@RequestParam("action") String action,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		if(action !=null && !action.equals("")) {
			if(action.equals("add")) {
				addItem(request, response);
				return "ChiTietDonHang";
			}
			else if(action.equals("update")) {
				updateSoLuong(request, response);
				return "ChiTietDonHang";
			}
			else if(action.equals("delete")) {
				deleteItem(request, response);
				return "ChiTietDonHang";
			}
			
		}
		return "ChiTietDonHang";
		
	}
	
	@RequestMapping(value="/thanhtoan",method= { RequestMethod.POST,RequestMethod.GET})
	public String thanhToan(@RequestParam("tenTaiKhoan") String tenTaiKhoan,Model model) throws IOException, ServletException{
		if(tenTaiKhoan.equalsIgnoreCase("")) {
			return "redirect:/dangnhap";
		}
		else {
			KhachHang khachHang = new KhachHang();
			//KhachHang khachHang = khachHangService.getKhachHangByTaiKhoan(tenTaiKhoan);
			model.addAttribute("kH", khachHang);
			return "thanhtoan";
		}
	}
	@RequestMapping("/xemthongtinsanpham")
	public String xemThongTinSanPham(HttpServletRequest request,HttpServletResponse response,Model sanPhamModel,Model soLuongDaBan,Model soLuongCon) {
		int maSanPhamIn = Integer.parseInt(request.getParameter("maSanPham"));
		SanPham sanPham = sanPhamService.getSanPhamByID(maSanPhamIn);
		sanPhamModel.addAttribute("sp", sanPham);
		soLuongDaBan.addAttribute("soLuongCon", soLuongConTrongKho(maSanPhamIn));
		soLuongCon.addAttribute("soLuongDaBan",soLuongSanPhamDaDat(maSanPhamIn));
		return "xemthongtinsanpham";
	}
	public int soLuongSanPhamDaDat(int maSanPham) {
		int soLuong = 0;
		List<SanPham> listSanPhamDaDat = new ArrayList<SanPham>();
		for(ChiTietDonHang chiTietDonHang :chiTietDonHangService.getAllChiTietDonHang()) {
			if(chiTietDonHang.getSanPham().getMaSanPham()==maSanPham) {
				soLuong += chiTietDonHang.getSoLuong();
			}
		}
		return soLuong;
	}
	public int soLuongConTrongKho(int maSanPham) {
		int soLuongCon = 0 ;
		soLuongCon =sanPhamService.getSanPhamByID(maSanPham).getSoLuongNhap() - soLuongSanPhamDaDat(maSanPham);
		return soLuongCon;
	}
	public void addItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id =Integer.valueOf(request.getParameter("maSanPham"));
		String tenSanPham = request.getParameter("tenSanPham");
		String urlHinhAnh = request.getParameter("urlHinh");
		float donGia = Float.valueOf(request.getParameter("donGia"));
		int soLuong = Integer.valueOf(request.getParameter("soLuong"));
		
	//	String tenSanPhamDecoded = URLDecoder.decode(tenSanPham, "UTF-8");
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
		int soLuongConTrongKho = 0 ;
		try {
			if(soLuongConTrongKho(id)!=0) {
				soLuongConTrongKho += soLuongConTrongKho(id);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		gioHang.ThemItem(new Item(id, tenSanPham, urlHinhAnh, donGia, soLuong,soLuongConTrongKho));
		
	}
	public void updateSoLuong(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id =Integer.valueOf(request.getParameter("id"));
		int soLuong =Integer.valueOf(request.getParameter("soLuong"));
		
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
		
		gioHang.updateItem(gioHang.getItemById(id),soLuong);
	}
	public void deleteItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id =Integer.valueOf(request.getParameter("id"));
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
		
		gioHang.deleteItem(gioHang.getItemById(id));
	}
	@RequestMapping(value="/xacnhanthanhtoan")
//	public String xacNhanThanhToan(@RequestParam("tenTaiKhoan") String tenTaiKhoan,@RequestParam("name") String tenKhachHang,@RequestParam("email") String email,@RequestParam("diaChi") String diaChi,@RequestParam("dienThoai") String soDienThoai,HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {
	public String xacNhanThanhToan(@Valid @ModelAttribute("kH") KhachHang khachHang,BindingResult theBindingResult ,@RequestParam("tenTaiKhoan") String tenTaiKhoan,HttpServletRequest request)throws IOException, ServletException {		
		if(theBindingResult.hasErrors()) {
			return "thanhtoan";
		}
		else {
		//	khach hang tim boi tai khoan da login
			KhachHang khachHangLogin = khachHangService.getKhachHangByTaiKhoan(tenTaiKhoan);
			// cập nhật lại khách hàng
			khachHang.setMaKhachHang(khachHangLogin.getMaKhachHang());
			khachHang.setNgaySinh(khachHangLogin.getNgaySinh());
			khachHang.setTrangThai(khachHangLogin.getTrangThai());
			khachHang.setSoCMND(khachHangLogin.getSoCMND());
			khachHang.setTaiKhoan(khachHangLogin.getTaiKhoan());
			khachHangService.updateKhachHang(khachHang);
			int maKhachHang = khachHang.getMaKhachHang();
			// them don hang
			DonHang donHang = new DonHang();
			donHang.setNgayLap(LocalDate.now());
			donHang.setKhachHang(khachHangService.getKhachHangById(maKhachHang));
			donHangService.addKDonHang(donHang);
			donHang.setMaDonHang(donHangService.getIdMax());
			// them chi tiet don hang
			HttpSession session = request.getSession();
			GioHang gioHang = null;
			Object objGioHang = session.getAttribute("cart");
			if(objGioHang!=null) {
				gioHang = (GioHang) objGioHang;
				for(Item item : gioHang.getGioHang()) {
					ChiTietDonHang chiTietDonHang = new ChiTietDonHang(new ChiTietDonHangID(donHangService.getIdMax(), sanPhamService.getSanPhamByID(item.getId()).getMaSanPham()),sanPhamService.getSanPhamByID(item.getId()) , donHang, item.getSoLuong(), item.getDonGia()*item.getSoLuong());
					chiTietDonHangService.addChiTietDonHang(chiTietDonHang);
				}
				session.removeAttribute("cart");
			}
			return "redirect:/trangchu";
		}
	}
}
