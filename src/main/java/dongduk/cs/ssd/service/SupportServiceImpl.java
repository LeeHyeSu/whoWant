package dongduk.cs.ssd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.ProjectDao;
import dongduk.cs.ssd.dao.SupportDao;
import dongduk.cs.ssd.model.Support;

@Service
public class SupportServiceImpl implements SupportService {

	@Autowired
	private SupportDao supportDao;
	
	@Override
	public Support getSupport(String username, String projectId) {
		return supportDao.getSupport(username, projectId);
	}

	@Override
	public List<Support> getSupports() {
		return supportDao.getSupports();
	}
	
	@Override
	public List<Support> getSupportsByProject(int projectId) {
		return supportDao.getSupportsByProject(projectId);
	}
	
	@Override
	public List<Support> getSupportsByUsername(String username) {
		List<Support> supports = supportDao.getSupportsByUsername(username);
		return supports;
	}

	@Override
	public void insertSupport(Support support) {
		supportDao.insertSupport(support);
	}

	@Override
	public void updateSupport(Support support) {
		supportDao.updateSupport(support);
	}

	@Override
	public void removeSupport(String username, int projectId) {
		supportDao.removeSupport(username, projectId);
	}
	
}
