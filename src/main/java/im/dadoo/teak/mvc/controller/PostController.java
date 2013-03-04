package im.dadoo.teak.mvc.controller;

import im.dadoo.teak.mvc.model.Link;
import im.dadoo.teak.mvc.model.Post;
import im.dadoo.teak.mvc.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

	@Autowired
	private PostService pos;
	
	@RequestMapping(value = "/admin/post", method = RequestMethod.POST)
	public String add(@RequestParam String title, @RequestParam String author, 
			@RequestParam String content, @RequestParam int categoryId) {
		Post post = new Post(title, author, content, categoryId);
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
	public String update(@PathVariable int postId, @RequestParam String title, 
			@RequestParam String author, @RequestParam String content, 
			@RequestParam long publishTime, @RequestParam int categoryId) {
		Post post = new Post(title, author, content, publishTime, categoryId);
		post.setId(postId);
		this.pos.update(post);
		return "redirect:/admin/posts";
	}
	
	@RequestMapping(value = "/post/{postId}", method = RequestMethod.GET)
	public String getPost(@PathVariable long postId, ModelMap map) {
		Post post = this.pos.fetchByIdWithAll(postId);
		if (post != null) {
			map.addAttribute("post", post);
			return "post";
		}
		else {
			return "404";
		}
	}
}
