/**
 * 
 */
package recruitSystem.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import recruitSystem.view.User;

/**
 * @author 72412
 *超级管理员拦截器
 */
public class SuperManagerInterceptor implements HandlerInterceptor {
	private final static Log log = LogFactory.getLog(SuperManagerInterceptor.class);

	/**
	 * 
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		log.debug("3.Called after rendering the view");
	}

	/**
	 * 
	 */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		log.debug("2.Called after handler method request completion, before rendering the view");
	}

	/**
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		log.debug("1.Called before handler method");
		HttpSession session = request.getSession();
		User manager = (User) session.getAttribute("user");

		// 判断session中是否有用户数据，如果有，则返回true，继续向下执行
		if (manager != null && manager.getIdentityId() == 3) {
			return true;
		}
		// 不符合条件的转发到登录页面
		/*
		 * /deleteManagerPage /upManagerPage /addManagerPage
		 */
		response.sendRedirect(request.getContextPath() + "/homePage");// request.getContextPath()是为了解决相对路径的问题，可以返回站点的根路径
		return false;
	}

}
