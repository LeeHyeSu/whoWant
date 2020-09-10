package dongduk.cs.ssd.controller;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import dongduk.cs.ssd.model.Product;

public class ProjectForm {
	
	private int projectId;
	@NotBlank
	private String name;
	private MultipartFile image;
	@NotEmpty
	private String description;
	@Min(4)
	private int goalAmount;
	@Future
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date deadline;
	private String username;
	private String category;
	private List<Product> products;
	
	private boolean newProject;
	
	public ProjectForm() {
		this.newProject = true;
	}

	public ProjectForm(int projectId, String name, String description, int goalAmount, Date deadline, String username,
			String category, List<Product> products) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.description = description;
		this.goalAmount = goalAmount;
		this.deadline = deadline;
		this.username = username;
		this.category = category;
		this.products = products;
		this.newProject = false;
	}
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getGoalAmount() {
		return goalAmount;
	}
	public void setGoalAmount(int goalAmount) {
		this.goalAmount = goalAmount;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public boolean isNewProject() {
		return newProject;
	}
	
}
