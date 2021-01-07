/**
 * 
 */
package recruitSystem.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import recruitSystem.util.PaginationSupport;
import recruitSystem.view.Job;



/**
 * @author 72412
 *
 */
public class JobListTag  extends SimpleTagSupport{

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		JspWriter out = getJspContext().getOut();
		HttpServletRequest request = (HttpServletRequest) ((PageContext) getJspContext()).getRequest();
		String tag = request.getParameter("tag");
		PaginationSupport<Job> jobPages = (PaginationSupport<Job>) request.getAttribute("pages");// 获取传过来的分页参数
		// 最多展示五个页码
		int pageNo = jobPages.getPageNo();// 页码
		int totalCount = jobPages.getTotalCount();// 总个数
		int pageSize = jobPages.getPageSize();

		out.println(" <div class='pagebtn-container'>" + "<ul>");
		if (pageNo > 1) {
			out.println("<li><a href='/SpringBigJob/managerPage/checkRecruitmentPage?pageNo=" + (pageNo - 1) +"&tag=" + tag +"' >&lt</a></li>");
		}
		if (pageNo - 2 > 0) {
			out.println("<li><a href='/SpringBigJob/managerPage/checkRecruitmentPage?pageNo=" + (pageNo - 2) + "&tag=" + tag + "'>" + (pageNo - 2) + "</a></li>");
		}
		if (pageNo - 1 > 0) {
			out.println("<li><a href='/SpringBigJob/managerPage/checkRecruitmentPage?pageNo=" + (pageNo - 1) + "&tag=" + tag + "'>" + (pageNo - 1) + "</a></li>");
		}
		if (totalCount != 0) {
			out.println("<li class='focus'><a href=\"/SpringBigJob/managerPage/checkRecruitmentPage?pageNo=" + pageNo +"&tag=" + tag + 
					  "\">" + pageNo + "</a></li>");
		}

		if ((pageNo) * pageSize < totalCount) {
			out.println("<li><a href=\"/SpringBigJob/managerPage/checkRecruitmentPage?pageNo=" + (pageNo + 1) + "&tag=" + tag +"\">" + (pageNo + 1) + "</a></li>");
		}
		if ((pageNo + 1) * pageSize < totalCount) {
			out.println("<li><a href='/SpringBigJob/managerPage/checkRecruitmentPage?pageNo=" + (pageNo + 2) +"&tag=" + tag + "'>" + (pageNo + 2) + "</a></li>");
		}

		if (pageNo * pageSize < totalCount) {

			out.println("<li><a href=\"/SpringBigJob/managerPage/checkRecruitmentPage?pageNo=" + (pageNo + 1) + "&tag=" + tag +
					"\">&gt</a></li>");

		}
		out.println("  </ul>" + "    </div>");
	}

}
