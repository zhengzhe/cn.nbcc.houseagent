package cn.nbcc.houseagent.model;

/***********************************************************************
 * Module:  User.java
 * Author:  zheng zhe
 * Purpose: Defines the Class User
 ***********************************************************************/

import java.util.*;

/**
 * 登记用户
 * 
 * @pdOid 6badb35f-5b0e-4114-bf2c-0caee7752b93
 */
public class User {
	public User(String uName) {
		// TODO Auto-generated constructor stub
		username = uName;
	}

	/** @pdOid 3514dedb-e988-4514-b8b0-65e8fc43db57 */
	private java.lang.String id;
	/** @pdOid fb894c64-badc-4714-8590-bbe4349ab3dc */
	private java.lang.String username;
	/** @pdOid 4c95e90a-85d0-499f-baf3-e62547b1e0e4 */
	private java.lang.String password;
	/** @pdOid c42503af-539b-4841-906d-3740c4188368 */
	private LogStatus status;

	public String getName() {
		return username;
	}

}