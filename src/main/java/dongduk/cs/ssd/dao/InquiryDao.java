package dongduk.cs.ssd.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.model.Inquiry;

public interface InquiryDao {
	
	Inquiry getInquiry(int inquiryId) throws DataAccessException;
	
	void insertInquiry(Inquiry inquiry) throws DataAccessException;
	
	List<Inquiry> getInquiryByProject(int projectId) throws DataAccessException;
	
	List<Inquiry> getInquiryByUsername(String username) throws DataAccessException;
	
}
