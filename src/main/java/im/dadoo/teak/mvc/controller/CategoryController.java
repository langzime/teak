package im.dadoo.teak.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import im.dadoo.teak.mvc.domain.Category;
import im.dadoo.teak.mvc.service.CategoryService;
import im.dadoo.teak.mvc.service.PostService;
import im.dadoo.teak.util.Util;

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
	public String add(@RequestParam String name, @RequestParam String description, 
			@RequestParam Integer supId, HttpSession session) {
		Category category = Category.create(name, description, this.cs.fetchById(supId));
		this.cs.save(category);
		session.setAttribute("c", this.cs.list(Util.STATE_NORMAL));
		return "redirect:/admin/categories";
	}
	
	@RequestMapping(value = "/admin/category/{categoryId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable Integer categoryId, HttpSession session) {
		this.cs.deleteById(categoryId);
		session.setAttribute("c", this.cs.list(Util.STATE_NORMAL));
		return "redirect:/admin/categories";
	}
	
	@RequestMapping(value = "/admin/category/{categoryId}/update", method = RequestMethod.POST)
	public String update(@PathVariable Integer categoryId, @RequestParam String name, 
			@RequestParam String description, @RequestParam Integer supId, HttpSession session) {
		this.cs.update(categoryId, name, description, supId);
		session.setAttribute("c", this.cs.list(Util.STATE_NORMAL));
		return "redirect:/admin/categories";
	}
	
	@RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
	public String posts(@PathVariable Integer id, ModelMap map) {
		map.addAttribute("category", this.cs.fetchById(id));
		return "category";
	}
	
	@RequestMapping(value = "/admin/categories", method = RequestMethod.GET)
	public String getCategoryAdminPage(ModelMap map) {
		List<Category> categories = this.cs.list();
		map.addAttribute("categories", categories);
		return "admin/category-list";
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
	
}
