package dongduk.cs.ssd.service;

import java.util.List;

import dongduk.cs.ssd.model.Inquiry;

public interface InquiryService {
	
	Inquiry getInquiry(int inquiryId);
	
	void insertInquiry(Inquiry inquiry);
	
	List<Inquiry> getInquiryByProject(int projectId);
	
	List<Inquiry> getInquiryByUsername(String username);
	
}
