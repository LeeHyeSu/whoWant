package dongduk.cs.ssd.model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class Project implements Serializable {
	
	private int projectId;
	private String name;
	private String image;
	private String description;
	private int goalAmount;
	private int currentAmount;
	private int supporterNum;
	private String deadline;
	private String username;
	private String category;
	private String state;
	private List<Product> products;
	
	private Long daysUntilDeadline;	// 마감일까지 남은 기간
	private int progress;			// 프로젝트 진행률
	
	
	public Project() {}
	
	public Project(int projectId, String name, String image, String description, int goalAmount, int currentAmount,
			int supporterNum, String deadline, String username, String category, String state, List<Product> products) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.image = image;
		this.description = description;
		this.goalAmount = goalAmount;
		this.currentAmount = currentAmount;
		this.supporterNum = supporterNum;
		this.deadline = deadline;
		this.username = username;
		this.category = category;
		this.state = state;
		this.products = products;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
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
	public int getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(int currentAmount) {
		this.currentAmount = currentAmount;
	}
	public int getSupporterNum() {
		return supporterNum;
	}
	public void setSupporterNum(int supporterNum) {
		this.supporterNum = supporterNum;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
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
	public String getState() {
		return state;
	}
	public void setState(String stateId) {
		this.state = stateId;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Long getDaysUntilDeadline() {
		return daysUntilDeadline;
	}
	public void setDaysUntilDeadline(Long daysUntilDeadline) {
		this.daysUntilDeadline = daysUntilDeadline;
	}
	public int getProgress() {
		return progress;
	}
	public void setProgress(int progress) {
		this.progress = progress;
	}
	
}
