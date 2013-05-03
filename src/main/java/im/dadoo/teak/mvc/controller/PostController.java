package im.dadoo.teak.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import im.dadoo.teak.mvc.domain.Post;
import im.dadoo.teak.mvc.service.CategoryService;
import im.dadoo.teak.mvc.service.FileService;
import im.dadoo.teak.mvc.service.PostService;
import im.dadoo.teak.util.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class PostController {

	@Autowired
	private PostService pos;
	
	@Autowired
	private FileService fs;
	
	@Autowired
	private CategoryService cs;
	
	//post增加页面
	@RequestMapping(value = "/admin/post", method = RequestMethod.GET)
	public String getPostAddPage(ModelMap map) {
		map.addAttribute("categories", this.cs.list(Util.STATE_NORMAL));
		return "admin/post";
	}
	
	//post增加响应
	@RequestMapping(value = "/admin/post", method = RequestMethod.POST)
	public String add(HttpSession session, @RequestParam String title, @RequestParam String author, 
			@RequestParam String html, @RequestParam Integer categoryId, 
			@RequestParam MultipartFile thumbnail) throws IllegalStateException, IOException {
		String root = session.getServletContext().getRealPath("/");
		String thumbnailPath = this.fs.save(thumbnail, root);
		System.out.println(thumbnailPath);
		
		this.pos.save(title, author, html, thumbnailPath, categoryId);

		return "redirect:/admin/posts";
	}
	
	@RequestMapping(value = "/admin/post/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		this.pos.deleteById(id);
		return "redirect:/admin/posts";
	}
	
	//post更新页面
	@RequestMapping(value = "/admin/post/{id}/update", method = RequestMethod.GET)
	public String getPostUpdatePage(@PathVariable Long id, ModelMap map) {
		map.addAttribute("categories", this.cs.list(Util.STATE_NORMAL));
		map.addAttribute("post", this.pos.fetchById(id));
		return "admin/post";
	}
	
	@RequestMapping(value = "/admin/post/{id}/update", method = RequestMethod.POST)
	public String update(HttpSession session, @PathVariable Long id, @RequestParam String title, 
			@RequestParam String author, @RequestParam String html, 
			@RequestParam MultipartFile thumbnail, @RequestParam Integer categoryId) throws IllegalStateException, IOException {
		if (thumbnail != null && thumbnail.getSize() > 0) {
			String root = session.getServletContext().getRealPath("/");
			String thumbnailPath = this.fs.save(thumbnail, root);
			this.pos.update(id, title, author, html, thumbnailPath, categoryId);
		}
		else {
			this.pos.update(id, title, author, html, categoryId);
		}
		return "redirect:/admin/posts";
	}
	
	@RequestMapping(value = "/admin/posts", method = RequestMethod.GET)
	public String getPostAdminPage(ModelMap map) {
		map.addAttribute("posts", this.pos.list(Util.STATE_NORMAL));
		return "admin/post-list";
	}
	
	@RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
	public String getPost(@PathVariable Long id, ModelMap map) {
		Post post = this.pos.visit(id);
		if (post != null) {
			map.addAttribute("post", post);
			return "post";
		}
		else {
			return "404";
		}
	}
}
