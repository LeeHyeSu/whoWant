package dongduk.cs.ssd.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.InquiryDao;
import dongduk.cs.ssd.model.Inquiry;

@Service
public class InquiryServiceImpl implements InquiryService {

	@Autowired
	private InquiryDao inquiryDao;

	@Override
	public Inquiry getInquiry(int inquiryId) {
		Inquiry inquiry = inquiryDao.getInquiry(inquiryId);
		inquiry.setInqDate(inquiry.getInqDate().substring(0, 16));
		return inquiry;
	}

	@Override
	public void insertInquiry(Inquiry inquiry) {
		inquiryDao.insertInquiry(inquiry);
	}

	@Override
	public List<Inquiry> getInquiryByProject(int projectId) {
		List<Inquiry> inquiries = inquiryDao.getInquiryByProject(projectId);
		for(Inquiry inquiry : inquiries) {
			inquiry.setInqDate(inquiry.getInqDate().substring(0, 16));
		}
		return inquiries;
	}

	@Override
	public List<Inquiry> getInquiryByUsername(String username) {
		List<Inquiry> inquiries = inquiryDao.getInquiryByUsername(username);
		for(Inquiry inquiry : inquiries) {
			inquiry.setInqDate(inquiry.getInqDate().substring(0, 16));
		}
		return inquiries;
	}
	
}
