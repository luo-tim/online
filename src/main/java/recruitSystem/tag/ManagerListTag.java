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
import recruitSystem.view.Company;
import recruitSystem.view.User;



/**
 * @author 72412
 *
 */
public class ManagerListTag extends SimpleTagSupport {



	private PaginationSupport<Company> pages;
	
	
	/**
	 * @return the pages
	 */
	public PaginationSupport<Company> getPages() {
		return pages;
	}


	/**
	 * @param pages the pages to set
	 */
	public void setPages(PaginationSupport<Company> pages) {
		this.pages = pages;
	}


	/* (non-Javadoc)
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
			out.println("<li><a href='/online/managerPage/managerListPage?pageNo=" + (pageNo - 1) +"' >&lt</a></li>");
		}
		if (pageNo - 2 > 0) {
			out.println("<li><a href='/online/managerPage/managerListPage?pageNo=" + (pageNo - 2) +  "'>" + (pageNo - 2) + "</a></li>");
		}
		if (pageNo - 1 > 0) {
			out.println("<li><a href='/online/managerPage/managerListPage?pageNo=" + (pageNo - 1) +  "'>" + (pageNo - 1) + "</a></li>");
		}
		if (totalCount != 0) {
			out.println("<li class='focus'><a href=\"/online/managerPage/managerListPage?pageNo=" + pageNo + 
					  "\">" + pageNo + "</a></li>");
		}

		if ((pageNo) * pageSize < totalCount) {
			out.println("<li><a href=\"/online/managerPage/managerListPage?pageNo=" + (pageNo + 1) + "\">" + (pageNo + 1) + "</a></li>");
		}
		if ((pageNo + 1) * pageSize < totalCount) {
			out.println("<li><a href='/online/managerPage/managerListPage?pageNo=" + (pageNo + 2) + "'>" + (pageNo + 2) + "</a></li>");
		}

		if (pageNo * pageSize < totalCount) {

			out.println("<li><a href=\"/online/managerPage/managerListPage?pageNo=" + (pageNo + 1) + 
					"\">&gt</a></li>");

		}
		out.println("  </ul>" + "    </div>");
		

	}

	
}
