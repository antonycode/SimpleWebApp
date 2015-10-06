package org.o7planning.simplewebapp.beans;

public class UserAccount {
	public static final String GENDER_MALE = "M";
	public static final String GENDER_FEMALE = "F";
	
	private String userName;
	private String password;
	private String gender;
	
	public UserAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
