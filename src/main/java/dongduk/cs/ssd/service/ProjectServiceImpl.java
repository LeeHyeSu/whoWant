package dongduk.cs.ssd.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import dongduk.cs.ssd.dao.ProjectDao;
import dongduk.cs.ssd.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired		// applicationContext.xml에 정의된 scheduler 객체를 주입 받음
	private ThreadPoolTaskScheduler scheduler;
	
	@Override
	public Project getProject(int projectId) {
		Project project = projectDao.getProject(projectId);
		project.setDeadline(project.getDeadline().substring(0, 10));
		project.setDaysUntilDeadline(calcDate(project.getDeadline()));
		project.setProgress(calcProgress(project.getCurrentAmount(), project.getGoalAmount()));
		return project;
	}

	@Override
	public void insertProject(Project project) {
		projectDao.insertProject(project);
	}

	@Override
	public void updateProject(Project project) {
		projectDao.updateProject(project);
		
	}

	@Override
	public void removeProject(int projectId) {
		projectDao.removeProject(projectId);
	}

	@Override
	public List<Project> getProjectsByCategory(String category) {
		List<Project> projects = projectDao.getProjectsByCategory(category);
		for(Project project : projects) {
			project.setDaysUntilDeadline(calcDate(project.getDeadline()));
			project.setProgress(calcProgress(project.getCurrentAmount(), project.getGoalAmount()));
		}
		return projects;
	}

	@Override
	public List<Project> getProjectsByUsername(String username) {
		List<Project> projects =  projectDao.getProjectsByUsername(username);
		for(Project project : projects) {
			project.setDeadline(project.getDeadline().substring(0, 10));
			project.setDaysUntilDeadline(calcDate(project.getDeadline()));
			project.setProgress(calcProgress(project.getCurrentAmount(), project.getGoalAmount()));
		}
		return projects;
	}

	@Override
	public List<Project> searchProjects(String keyword) {
		List<Project> projects =  projectDao.searchProjects(keyword);
		for(Project project : projects) {
			project.setDaysUntilDeadline(calcDate(project.getDeadline()));
			project.setProgress(calcProgress(project.getCurrentAmount(), project.getGoalAmount()));
		}
		return projects;
	}

	@Override
	public List<Project> getProjectList() {
		List<Project> projects =  projectDao.getProjectList();
		for(Project project : projects) {
			project.setDaysUntilDeadline(calcDate(project.getDeadline()));
			project.setProgress(calcProgress(project.getCurrentAmount(), project.getGoalAmount()));
		}
		return projects;
	}
	
	@Override
	public List<Project> getAllProjects() {
		List<Project> projects =  projectDao.getAllProjects();
		for(Project project : projects) {
			project.setDaysUntilDeadline(calcDate(project.getDeadline()));
			project.setProgress(calcProgress(project.getCurrentAmount(), project.getGoalAmount()));
		}
		return projects;
	}

	@Override
	public void ProjectScheduler(Date deadline) {
		
		Runnable updateTableRunner = new Runnable() {	
			@Override 
			public void run() {   // 스케쥴러에 의해 미래의 특정 시점에 실행될 작업을 정의				
				Date curTime = new Date();
				// 실행 시점의 시각을 전달하여 그 시각 이전의 deadline 값을 갖는 project의 상태를 변경 
				projectDao.closeProject(curTime);	// PROJECT 테이블의 레코드 갱신	
			}
		};
		
		scheduler.schedule(updateTableRunner, deadline);  
	}
	
	public Long calcDate(String deadline) {		// 프로젝트 남은 시간 구하기
		long time = System.currentTimeMillis();
		
		Date startDate = new Date(time);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		long diffDay = 0;
		try {
			Date endDate = format.parse(deadline);
			diffDay = (startDate.getTime() - endDate.getTime()) / (24*60*60*1000);
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		diffDay = (diffDay-1) * (-1);	// 오늘 날짜를 포함하고 음수를 양수로 바꿈
		return diffDay;
	}
	
	public int calcProgress(int current, int goal) {	// 프로젝트 진행률 구하기
		double result = (double) current / goal * 100;
		return (int)result;
	}
	
}
