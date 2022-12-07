package com.pet.model;

public class CartDTO {
	private int cNum;
	private String id;
	private int pNum;
	private String uName;
	private String pName;
	private int cnt;
	private int pPrice;
	

	public int getcNum() {
		return cNum;
	}

	public void setcNum(int cNum) {
		this.cNum = cNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}

	@Override
	public String toString() {
		return "CartVO [cNum=" + cNum + ", id=" + id + ", pNum=" + pNum + ", uName=" + uName + ", pName=" + pName
				+ ", cnt=" + cnt + ", pPrice=" + pPrice + "]";
	}

}
