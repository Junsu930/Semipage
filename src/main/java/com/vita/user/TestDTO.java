package com.vita.user;

public class TestDTO {
	
	//제품번호, 카테고리번호, 제품명, 제품가격, 재고, 등록일, 판매수, 제품설명
	private int productNo;
	private String categoryNo;
	private String productName;
	private int price;
	private int stock;
	private String productDate;
	private int hit;
	private String productDetail;
	
	public TestDTO(int productNo, String categoryNo, String productName, int price, int stock, String productDate,
			int hit, String productDetail) {
		super();
		this.productNo = productNo;
		this.categoryNo = categoryNo;
		this.productName = productName;
		this.price = price;
		this.stock = stock;
		this.productDate = productDate;
		this.hit = hit;
		this.productDetail = productDetail;
	}
	
	public TestDTO(String productName, int price, String productDetail) {
		this.productName = productName;
		this.price = price;
		this.productDetail = productDetail;
	}
	
	public TestDTO() {}
	
	@Override
	public String toString() {
		return "TestDAO [productNo=" + productNo + ", categoryNo=" + categoryNo + ", productName=" + productName
				+ ", price=" + price + ", stock=" + stock + ", productDate=" + productDate + ", hit=" + hit
				+ ", productDatail=" + productDetail + "]";
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getProductDate() {
		return productDate;
	}
	public void setProductDate(String productDate) {
		this.productDate = productDate;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getProductDatail() {
		return productDetail;
	}
	public void setProductDatail(String productDatail) {
		this.productDetail = productDatail;
	}

}
