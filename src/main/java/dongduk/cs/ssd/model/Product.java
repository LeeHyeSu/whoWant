package dongduk.cs.ssd.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Product implements Serializable {
	
	private int productId;
	private String name;
	private String description;
	private int price;
	private int projectId;
	private int quantity;
	private int member;
	
	public Product() {}

	public Product(int productId, String name, String description, int price, int projectId, int quantity, int member) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.projectId = projectId;
		this.quantity = quantity;
		this.member = member;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getMember() {
		return member;
	}

	public void setMember(int member) {
		this.member = member;
	}
	
}
