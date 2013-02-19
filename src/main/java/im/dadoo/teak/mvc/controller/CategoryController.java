package im.dadoo.teak.mvc.controller;

import java.util.List;

import im.dadoo.teak.mvc.model.Category;
import im.dadoo.teak.mvc.service.CategoryService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoryController {

	private static Log log = LogFactory.getLog(CategoryController.class);
	
	@Autowired
	private CategoryService cs;
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String list() {
		List<Category> categories = this.cs.treeWithAll();
		log.debug(categories.size());
		for (Category c : categories) {
				log.debug(c.getName());
		}
		return "categories";
	}

}
