package cn.nbcc.houseagent.model;

import java.text.DecimalFormat;

public class Pmc extends ModelObject {
	
	private String name;	//物业名称
	private double charge ; //物业费
	private int buildYear;	//建造年份
	
	
	public String getBuildYear() {
		DecimalFormat fourDecimalFormat = new DecimalFormat("0000");
		return fourDecimalFormat.format(buildYear);
	}
	public void setBuildYear(int buildYear) {
		firePropertyChange("buildYear", this.buildYear, this.buildYear=buildYear);
	}
	public Pmc() {
		// TODO Auto-generated constructor stub
	}
	
	public Pmc(String name, double charge) {
		super();
		this.name = name;
		this.charge = charge;
	}
	
	public Pmc(String name) {
		this(name,0);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		firePropertyChange("name", this.name, this.name=name);
	}
	public double getCharge() {
		return charge;
	}
	public void setCharge(double charge) {
		firePropertyChange("charge", this.charge, this.charge=charge);
	}

}
