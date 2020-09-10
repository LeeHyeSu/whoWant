package dongduk.cs.ssd.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Answer implements Serializable {
	private int inquiryId;
	private String username;
	private String answer;
	private String ansDate;
	
	public Answer() {}

	public Answer(int inquiryId, String username, String answer, String ansDate) {
		super();
		this.inquiryId = inquiryId;
		this.username = username;
		this.answer = answer;
		this.ansDate = ansDate;
	}

	public int getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnsDate() {
		return ansDate;
	}

	public void setAnsDate(String ansDate) {
		this.ansDate = ansDate;
	}
	
}
