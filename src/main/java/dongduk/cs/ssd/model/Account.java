package dongduk.cs.ssd.model;

import java.io.Serializable;
import java.util.Date;

import dongduk.cs.ssd.controller.AccountForm;

@SuppressWarnings("serial")
public class Account implements Serializable {
	private String username;
	private String name;
	private String password;
	private String phonenum;
	private String postcode;
	private String address;
	private String detailAddress;
	private String intro;
	private Date joindate;
	private Boolean isadmin;
	
	public Account() {}
	
	public Account(AccountForm accountForm) {
		this.username = accountForm.getUsername();
		this.name = accountForm.getName();
		this.password = accountForm.getPasswd();
		this.phonenum = accountForm.getPhoneNum();
		this.postcode = accountForm.getPostcode();
		this.address = accountForm.getAddress();
		this.detailAddress = accountForm.getDetailAddress();
		this.intro = accountForm.getIntro();
	}
	
	public Account(String username, String name, String passwd, String phoneNum, 
			String postcode, String address, String detailAddress, String intro, Date joinDate, Boolean isAdmin) {
		super();
		this.username = username;
		this.name = name;
		this.password = passwd;
		this.phonenum = phoneNum;
		this.postcode = postcode;
		this.address = address;
		this.detailAddress = detailAddress;
		this.intro = intro;
		this.joindate = joinDate;
		this.isadmin = isAdmin;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String passwd) {
		this.password = passwd;
	}
	
	public String getPhonenum() {
		return phonenum;
	}
	
	public void setPhonenum(String phoneNum) {
		this.phonenum = phoneNum;
	}
	
	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getIntro() {
		return intro;
	}
	
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public Date getJoindate() {
		return joindate;
	}
	
	public void setJoindate(Date joinDate) {
		this.joindate = joinDate;
	}
	
	public Boolean getIsadmin() {
		return isadmin;
	}
	
	public void setIsadmin(Boolean isAdmin) {
		this.isadmin = isAdmin;
	}

}
