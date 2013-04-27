package im.dadoo.teak.mvc.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import im.dadoo.teak.mvc.model.Post;
import im.dadoo.teak.mvc.service.CategoryService;
import im.dadoo.teak.mvc.service.FileService;
import im.dadoo.teak.mvc.service.PostService;

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
	
	@RequestMapping(value = "/admin/post", method = RequestMethod.POST)
	public String add(HttpSession session, @RequestParam String title, @RequestParam String author, 
			@RequestParam String content, @RequestParam int categoryId, 
			@RequestParam MultipartFile headerImage) throws IllegalStateException, IOException {
		String root = session.getServletContext().getRealPath("/");
		String headerImagePath = this.fs.save(headerImage, root);
		System.out.println(headerImagePath);
		Post post = new Post(title, author, content, headerImagePath, categoryId);

		this.pos.insert(post);
		return "redirect:/admin/posts";
	}
	
	@RequestMapping(value = "/admin/post/{postId}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable int postId) {
		System.out.println(postId);
		this.pos.deleteById(postId);
		return "redirect:/admin/posts";
	}
	
	@RequestMapping(value = "/admin/post/{postId}/update", method = RequestMethod.POST)
	public String update(HttpSession session, @PathVariable int postId, @RequestParam String title, 
			@RequestParam String author, @RequestParam String content, 
			@RequestParam MultipartFile headerImage,
			@RequestParam long publishTime, @RequestParam int categoryId) throws IllegalStateException, IOException {
		Post post = null;
		if (headerImage != null && headerImage.getSize() > 0) {
			String root = session.getServletContext().getRealPath("/");
			String headerImagePath = this.fs.save(headerImage, root);
			post = new Post(title, author, content, headerImagePath, publishTime, categoryId);
		}
		else {
			post = new Post(title, author, content, null, publishTime, categoryId);
			Post t = this.pos.fetchById(postId);
			post.setHeaderImagePath(t.getHeaderImagePath());
		}
		post.setId(postId);
		this.pos.update(post);
		return "redirect:/admin/posts";
	}
	
	@RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
	public String getPost(@PathVariable long postId, ModelMap map) {
		Post post = this.pos.fetchByIdWithAll(postId);
		if (post != null) {
			map.addAttribute("post", post);
			post.setClick(post.getClick() + 1);
			this.pos.update(post);
			return "post";
		}
		else {
			return "404";
		}
	}
	
	@RequestMapping(value = "/posts/category/{categoryId}", method = RequestMethod.GET)
	public String list(@PathVariable Integer categoryId, ModelMap map) {
		return "";
	}
}
