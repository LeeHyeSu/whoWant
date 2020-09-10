package dongduk.cs.ssd.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Inquiry implements Serializable {
	private int inquiryId;
	private String title;
	private String category;
	private String question;
	private String inqDate;
	private String isAnswer;
	private String username;
	private int projectId;
	private String isSecret;
	
	public Inquiry() {}

	public Inquiry(int inquiryId, String title, String category, String question, String inqDate, String isAnswer,
			String username, int projectId, String isSecret) {
		super();
		this.inquiryId = inquiryId;
		this.title = title;
		this.category = category;
		this.question = question;
		this.inqDate = inqDate;
		this.isAnswer = isAnswer;
		this.username = username;
		this.projectId = projectId;
		this.isSecret = isSecret;
	}

	public int getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getInqDate() {
		return inqDate;
	}

	public void setInqDate(String inqDate) {
		this.inqDate = inqDate;
	}

	public String getIsAnswer() {
		return isAnswer;
	}

	public void setIsAnswer(String isAnswer) {
		this.isAnswer = isAnswer;
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

	public String getIsSecret() {
		return isSecret;
	}

	public void setIsSecret(String isSecret) {
		this.isSecret = isSecret;
	}
	
	
}
