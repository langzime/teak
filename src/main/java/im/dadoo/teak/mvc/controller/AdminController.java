package im.dadoo.teak.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import im.dadoo.teak.mvc.domain.Category;
import im.dadoo.teak.mvc.domain.Link;
import im.dadoo.teak.mvc.domain.Page;
import im.dadoo.teak.mvc.domain.Post;
import im.dadoo.teak.mvc.domain.User;
import im.dadoo.teak.mvc.service.CategoryService;
import im.dadoo.teak.mvc.service.LinkService;
import im.dadoo.teak.mvc.service.PageService;
import im.dadoo.teak.mvc.service.PostService;
import im.dadoo.teak.mvc.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	@Autowired
	private CategoryService cs;
	
	@Autowired
	private PostService pos;
	
	@Autowired
	private PageService pas;
	
	@Autowired
	private LinkService ls;
	
	@Autowired
	private UserService us;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdminPage() {
		return "admin/admin";
	}
	
	@RequestMapping(value = "/admin/user/{userId}/update", method = RequestMethod.GET)
	public String getUserUpdatePage(@PathVariable Integer userId, ModelMap map) {
		User user = this.us.fetchById(userId);
		map.addAttribute("user", user);
		return "admin/user";
	}
	
	@RequestMapping(value = "/admin/categories", method = RequestMethod.GET)
	public String getCategoryAdminPage(ModelMap map) {
		List<Category> categories = this.cs.list();
		map.addAttribute("categories", categories);
		return "admin/categories";
	}
	
	@RequestMapping(value = "/admin/category", method = RequestMethod.GET)
	public String getCategoryAddPage(ModelMap map) {
		map.addAttribute("categories", this.cs.list());
		return "admin/category";
	}
	
	@RequestMapping(value = "/admin/category/{categoryId}/update", method = RequestMethod.GET)
	public String getCategoryUpdatePage(@PathVariable Integer categoryId, ModelMap map) {
		Category category = this.cs.fetchById(categoryId);
		map.addAttribute("categories", this.cs.list());
		map.addAttribute("category", category);
		return "admin/category";
	}
	
	
	
	
	
	
	
	@RequestMapping(value = "/admin/pages", method = RequestMethod.GET)
	public String getPageAdminPage(ModelMap map) {
		List<Page> pages = this.pas.list();
		map.addAttribute("pages", pages);
		return "admin/pages";
	}
	
	@RequestMapping(value = "/admin/page", method = RequestMethod.GET)
	public String getPageAddPage() {
		return "admin/page";
	}
	
	@RequestMapping(value = "/admin/page/{pageId}/update", method = RequestMethod.GET)
	public String getPageUpdatePage(@PathVariable Long pageId, ModelMap map) {
		Page page = this.pas.fetchById(pageId);
		map.addAttribute("page", page);
		return "admin/page";
	}
	
	@RequestMapping(value = "/admin/links", method = RequestMethod.GET)
	public String getLinkAdminPage(ModelMap map) {
		List<Link> links = this.ls.list();
		map.addAttribute("links", links);
		return "admin/links";
	}
	
	@RequestMapping(value = "/admin/link", method = RequestMethod.GET)
	public String getLinkAddPage() {
		return "admin/link";
	}
	
	@RequestMapping(value = "/admin/link/{linkId}/update", method = RequestMethod.GET)
	public String getLinkUpdatePage(@PathVariable Integer linkId, ModelMap map) {
		Link link = this.ls.fetchById(linkId);
		map.addAttribute("link", link);
		return "admin/link";
	}
}
