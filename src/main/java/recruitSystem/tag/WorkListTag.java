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
public class WorkListTag extends SimpleTagSupport {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		super.doTag();
		JspWriter out = getJspContext().getOut();
		HttpServletRequest request = (HttpServletRequest) ((PageContext) getJspContext()).getRequest();
		String query = request.getParameter("query");
		String type = request.getParameter("type");
		String city = request.getParameter("city");
		String pro = request.getParameter("pro");
		// System.out.println(city);
		if (type.equals(null)) {
			type = "工作类型";
		}
		if (query.equals(null)) {
			query = "";
		}
		if (city.equals(null)) {
			city = "城市";
		}
		if (pro.equals(null)) {
			pro = "省份";
		}

		PaginationSupport<Job> jobPages = (PaginationSupport<Job>) request.getAttribute("pages");// 获取传过来的分页参数
		// 最多展示五个页码
		int pageNo = jobPages.getPageNo();// 页码
		int totalCount = jobPages.getTotalCount();// 总个数
		int pageSize = jobPages.getPageSize();

		out.println(" <div class='pagebtn-container'>" + "<ul>");
		if (pageNo > 1) {
			out.println("<li><a href='/SpringBigJob/employmentPage?pageNo=" + (pageNo - 1) + "&type=" + type + "&pro="
					+ pro + "&city=" + city + "&query=" + query + "' >&lt</a></li>");
		}
		if (pageNo - 2 > 0) {
			out.println("<li><a href='/SpringBigJob/employmentPage?pageNo=" + (pageNo - 2) + "&type=" + type + "&pro="
					+ pro + "&city=" + city + "&query=" + query + "'>" + (pageNo - 2) + "</a></li>");
		}
		if (pageNo - 1 > 0) {
			out.println("<li><a href='/SpringBigJob/employmentPage?pageNo=" + (pageNo - 1) + "&type=" + type + "&pro="
					+ pro + "&city=" + city + "&query=" + query + "'>" + (pageNo - 1) + "</a></li>");
		}
		if (totalCount != 0) {
			out.println("<li class='focus'><a href=\"/SpringBigJob/employmentPage?pageNo=" + pageNo + "&type=" + type
					+ "&pro=" + pro + "&city=" + city + "&query=" + query + "\">" + pageNo + "</a></li>");
		}

		if ((pageNo) * pageSize < totalCount) {
			out.println("<li><a href=\"/SpringBigJob/employmentPage?pageNo=" + (pageNo + 1) + "&type=" + type + "&pro="
					+ pro + "&city=" + city + "&query=" + query + "\">" + (pageNo + 1) + "</a></li>");
		}
		if ((pageNo + 1) * pageSize < totalCount) {
			out.println("<li><a href='/SpringBigJob/employmentPage?pageNo=" + (pageNo + 2) + "&type=" + type + "&pro="
					+ pro + "&city=" + city + "&query=" + query + "'>" + (pageNo + 2) + "</a></li>");
		}

		if (pageNo * pageSize < totalCount) {

			out.println("<li><a href=\"/SpringBigJob/employmentPage?pageNo=" + (pageNo + 1) + "&type=" + type + "&pro="
					+ pro + "&city=" + city + "&query=" + query + "\">&gt</a></li>");

		}
		out.println("  </ul>" + "    </div>");
	}

}
