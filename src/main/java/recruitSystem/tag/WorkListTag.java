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

	private String query;
	private String type;
	private String city;
	private String pro;
	private PaginationSupport<Job> pages;
	
	
	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}


	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the pro
	 */
	public String getPro() {
		return pro;
	}


	/**
	 * @param pro the pro to set
	 */
	public void setPro(String pro) {
		this.pro = pro;
	}


	/**
	 * @return the pages
	 */
	public PaginationSupport<Job> getPages() {
		return pages;
	}


	/**
	 * @param pages the pages to set
	 */
	public void setPages(PaginationSupport<Job> pages) {
		this.pages = pages;
	}


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

		
		// 最多展示五个页码
		int pageNo = pages.getPageNo();// 页码
		int totalCount = pages.getTotalCount();// 总个数
		int pageSize = pages.getPageSize();

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
