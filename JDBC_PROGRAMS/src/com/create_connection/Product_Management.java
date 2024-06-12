package com.create_connection;

public class Product_Management {
 
	private int proid;
	private String proname;
	private double proprice;
	private String promkddate;
	public Product_Management(int proid, String proname, double proprice, String promkddate) {
		super();
		this.proid = proid;
		this.proname = proname;
		this.proprice = proprice;
		this.promkddate = promkddate;
	}
	public Product_Management() {
		super();
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public double getProprice() {
		return proprice;
	}
	public void setProprice(double proprice) {
		this.proprice = proprice;
	}
	public String getPromkddate() {
		return promkddate;
	}
	public void setPromkddate(String promkddate) {
		this.promkddate = promkddate;
	}
	@Override
	public String toString() {
		return "Product_Management [proid=" + proid + ", proname=" + proname + ", proprice=" + proprice
				+ ", promkddate=" + promkddate + "]";
	}
	
	
}
