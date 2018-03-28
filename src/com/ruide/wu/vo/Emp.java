package com.ruide.wu.vo;

public class Emp {
	private int emono;
	private String ename;
	private String job;
	public int getEmono() {
		return emono;
	}
	public void setEmono(int emono) {
		this.emono = emono;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Emp(int emono, String ename, String job) {
		super();
		this.emono = emono;
		this.ename = ename;
		this.job = job;
	}
	public Emp() {
		super();
	}
	
}
