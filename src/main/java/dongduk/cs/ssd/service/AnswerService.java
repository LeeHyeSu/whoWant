package dongduk.cs.ssd.service;

import dongduk.cs.ssd.model.Answer;

public interface AnswerService {
	
	Answer getAnswer(int inquiryId);
	
	void insertAnswer(Answer answer);
	
}
