package dongduk.cs.ssd.dao;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.model.Answer;

public interface AnswerDao {
	
	Answer getAnswer(int inquiryId) throws DataAccessException;
	
	void insertAnswer(Answer answer) throws DataAccessException;

}
