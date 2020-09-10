package dongduk.cs.ssd.dao.mybatis.mapper;

import dongduk.cs.ssd.model.Answer;

public interface AnswerMapper {

	Answer getAnswer(int inquiryId);
	
	void insertAnswer(Answer answer);
	
}