package cn.nbcc.houseagent.model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.*;


import cn.nbcc.houseagent.utils.RentConstants;

/**
 * 出租条目
 * 
 * 
 * @pdOid 3443b0d0-bf44-4e5f-a539-ddc11a493b1b
 */

public class RentItem extends ModelObject implements PropertyChangeListener{
	
	private HouseSource houseSource;
	/**
	 * 备注
	 * 
	 * @pdOid 6f44bc39-93d1-4a53-abdd-9b25e74645de
	 */
	private java.lang.String comment;
	/**
	 * 联系人
	 * 
	 * @pdOid 3d4dda3e-e216-4b9e-beeb-7de3e7b02f8a
	 */
	private Contactor contactor;
	/**
	 * 到期时间
	 * 
	 * @pdOid c0eb2ac8-79a1-4edf-bea5-5efd20cc4e6b
	 */
	private java.util.Date dueDate;
	/**
	 * id
	 * 
	 * @pdOid 99e227ea-d316-4f74-9a68-763533f31872
	 */
	private java.lang.String id;

	/**
	 * 登记人
	 * 
	 * 
	 * @pdOid 5e0df45f-3d51-49ad-90ef-8f569f647a9f
	 */
	private User register;

	/**
	 * 租金费用
	 * 
	 * @pdOid 784dd5ac-4594-42f7-9ecb-7e2c25eb6cf8
	 */
	private double rentCharge;

	/**
	 * 出租方式
	 * 
	 * @pdOid 5497f98b-adcb-44ff-93ea-c6cc5cea84a6
	 */
	private int rentStyle = RentConstants.SOLE_TANANT;

	/**
	 * 来源
	 * 
	 * @pdOid 9565998b-890f-4012-aa62-1e8bed76a16a
	 */
	private int source;

	/**
	 * 出租状态
	 * 
	 * @pdOid cac32c07-91cc-44af-9e4a-6a7741be734d
	 */
	private int rentStatus = RentConstants.UNOCCUPANCY;
	private Date startDate;


	public Date getStartDate() {
		return startDate;
	}

	public java.lang.String getComment() {
		return comment;
	}

	public Contactor getContactor() {
		return contactor;
	}
	
//	public Contactor getFirstContactor(){
//		return contactor.length>=0?contactor[0]:null;
//	}

	

	public java.util.Date getDueDate() {
		return dueDate;
	}
	
//	public String getDueDateStr(){
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		return sdf.format(dueDate);
//	}

	public java.lang.String getId() {
		return id;
	}

	
	public User getRegister() {
		return register;
	}

	public double getRentCharge() {
		return rentCharge;
	}

	public int getRentStyle() {
		return rentStyle;
	}

	public int getSource() {
		return source;
	}

	public int getRentStatus() {
		return rentStatus;
	}


	public void setComment(java.lang.String comment) {
		
		firePropertyChange("comment", this.comment, this.comment=comment);
//		this.comment = comment;
		
	}

	public void setContactor(Contactor contactor) {
//		this.contactors = contactors;
		firePropertyChange("contactor", this.contactor, this.contactor=contactor);
	}

	

	public void setId(java.lang.String id) {
//		this.id = id;
		firePropertyChange("id", this.id, this.id = id);
	}

	public void setStartDate(Date startDate) {
		Date  oldStarteDate = this.startDate;
		Date oldDueDate = getDueDate();
		setDefaultDueDate(startDate, Calendar.MONTH, RentConstants.DEFAULT_RENT_DUEDATE);
		Date newDueDate = getDueDate();
		if (oldDueDate!=null&&oldDueDate.after(newDueDate)) {
			setDueDate(oldDueDate);
		}
		this.startDate = startDate;
		firePropertyChange("startDate", oldStarteDate, startDate);
	}

	private void setDefaultDueDate(Date startDate,int field,int amount) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		calendar.add(field,amount);
		this.dueDate=calendar.getTime();
	}


	public void setRegister(User register) {
		firePropertyChange("register", this.register, this.register=register);
		
	}

	public void setRentCharge(double rentCharge) {
		firePropertyChange("rentCharge", this.rentCharge, this.rentCharge = rentCharge);
	}

	public void setRentStyle(int rentStyle) {
		firePropertyChange("rentStyle", this.rentStyle, this.rentStyle = rentStyle);
	}

	/**
	 * 注册对source对象的属性事件监听，并转发相应事件
	 *
	 * @param source
	 * author:zheng zhe
	 * Update:2012-12-7
	 */
	public void setSource(int source) {
		
		firePropertyChange("source", this.source, this.source = source);
	}

	public void setRentStatus(int status) {
		firePropertyChange("rentStatus", this.rentStatus, this.rentStatus=status);
	}

	public RentItem(String id, HouseSource houseSource,
			double charge, int rentStyle, int rentStatus,
			Contactor contactor, Date startDate, int sourceFrom, User regitser,
			String comment) {
		this(id,houseSource,charge,rentStyle,rentStatus,contactor,startDate,null,sourceFrom,regitser,comment);
		setDefaultDueDate(startDate, Calendar.MONTH, RentConstants.DEFAULT_RENT_DUEDATE);
	}

	public void setDueDate(Date dueDate) {
		Date oldDueDate = this.dueDate;
		if (dueDate==null) {
			if (startDate==null) {
				this.startDate = new GregorianCalendar().getTime();	//设置默认开始时间为当前日期
			}
			setDefaultDueDate(startDate, Calendar.MONTH, RentConstants.DEFAULT_RENT_DUEDATE);
		}else {
			if(!startDate.before(dueDate))
			{
				setDefaultDueDate(startDate, Calendar.MONTH, RentConstants.DEFAULT_RENT_DUEDATE);
			}else
				this.dueDate = dueDate;
		}
		
		Date newDueDate = this.dueDate;
		firePropertyChange("dueDate", oldDueDate, newDueDate);
	}
	
	/**
	 * @param id
	 * @param hSource
	 * @param rentCharge
	 * @param contactors
	 * @param startDate
	 * @param register
	 * author:zheng zhe
	 * Update:2012-8-6
	 */
	public RentItem(String id, HouseSource hSource, double rentCharge,
			Contactor contactor, Date startDate, User register) {
	this(id,hSource,rentCharge,contactor,startDate,null,register);
	}

	public RentItem(String id, HouseSource houseSource, double charge,
			Contactor contactor, Date startDate,Date dueDate, User user) {
		
		this(id,houseSource,RentConstants.SOLE_TANANT|RentConstants.UNOCCUPANCY|RentConstants.FROM_USER,charge, contactor,startDate,dueDate,user);
	}
	
	
	/**
	 * 指定用户自定义租房样式和租房状态，租房信息来源
	 * 
	 * @param id
	 * @param houseSource
	 * @param style
	 * @param charge
	 * @param contactors
	 * @param dueDate
	 * @param user
	 * author:zheng zhe
	 * Update:2012-8-6
	 */
	public RentItem(String id, HouseSource houseSource, int style,double charge,
			Contactor contactor, Date startDate, Date dueDate, User user) {
		this(id,houseSource,charge,RentConstants.SOLE_TANANT,RentConstants.UNOCCUPANCY,contactor,startDate,dueDate,RentConstants.FROM_USER,user,"");
		if ((RentConstants.SPELL_RENT|style)==RentConstants.SPELL_RENT) {
			setRentStyle(RentConstants.SPELL_RENT);
		}
		
		if ((RentConstants.OCCUPANCY|style)==RentConstants.OCCUPANCY) {
			setRentStatus(RentConstants.OCCUPANCY);
		}
		if ((RentConstants.FROM_COMPANY|style)==RentConstants.FROM_COMPANY) {
			setSource(RentConstants.FROM_COMPANY);
		}
		if ((RentConstants.FROM_WEB|style)==RentConstants.FROM_WEB) {
			setSource(RentConstants.FROM_WEB);
		}
		if ((RentConstants.FROM_OTHER|style)==RentConstants.FROM_OTHER) {
			setSource(RentConstants.FROM_OTHER);
		}
	}
	
	public RentItem() {
		this("unknown",new HouseSource("unknown",new Pmc()),RentConstants.DEFAULT_CHARGE,null,null);
	}
	/**
	 * 使用默认租房样式和租房状态
	 * 使用默认来源为用户
	 * @param id
	 * @param houseSource
	 * @param charge
	 * @param contactors
	 * @param user
	 * author:zheng zhe
	 * Update:2012-8-6
	 */
	public RentItem(String id, HouseSource houseSource, double charge,Contactor contactor, User user) {
		this(id,houseSource,charge,RentConstants.SOLE_TANANT,RentConstants.UNOCCUPANCY,contactor,new GregorianCalendar().getTime(),RentConstants.FROM_USER,user,"");
	}
	
	
	

	/**
	 * 
	 * @param id     				id
	 * @param hSource		房源
	 * @param rentCharge	租金
	 * @param rentStyle		租房样式
	 * @param rentStatus	租房状态
	 * @param contactors	联系人
	 * @param startDate		开始时间
	 * @param dueDate		结束时间
	 * @param source			来源
	 * @param register		登记人
	 * @param comment		备注
	 * author:zheng zhe
	 * Update:2012-8-6
	 */
	public RentItem(String id, HouseSource hSource, double rentCharge,
			int rentStyle, int rentStatus, Contactor contactor,
			Date startDate, Date dueDate, int source, User register,
			String comment) {
		super();
		setId(id);
		setHouseSource(hSource);
		setRentStyle(rentStyle);
		setRentStatus(rentStatus);
		setRentCharge(rentCharge);
		setContactor(contactor);
		setStartDate(startDate);
		setDueDate(dueDate);
		setSource(source);
		setRegister(register);
		setComment(comment);
	}
	
	

	public void setHouseSource(HouseSource houseSource) {
		if (this.houseSource!=null) {
			this.houseSource.removePropertyChangeListener(this);
//			addPropertyChangeListener(this.houseSource);
		}
		this.houseSource = houseSource;
		houseSource.addPropertyChangeListener(this);
	}

	public HouseSource getHouseSource() {
		return this.houseSource;
	}

	public String getContactors() {
		StringBuilder contactorInfo = new StringBuilder();
//		for (int i = 0; i < contactor.length; i++) {
			contactorInfo.append("姓名:");
			contactorInfo.append(contactor.getName());
			contactorInfo.append(",电话:");
			contactorInfo.append(contactor.getPhone());
//			if (i!=contactor.length-1) {
//				contactorInfo.append("\n");
//			}
//		}
		return contactorInfo.toString();
	}

	@Override
	public String toString() {
		return "[id="+getId()+",rent item]";
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		firePropertyChange(evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
	}
}