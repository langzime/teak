package im.dadoo.teak.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import im.dadoo.teak.mvc.domain.Category;
import im.dadoo.teak.mvc.service.CategoryService;
import im.dadoo.teak.mvc.service.PostService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CategoryController {

	private static Log log = LogFactory.getLog(CategoryController.class);
	
	@Autowired
	private CategoryService cs;
	
	@Autowired
	private PostService pos;

	@RequestMapping(value = "/admin/category", method = RequestMethod.POST)
	public String add(@RequestParam String name, @RequestParam String url,
			@RequestParam String description, @RequestParam int supId, HttpSession session) {
		this.cs.insert(new Category(name, url, description, supId));
		session.setAttribute("c", this.cs.treeWithAll());
		return "redirect:/admin/categories";
	}
	
	@RequestMapping(value = "/admin/category/{categoryId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable int categoryId, HttpSession session) {
		this.cs.deleteById(categoryId);
		session.setAttribute("c", this.cs.treeWithAll());
		return "redirect:/admin/categories";
	}
	
	@RequestMapping(value = "/admin/category/{categoryId}/update", method = RequestMethod.POST)
	public String update(@PathVariable int categoryId, @RequestParam String name, 
			@RequestParam String url, @RequestParam String description, 
			@RequestParam int supId, HttpSession session) {
		Category category = new Category(name, url, description, supId);
		category.setId(categoryId);
		this.cs.update(category);
		session.setAttribute("c", this.cs.treeWithAll());
		return "redirect:/admin/categories";
	}
	
	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public String getPosts(@PathVariable int categoryId, ModelMap map) {
		map.addAttribute("posts", this.pos.listByCategoryId(categoryId));
		map.addAttribute("category", this.cs.fetchById(categoryId));
		return "post-list";
	}
}
