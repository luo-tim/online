/**
 * 
 */
package recruitSystem.service.activateInfo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import recruitSystem.dao.activateInfo.ActivateInfoDAO;
import recruitSystem.view.ActivateInfo;

/**
 * @author 72412
 *验证码服务
 */
@Service("ActivateInfoService")
public class ActivateInfoService {

	@Autowired
	private ActivateInfoDAO activateInfoDAO;
	/**
	 * 保存验证码
	 * @param activateInfo
	 */
	public void save(ActivateInfo activateInfo) {
		// 1.0 根据用户id和验证类型，判断认证是否已存在
		ActivateInfo activateInfo2 = activateInfoDAO.selectByUserIdAndType(activateInfo.getUserId(), activateInfo.getType());
		
		// 判断是否已存在
		if (activateInfo2==null) {
			// 不存在，做插入操作
			activateInfoDAO.insert(activateInfo);
		} else {
			// 存在，做更新操作
			activateInfo.setId(activateInfo2.getId());
			
			activateInfoDAO.update(activateInfo);
		}
	}
	/**
	 * 用户找回密码，校验验证码
	 * @param email
	 * @param identifyingCode
	 * @return
	 * @throws ParseException
	 */
	public boolean findPwdCode(String email, String identifyingCode) throws  ParseException {
		// 1.0 校验验证码是否正确
		ActivateInfo activateInfo = activateInfoDAO.selectByEmailAndCodeAndType(email, identifyingCode, "find_pwd");
		if (activateInfo==null) {
			return false;
		}

		// 2.0 校验验证码是否已过期
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = formatter.format(currentTime);
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date d1 = df.parse(now);
		Date d2 = df.parse(activateInfo.getCreateTime());
		long diff = d1.getTime() - d2.getTime();
		long hours = diff / (1000 * 60 * 60);
		//		System.out.println("diff:"+diff);
		//		System.out.println("hours:"+hours);
		if (hours>0) {
			return false;
		}
		
		return true;
	}
}
