package im.dadoo.teak.interceptor;

import im.dadoo.teak.mvc.model.Category;
import im.dadoo.teak.mvc.service.CategoryService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class CategorySessionInterceptor extends HandlerInterceptorAdapter {

	private static Log log = LogFactory.getLog(CategorySessionInterceptor.class);
	
	@Autowired
	private CategoryService cs;
	
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		if (session.getAttribute("c") == null) {
			List<Category> categories = this.cs.treeWithAll();
			log.debug(categories.size());
			session.setAttribute("c", categories);
		}
		return true;
	}
}
