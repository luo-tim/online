package recruitSystem.service.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recruitSystem.dao.job.*;
import recruitSystem.view.Job;
import recruitSystem.view.User;

@Service("JobService")
public class JobService {

	@Autowired
	private IJobDAO iJobDAO;
	
	public int save(Job job) {
		return 0;
	}
	
	public int existJob(int id) {
		return 0;
	}
	
	public Job findBossJob(int id) {
		return null;
	}
	
	public int finishJob(int workId) {
		return 0;
	}
}
