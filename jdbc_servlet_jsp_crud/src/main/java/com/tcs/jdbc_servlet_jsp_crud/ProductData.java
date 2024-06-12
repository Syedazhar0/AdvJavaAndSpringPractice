package com.tcs.jdbc_servlet_jsp_crud;

import java.sql.Date;
import java.util.Arrays;

public class ProductData {
	private int pid;
	private String pname;
	private int pprice;
	private String pbrand;
	private String pmadein;
	private Date pmkddate;
	private Date pexpdate;
	private byte [] pimage;
	private byte [] paudio;
	private byte [] pvideo;
	public ProductData() {
		super();
	}
	public ProductData(int pid, String pname, int pprice, String pbrand, String pmadein, Date pmkddate, Date pexpdate,
			byte[] pimage, byte[] paudio, byte[] pvideo) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pbrand = pbrand;
		this.pmadein = pmadein;
		this.pmkddate = pmkddate;
		this.pexpdate = pexpdate;
		this.pimage = pimage;
		this.paudio = paudio;
		this.pvideo = pvideo;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public String getPbrand() {
		return pbrand;
	}
	public void setPbrand(String pbrand) {
		this.pbrand = pbrand;
	}
	public String getPmadein() {
		return pmadein;
	}
	public void setPmadein(String pmadein) {
		this.pmadein = pmadein;
	}
	public Date getPmkddate() {
		return pmkddate;
	}
	public void setPmkddate(Date pmkddate) {
		this.pmkddate = pmkddate;
	}
	public Date getPexpdate() {
		return pexpdate;
	}
	public void setPexpdate(Date pexpdate) {
		this.pexpdate = pexpdate;
	}
	public byte[] getPimage() {
		return pimage;
	}
	public void setPimage(byte[] pimage) {
		this.pimage = pimage;
	}
	public byte[] getPaudio() {
		return paudio;
	}
	public void setPaudio(byte[] paudio) {
		this.paudio = paudio;
	}
	public byte[] getPvideo() {
		return pvideo;
	}
	public void setPvideo(byte[] pvideo) {
		this.pvideo = pvideo;
	}
	@Override
	public String toString() {
		return "ProductData [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pbrand=" + pbrand
				+ ", pmadein=" + pmadein + ", pmkddate=" + pmkddate + ", pexpdate=" + pexpdate + ", pimage="
				+ Arrays.toString(pimage) + ", paudio=" + Arrays.toString(paudio) + ", pvideo="
				+ Arrays.toString(pvideo) + "]";
	}
}
