package im.dadoo.teak.mvc.controller;

import java.util.List;

import im.dadoo.teak.mvc.model.Category;
import im.dadoo.teak.mvc.model.Post;
import im.dadoo.teak.mvc.service.CategoryService;
import im.dadoo.teak.mvc.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	@Autowired
	private CategoryService cs;
	
	@Autowired
	private PostService ps;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdminPage() {
		return "admin/admin";
	}
	
	@RequestMapping(value = "/admin/category", method = RequestMethod.GET)
	public String getCategoryAdminPage(ModelMap map) {
		List<Category> categories = this.cs.list();
		map.addAttribute("categories", categories);
		return "admin/category";
	}
	
	@RequestMapping(value = "/admin/post", method = RequestMethod.GET)
	public String getPostAdminPage(ModelMap map) {
		List<Post> posts = this.ps.listWithAll();
		map.addAttribute("posts", posts);
		return "admin/post";
	}
}
