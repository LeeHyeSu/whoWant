package dongduk.cs.ssd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.AnswerDao;
import dongduk.cs.ssd.model.Answer;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerDao answerDao;

	@Override
	public Answer getAnswer(int inquiryId) {
		Answer answer = answerDao.getAnswer(inquiryId);
		answer.setAnsDate(answer.getAnsDate().substring(0, 16));
		return answer;
	}

	@Override
	public void insertAnswer(Answer answer) {
		answerDao.insertAnswer(answer);
	}
	
}
