package cn.nbcc.houseagent.model;

public class HouseSource extends ModelObject{

	private String address;
	
	/**
	 * 所在区域
	 * 
	 * @pdOid bf12a459-a59d-4ad8-ad00-f3c8695cbf52
	 */
	private java.lang.String district;//所属区域：江东，江北
	
	private String floor;	//楼层描述 例如:13/17 ,独栋
	
	/**
	 * property management company物业公司
	 * 
	 * @pdOid 0c6ea369-0a00-496a-9da2-060c70ca03ef
	 */
	private Pmc pmc;	//物业：中建物业

	private String community;	//小区名称：怡江春色
	
	/** @pdRoleInfo migr=no name=HouseDescriptor assc=association5 mult=1..1 */
	   public HouseDescriptor houseDescriptor;//几房几室几厅等
	   /** @pdRoleInfo migr=no name=DecorationDescriptor assc=association6 mult=1..1 */
	   public DecorationDescriptor decorationDescriptor;
	
	public HouseDescriptor getHouseDescriptor() {
		return houseDescriptor;
	}

	public void setHouseDescriptor(HouseDescriptor houseDescriptor) {
		firePropertyChange("houseDescriptor", this.houseDescriptor, this.houseDescriptor = houseDescriptor);
	}

	public DecorationDescriptor getDecorationDescriptor() {
		return decorationDescriptor;
	}

	public void setDecorationDescriptor(DecorationDescriptor decorationDescriptor) {
		firePropertyChange("decorationDescriptor", this.decorationDescriptor, this.decorationDescriptor = decorationDescriptor);
	}

	public String getCommunit() {
		return community;
	}
	
	public void setCommunity(String community) {
		firePropertyChange("community", this.community, this.community=community);
	}
	
	
	public HouseSource(String community, Pmc pmc) {
		this(null,community,pmc,null,null);
	}
	
	public HouseSource(String district,String community,Pmc pmc){
		this(district,community,pmc,null,null);
	}
	

	public HouseSource(String community, Pmc pmc, String address) {
		this(null,community,pmc,address,null);
	}
	
	public HouseSource(String community, Pmc pmc, String address,String floor) {
		this(null,community,pmc,address,floor);
	}
	
	public HouseSource(String district, String community, Pmc pmc, String address,
			String floor) {
		setDistrict(district);
		setCommunity(community);
		setPmc(pmc);
		setAddress(address);
		setFloor(floor);
	}

	public HouseSource() {
		this("unknown", null);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof HouseSource) {
			HouseSource other = (HouseSource) obj;
			return this.community.equals(other.community) && this.pmc.equals(other.pmc);
		}
		return false;
	}

	public String getAddress() {
		return address;
	}

	public java.lang.String getDistrict() {
		return district;
	}
	
	public Pmc getPmc() {
		return pmc;
	}
	
	public void setAddress(String address) {
		firePropertyChange("address", this.address, this.address= address);
	}
	
	public void setDistrict(java.lang.String district) {
		firePropertyChange("district", this.district, this.district = district);
	}

	
	public void setPmc(Pmc pmc) {
		firePropertyChange("pmc", this.pmc, this.pmc= pmc);
	}


	public String getFloor() {
		return floor;
	}


	public void setFloor(String floor) {
		firePropertyChange("floor", this.floor, this.floor=floor);
	}


	public String getCommunity() {
		return community;
	}

}