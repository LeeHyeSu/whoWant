package dongduk.cs.ssd.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Support implements Serializable{
	
	private String username;
	private int projectId;
	private int productId;
	private int amount;
	private String supportDate;
	private String paymentOption;

	private String request;
	private String projectName;
	private String productName;
	private String supporterName;
	private String phonenum;
	private String shipAddress;

	public Support() {
	}
	
	public Support(String username, int projectId, int productId, int amount, String supportDate, String paymentOption,
			String request, String projectName, String productName, String supporterName, String phonenum, String shipAddress) {
		super();
		this.username = username;
		this.projectId = projectId;
		this.productId = productId;
		this.amount = amount;
		this.supportDate = supportDate;
		this.paymentOption = paymentOption;
		this.request = request;
		this.projectName = projectName;
		this.productName = productName;
		this.supporterName = supporterName;
		this.phonenum = phonenum;
		this.shipAddress = shipAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getSupportDate() {
		return supportDate;
	}

	public void setSupportDate(String supportDate) {
		this.supportDate = supportDate;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSupporterName() {
		return supporterName;
	}

	public void setSupporterName(String supporterName) {
		this.supporterName = supporterName;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

}
