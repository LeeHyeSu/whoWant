package dongduk.cs.ssd.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.AnswerDao;
import dongduk.cs.ssd.dao.mybatis.mapper.AnswerMapper;
import dongduk.cs.ssd.dao.mybatis.mapper.InquiryMapper;
import dongduk.cs.ssd.model.Answer;

@Repository
public class MybatisAnswerDao implements AnswerDao {
	
	@Autowired
	private AnswerMapper answerMapper;
	@Autowired
	private InquiryMapper inquiryMapper;
	
	@Override
	public Answer getAnswer(int inquiryId) throws DataAccessException {
		return answerMapper.getAnswer(inquiryId);
	}
	@Override
	public void insertAnswer(Answer answer) throws DataAccessException {
		answerMapper.insertAnswer(answer);
		inquiryMapper.updateInquiry(answer.getInquiryId()); 	// isAnswer = "1"로 변경
	}

}
