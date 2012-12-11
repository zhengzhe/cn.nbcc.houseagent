package cn.nbcc.houseagent.model;

import java.util.HashMap;
import java.util.Iterator;

import cn.nbcc.houseagent.model.HouseDescriptor.HouseDecAspects;

/***********************************************************************
 * Module:  HouseDescriptor.java
 * Author:  zheng zhe
 * Purpose: Defines the Class HouseDescriptor
 ***********************************************************************/

/**
 * 房型描述信息
 * 
 * @pdOid 311272b6-ffac-44e6-8062-937dbf9fe9c6
 */
public class HouseDescriptor extends ModelObject {

	public static enum HouseDecAspects {
		NUM_HALL("厅"), NUM_ROOM("房"), NUM_TOILET("卫"), NUM_BALCONY("阳台"), NUM_HOUSE_HOLD(
				"户"), NUM_ELEVATOR("梯"), NUM_GARAGE("车库");

		private String name;

		private HouseDecAspects(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

	/**
	 * 厅数
	 * 
	 * @pdOid bcc5c916-1946-45ca-b66c-fc47642b4298
	 */
	private int numOfHall;
	/**
	 * 房间数
	 * 
	 * @pdOid 14b08dc2-29bf-4a99-a94a-38bb7cc8db24
	 */
	private int numOfRoom;
	/**
	 * 卫生间数
	 * 
	 * @pdOid 807fe5d3-003a-42be-a741-755f0119d126
	 */
	private int numOfToilet;
	/**
	 * 阳台数
	 * 
	 * @pdOid 74c3aa2a-509b-4bb0-a3ed-5b8e41d5be1b
	 */
	private int numOfBalcony;
	/**
	 * 车库数
	 * 
	 * @pdOid 0989d81f-8cf3-441b-9ddc-09fadf908adb
	 */
	private int numOfGarage;
	/**
	 * 楼层户数
	 * 
	 * @pdOid b8284f35-6cf9-4291-a73d-d842d11c1ec2
	 */
	private int numOfHouseHold;
	/**
	 * 电梯数
	 * 
	 * @pdOid 00dcb2b5-77d4-456b-874b-d021ab3fa5ed
	 */
	private int numOfElevator;

	/** @pdOid e0154e40-d068-4cf5-9dc7-8bd339b987c4 */
	private java.lang.String comment;
	private boolean garden;

	private boolean peng;
	private boolean pool;

	public HouseDescriptor(HashMap<HouseDecAspects, Integer> hDecInt,
			String comment) {
		setNumOfBalcony(hDecInt.get(HouseDecAspects.NUM_BALCONY) == null ? 0
				: hDecInt.get(HouseDecAspects.NUM_BALCONY));
		setNumOfElevator(hDecInt.get(HouseDecAspects.NUM_ELEVATOR) == null ? 0
				: hDecInt.get(HouseDecAspects.NUM_ELEVATOR));
		setNumOfGarage(hDecInt.get(HouseDecAspects.NUM_GARAGE) == null ? 0
				: hDecInt.get(HouseDecAspects.NUM_GARAGE));
		setNumOfHall(hDecInt.get(HouseDecAspects.NUM_HALL) == null ? 0
				: hDecInt.get(HouseDecAspects.NUM_HALL));
		setNumOfHouseHold(hDecInt.get(HouseDecAspects.NUM_HOUSE_HOLD) == null ? 0
				: hDecInt.get(HouseDecAspects.NUM_HOUSE_HOLD));
		setNumOfRoom(hDecInt.get(HouseDecAspects.NUM_ROOM) == null ? 0
				: hDecInt.get(HouseDecAspects.NUM_ROOM));
		setNumOfToilet(hDecInt.get(HouseDecAspects.NUM_TOILET) == null ? 0
				: hDecInt.get(HouseDecAspects.NUM_TOILET));
		setComment(comment);
	}

	public HouseDescriptor() {

	}

	public HouseDescriptor(int[] vals, String comment) {
		setNumOfBalcony(vals[HouseDecAspects.NUM_BALCONY.ordinal()]);
		setNumOfElevator(vals[HouseDecAspects.NUM_ELEVATOR.ordinal()]);
		setNumOfGarage(vals[HouseDecAspects.NUM_GARAGE.ordinal()]);
		setNumOfHall(vals[HouseDecAspects.NUM_HALL.ordinal()]);
		setNumOfHouseHold(vals[HouseDecAspects.NUM_HOUSE_HOLD.ordinal()]);
		setNumOfRoom(vals[HouseDecAspects.NUM_ROOM.ordinal()]);
		setNumOfToilet(vals[HouseDecAspects.NUM_TOILET.ordinal()]);
		setComment(comment);

	}

	/** @pdOid c606b7a0-e27d-4f4d-b281-10457d279b2b */
	public int getNumOfElevator() {
		return numOfElevator;
	}

	/**
	 * @param newNumOfElevator
	 * @pdOid 9cb2d025-5f66-4c4c-af62-ff06660755c6
	 */
	public void setNumOfElevator(int newNumOfElevator) {
		firePropertyChange("numOfEvevator", this.numOfElevator,
				numOfElevator = newNumOfElevator);
	}

	/** @pdOid 29be0847-dea6-488c-9bb0-981e92a22e89 */
	public int getNumOfHouseHold() {
		return numOfHouseHold;
	}

	/**
	 * @param newNumOfHouseHold
	 * @pdOid 55a786c4-f102-4b83-96ee-a75c1e625023
	 */
	public void setNumOfHouseHold(int newNumOfHouseHold) {
		firePropertyChange("numOfHouseHold", this.numOfHouseHold,
				numOfHouseHold = newNumOfHouseHold);
	}

	/** @pdOid 26c98db8-7814-4259-b3fa-dc4d2b3563bf */
	public int getNumOfGarage() {
		return numOfGarage;
	}

	/**
	 * @param newNumOfGarage
	 * @pdOid 353d0953-431a-4f6d-8f29-dd444da03ea7
	 */
	public void setNumOfGarage(int newNumOfGarage) {
		firePropertyChange("numOfGarage", this.numOfGarage,
				numOfGarage = newNumOfGarage);
	}

	/** @pdOid abe9d077-5b85-4887-ad19-ec3eb879d4c3 */
	public int getNumOfBalcony() {
		return numOfBalcony;
	}

	/**
	 * @param newNumOfBalcony
	 * @pdOid ea1d4903-da3c-49de-b781-a058f378ebc6
	 */
	public void setNumOfBalcony(int newNumOfBalcony) {
		firePropertyChange("numOfBalcony", numOfBalcony,
				numOfBalcony = newNumOfBalcony);
	}

	/** @pdOid d64240f7-a737-4445-aeb3-b7df19631d20 */
	public int getNumOfToilet() {
		return numOfToilet;
	}

	/**
	 * @param newNumOfToilet
	 * @pdOid 5c90d802-b842-4612-80c2-de26168dd0d7
	 */
	public void setNumOfToilet(int newNumOfToilet) {
		firePropertyChange("numOfToilet", numOfToilet,
				numOfToilet = newNumOfToilet);
	}

	/** @pdOid ab3e08ac-44b1-4263-b716-560ff4f0a5ad */
	public int getNumOfRoom() {
		return numOfRoom;
	}

	/**
	 * @param newNumOfRoom
	 * @pdOid a0bf97e8-beed-4327-84f7-183e3668c902
	 */
	public void setNumOfRoom(int newNumOfRoom) {
		firePropertyChange("numOfRoom", numOfRoom, numOfRoom = newNumOfRoom);
	}

	/** @pdOid b9acd922-71a7-4cda-bdaf-41990303ad3b */
	public int getNumOfHall() {
		return numOfHall;
	}

	/**
	 * @param newNumOfHall
	 * @pdOid 118d954b-e9e3-48bc-9b9f-555d09dadbd0
	 */
	public void setNumOfHall(int newNumOfHall) {
		firePropertyChange("numOfHall", numOfHall, numOfHall = newNumOfHall);
	}

	/** @pdOid 3a5e711f-ee89-4556-871a-4052be55a5d3 */
	public java.lang.String getComment() {
		return comment;
	}

	/**
	 * @param newComment
	 * @pdOid 297dfb7e-241e-43fd-9522-a6b771d92cc8
	 */
	public void setComment(java.lang.String newComment) {
		firePropertyChange("comment", this.comment, newComment);
	}

	public String getHouseDescription() {
		StringBuilder s = new StringBuilder();
		if (numOfRoom > 0) {
			s.append(numOfRoom + "房");
		}
		if (numOfHall > 0) {
			s.append(numOfHall + "厅");
		}
		if (numOfToilet > 0) {
			s.append(numOfToilet + "卫");
		}
		if (numOfBalcony > 0) {
			s.append(numOfBalcony + "阳台");
		}
		if (numOfGarage > 0) {
			s.append(numOfGarage + "车库");
		}
		// if (!s.toString().isEmpty()) {
		// s.deleteCharAt(s.length()-1);
		// }
		return s.toString();
	}

	public String getEleDesciption() {
		StringBuilder s = new StringBuilder();
		if (numOfHouseHold > 0) {
			s.append(numOfHouseHold + "户");
		}
		if (numOfElevator > 0) {
			s.append(numOfElevator + "梯");
		}
		return s.toString();
	}

	public boolean getGarage() {
		return numOfGarage > 0 ? true : false;
	}

	public boolean getHasPeng() {
		return peng;
	}

	public boolean getGarden() {
		return garden;
	}

	public boolean getPool() {
		return pool;
	}

	public void setGarden(boolean garden) {
		firePropertyChange("garden", this.garden, this.garden = garden);
	}

	public void setPeng(boolean peng) {
		firePropertyChange("peng", this.peng, this.peng = peng);
	}

	public void setPool(boolean pool) {
		firePropertyChange("pool", this.pool, this.pool = pool);
	}

}
