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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fit.se.model.TaiKhoan;
import fit.se.service.TaiKhoanService;

@Controller
public class DangNhapController {
	@Autowired(required=true)
	@Qualifier(value="taiKhoanService")
	private TaiKhoanService taiKhoanService;

	public void setTaiKhoanService(TaiKhoanService taiKhoanService) {
		this.taiKhoanService = taiKhoanService;
	}
	@RequestMapping(value="/dangxuat")
	public String dangXuat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("tk");
		session.removeAttribute("cart");
		return "redirect:/trangchu";
	}
	@RequestMapping(value="/dangnhap")
	public String dangNhap(Model model) throws ServletException, IOException {
		model.addAttribute("taiKhoan",new TaiKhoan() );
		return "dangnhap";
	}
	
	@RequestMapping(value="/xulydangnhap" ,method=RequestMethod.POST)
//	public String DangNhap(@ModelAttribute("taiKhoan") @Validated TaiKhoan taiKhoan,BindingResult theBindingResult,Model model,HttpServletRequest request)  {
	public String DangNhap(@Valid @ModelAttribute("taiKhoan")  TaiKhoan taiKhoan,BindingResult theBindingResult,Model model,HttpServletRequest request)  {	
		boolean check =false;
		if(theBindingResult.hasErrors()) {
			return "dangnhap";
		}
		else {
			for(TaiKhoan tk : taiKhoanService.getTaiKhoanByIDAndMK(taiKhoan.getTenTaiKhoan(), taiKhoan.getMatKhau())) {	
				check = true; 
				HttpSession session = request.getSession();
				session.setAttribute("tk",tk);
				return "redirect:/trangchu";
			}
			if( check==false && !taiKhoan.getTenTaiKhoan().equalsIgnoreCase("admin") && !taiKhoan.getMatKhau().equalsIgnoreCase("admin") ) {
				HttpSession session = request.getSession();
				session.setAttribute("thongBaoDangNhapLoi","true");
				return "dangnhap";
			}
			else if(check==false && (taiKhoan.getTenTaiKhoan().equalsIgnoreCase("admin") && taiKhoan.getMatKhau().equalsIgnoreCase("admin")) ) {
				return "admin";
			}
			return "redirect:/trangchu";

		}
	}
}
