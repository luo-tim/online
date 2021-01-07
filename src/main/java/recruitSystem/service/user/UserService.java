/**
 * 
 */
package recruitSystem.service.user;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recruitSystem.dao.user.IUserDAO;
import recruitSystem.view.User;

/**
 * @author 72412
 * @author LJTTT
 *
 */
@Service("UserService")
public class UserService {
	
	@Autowired
	private IUserDAO iUserDAO;
	
	public List<User> findSignupUsers(int id) {
		return null;
	}
	
	public int successWorker(int flag, int workerId, int employmentId, Date date) {
		return 0;
	}
}
