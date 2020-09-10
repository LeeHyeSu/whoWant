package dongduk.cs.ssd.controller;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import dongduk.cs.ssd.model.Account;

public class AccountForm {

	private Account account;
	private boolean newAccount;
	
	@NotBlank @Email
	private String username;
	@NotEmpty
	private String name;
	@NotEmpty @Size(min=4)
	private String passwd;
	@NotEmpty @Pattern(regexp = "01[01679]\\d{3,4}\\d{4}")
	private String phoneNum;
	@NotEmpty @Pattern(regexp = "\\d{5}")
	private String postcode;
	@NotEmpty
	private String address;
	@NotEmpty
	private String detailAddress;
	private String intro;

	public AccountForm() {
		this.newAccount = true;
	}

	public AccountForm(String username, String name, String passwd, String phoneNum, 
			String postcode, String address, String detailAddress, String intro) {
		super();
		this.username = username;
		this.name = name;
		this.passwd = passwd;
		this.phoneNum = phoneNum;
		this.postcode = postcode;
		this.address = address;
		this.detailAddress = detailAddress;
		this.intro = intro;	
		
		this.newAccount = false;
	}

	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}

	public boolean isNewAccount() {
		return newAccount;
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
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getPhoneNum() {
		return phoneNum;
	}
	
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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
	 
}
