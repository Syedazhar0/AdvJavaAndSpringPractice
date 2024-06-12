package com.tcs.jdbc_jsp_crud_operation;

import java.sql.Date;
import java.util.Arrays;
// create pojo class
public class ProductData {
private int pid;
private String pname;
private int pprice;
private String pbrand;
private String pmadein;
private Date pmfddate;
private Date pexpDate;
private byte [] pimage;
private byte [] paudio;
private byte [] pvideo;
public ProductData(int pid, String pname, int pprice, String pbrand, String pmadein, Date pmfddate, Date pexpDate,
		byte[] pimage, byte[] paudio, byte[] pvideo) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.pprice = pprice;
	this.pbrand = pbrand;
	this.pmadein = pmadein;
	this.pmfddate = pmfddate;
	this.pexpDate = pexpDate;
	this.pimage = pimage;
	this.paudio = paudio;
	this.pvideo = pvideo;
}


public ProductData() {
	super();
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
public Date getPmfddate() {
	return pmfddate;
}
public void setPmfddate(Date pmfddate) {
	this.pmfddate = pmfddate;
}
public Date getPexpDate() {
	return pexpDate;
}
public void setPexpDate(Date pexpDate) {
	this.pexpDate = pexpDate;
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
	return "ProductData [pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pbrand=" + pbrand + ", pmadein="
			+ pmadein + ", pmfddate=" + pmfddate + ", pexpDate=" + pexpDate + ", pimage=" + Arrays.toString(pimage)
			+ ", paudio=" + Arrays.toString(paudio) + ", pvideo=" + Arrays.toString(pvideo) + "]";
}

}
