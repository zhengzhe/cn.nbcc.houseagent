package cn.nbcc.houseagent.model;

/***********************************************************************
 * Module:  Contactor.java
 * Author:  zheng zhe
 * Purpose: Defines the Class Contactor
 ***********************************************************************/

import java.util.*;

/**
 * 出租人、售房联系人
 * 
 * @pdOid 2a164860-b434-4594-8e2a-2f4642a9ebd5
 */
public class Contactor extends ModelObject{
	/** @pdOid 305d02ec-fde3-4199-84a6-c29e19e271fa */
	private java.lang.String id;
	/** @pdOid e95fbb19-650b-4576-85cb-ccfd14eb9876 */
	private java.lang.String name;
	/** @pdOid 1a789832-4aa8-4a61-b4dd-1d3bd24ecb9e */
	private java.lang.String phone;

	public Contactor(String id,String name, String phone) {
			this.id = id;
			this.name = name;
			this.phone = phone;
	}

	public java.lang.String getId() {
		return id;
	}

	public java.lang.String getName() {
		return name;
	}

	public java.lang.String getPhone() {
		return phone;
	}


	public java.lang.String getEmail() {
		return email;
	}

	/** @pdOid aefb2bef-ca19-4d57-9be8-9748d19f873c */
//	private java.lang.String phone2;
	/** @pdOid 3e707a42-db14-485a-8b87-1566ed15f6ec */
	private java.lang.String email;
	
	public void setName(java.lang.String name) {
		firePropertyChange("name", this.name, this.name = name);
	}

	public void setPhone(java.lang.String phone) {
		firePropertyChange("phone", this.phone, this.phone = phone);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Contactor) {
			Contactor other = (Contactor) obj;
			return this.id.equals(other.getId()) && this.name.equals(other.name) && this.phone.equals(other.phone);
		}
		return super.equals(obj);
	}

}