package dongduk.cs.ssd.dao.mybatis.mapper;

import java.util.List;

import dongduk.cs.ssd.model.Inquiry;

public interface InquiryMapper {

	Inquiry getInquiry(int inquiryId);
	
	void insertInquiry(Inquiry inquiry);
	
	List<Inquiry> getInquiryByProject(int projectId);
	
	List<Inquiry> getInquiryByUsername(String username);
	
	void updateInquiry(int inquiryId);
}