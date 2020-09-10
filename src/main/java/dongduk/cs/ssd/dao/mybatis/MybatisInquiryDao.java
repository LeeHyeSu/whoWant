package dongduk.cs.ssd.dao.mybatis;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.InquiryDao;
import dongduk.cs.ssd.dao.SequenceDao;
import dongduk.cs.ssd.dao.mybatis.mapper.InquiryMapper;
import dongduk.cs.ssd.model.Inquiry;

@Repository
public class MybatisInquiryDao implements InquiryDao {
	
	@Autowired
	private InquiryMapper inquiryMapper;
	@Autowired
	private SequenceDao sequenceDao;

	@Override
	public Inquiry getInquiry(int inquiryId) throws DataAccessException {
		return inquiryMapper.getInquiry(inquiryId);
	}

	@Override
	public void insertInquiry(Inquiry inquiry) throws DataAccessException {
		inquiry.setInquiryId(sequenceDao.getNextId("inquirynum"));
		inquiry.setIsAnswer("0");
		inquiryMapper.insertInquiry(inquiry);
	}

	@Override
	public List<Inquiry> getInquiryByProject(int projectId) throws DataAccessException {
		return inquiryMapper.getInquiryByProject(projectId);
	}

	@Override
	public List<Inquiry> getInquiryByUsername(String username) throws DataAccessException {
		return inquiryMapper.getInquiryByUsername(username);
	}

}
