package fit.se.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="SanPham")
public class SanPham implements Serializable{
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer maSanPham;
	@Column(columnDefinition="nvarchar(255)")
	@NotNull(message = "Tên sản phẩm không được để rỗng")
	@Length(min = 2, max = 20, message = "Tên sản phẩm từ 2 đến 20 kí tự")
	private String tenSanPham;
	private LocalDate ngaySanXuat;
	@Column(columnDefinition="nvarchar(255)")
	@NotNull(message = "Đơn vị tính không được bỏ trống")
	private String donViTinh;
	@Column(columnDefinition="nvarchar(255)")
	@NotNull(message = "Mô tả không được để rỗng")
	@Length(min = 2, max = 50,message = "Tên sản phẩm từ 2 đến 50 kí tự")
	private String moTa;
	private float donGia;
	private int soLuongNhap;
	private String urlHinh;
	private String trangThai;
	@ManyToOne
	@JoinColumn(name="MANHACUNGCAP")
	private NhaCungCap nhaCungCap;
	@ManyToOne
	@JoinColumn(name="MADANHMUC")
	private DanhMuc danhMuc;
	public Integer getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(Integer maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}
	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}
	public String getUrlHinh() {
		return urlHinh;
	}
	public void setUrlHinh(String urlHinh) {
		this.urlHinh = urlHinh;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	public DanhMuc getDanhMuc() {
		return danhMuc;
	}
	public void setDanhMuc(DanhMuc danhMuc) {
		this.danhMuc = danhMuc;
	}
	
	public int getSoLuongNhap() {
		return soLuongNhap;
	}
	public void setSoLuongNhap(int soLuongNhap) {
		this.soLuongNhap = soLuongNhap;
	}
	
	public SanPham(Integer maSanPham, String tenSanPham, LocalDate ngaySanXuat, String donViTinh, String moTa,
			float donGia, int soLuongNhap, String urlHinh, String trangThai, NhaCungCap nhaCungCap, DanhMuc danhMuc) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.ngaySanXuat = ngaySanXuat;
		this.donViTinh = donViTinh;
		this.moTa = moTa;
		this.donGia = donGia;
		this.soLuongNhap = soLuongNhap;
		this.urlHinh = urlHinh;
		this.trangThai = trangThai;
		this.nhaCungCap = nhaCungCap;
		this.danhMuc = danhMuc;
	}
	
	public SanPham(String tenSanPham, LocalDate ngaySanXuat, String donViTinh, String moTa, float donGia,
			int soLuongNhap, String urlHinh, String trangThai, NhaCungCap nhaCungCap, DanhMuc danhMuc) {
		super();
		this.tenSanPham = tenSanPham;
		this.ngaySanXuat = ngaySanXuat;
		this.donViTinh = donViTinh;
		this.moTa = moTa;
		this.donGia = donGia;
		this.soLuongNhap = soLuongNhap;
		this.urlHinh = urlHinh;
		this.trangThai = trangThai;
		this.nhaCungCap = nhaCungCap;
		this.danhMuc = danhMuc;
	}
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSanPham == null) ? 0 : maSanPham.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		if (maSanPham == null) {
			if (other.maSanPham != null)
				return false;
		} else if (!maSanPham.equals(other.maSanPham))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", ngaySanXuat=" + ngaySanXuat
				+ ", donViTinh=" + donViTinh + ", moTa=" + moTa + ", donGia=" + donGia + ", soLuongNhap=" + soLuongNhap
				+ ", urlHinh=" + urlHinh + ", trangThai=" + trangThai + ", nhaCungCap=" + nhaCungCap + ", danhMuc="
				+ danhMuc + "]";
	}
	
	
	
	
	
	
}
